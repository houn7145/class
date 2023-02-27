package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.member.MemberDao;

public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int CUSTOMER_NONEEXISTENT = 1;	// 사용가능 id
	public static final int CUSTOMER_EXISTENT = 0; // 중복된 id
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공 {
	public static final int LOGIN_FAIL = 0; // 로그인 실패
	
	private static CustomerDao instance = new CustomerDao();
	public static CustomerDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 회원가입시 ID 중복체크 : 
		public int confirmId(String cID) {
			int result = CUSTOMER_EXISTENT;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String  sql = "SELECT COUNT(*) cnt FROM CUSTOMER WHERE CID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cID);
				rs = pstmt.executeQuery();
				rs.next();
				int n = rs.getInt(1);
				if(n == 0) {
					result = CUSTOMER_NONEEXISTENT;
				} else {
					result = CUSTOMER_EXISTENT;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		 // 2. 회원가입 : 
		public int joinCustomer(CustomerDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, cEMAIL, CADDRESS, CBIRTH, CGENDER) " + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getCpw());
				pstmt.setString(3, dto.getCname());
				pstmt.setString(4, dto.getCtel());
				pstmt.setString(5, dto.getCemail());
				pstmt.setString(6, dto.getCaddress());
				pstmt.setDate(7, dto.getCbirth());
				pstmt.setString(8, dto.getCgender());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("회원가입 실패 : " + dto);
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		public int loginCheck(String cid, String cpw) {
			int result = LOGIN_FAIL;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM CUSTOMER "
					+ "WHERE CID=? AND CPW=?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cid);
				pstmt.setString(2, cpw);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					// cid와 cpw가 올바른 경우
					result = LOGIN_SUCCESS;
				}else {
					// cid나 cpw가 틀린 경우
					result = LOGIN_FAIL;
				}			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs    != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		// 4. cid로 DTO 가져오기 : 
		public CustomerDto getCustomer(String cid) {
			CustomerDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String cPw = rs.getString("cPw");
					String cNname = rs.getString("cName");
					String cTel = rs.getString("cTel");
					String cEmail = rs.getString("cEmail");
					String cAddress = rs.getString("cAddress");
					String cGender = rs.getString("cGender");
					Date cBirth = rs.getDate("cbirth");
					Date cRdate = rs.getDate("cRdate");
					dto = new CustomerDto(cid, cPw, cNname, cTel, cEmail, cAddress, cGender, cBirth, cRdate);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return dto;
		}
		// 5. 정보수정 : 
		public int modifyCustomer(CustomerDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE CUSTOMER SET CPW = ?, " + 
					"                CNAME = ?," + 
					"                CTEL = ?," + 
					"                CEMAIL = ?," + 
					"                CADDRESS = ?," + 
					"                CBIRTH = ?," + 
					"                CGENDER = ?" + 
					"        WHERE CID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  dto.getCpw());
				pstmt.setString(2, dto.getCname());
				pstmt.setString(3, dto.getCtel());
				pstmt.setString(4, dto.getCemail());
				pstmt.setString(5, dto.getCaddress());
				pstmt.setDate(6, dto.getCbirth());
				pstmt.setString(7, dto.getCgender());
				pstmt.setString(8, dto.getCid());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "정보수정 성공" : "정보수정 실패(id(" + dto.getCid() + ")가 없음)");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
}
