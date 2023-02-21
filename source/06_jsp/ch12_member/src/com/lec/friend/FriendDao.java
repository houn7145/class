package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDao {
	public static final int SUCCESS = 1; // 친구 추가 성공
	public static final int FAIL = 0; // 친구 추가 실패
	
	private static FriendDao instance = new FriendDao();
	public static FriendDao getInstance() {
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
	// 1. 친구 추가
	public int inputFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND (NO, NAME, TEL)" + 
				"    VALUES (FRIEND_NO_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dto.getName());
			pstmt.setString(2,  dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "친구추가 성공" : "친구추가 실패" + dto);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패 : " + dto);
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
	// 2. 친구 목록 출력
	public ArrayList<FriendDto> friendList(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM FRIEND";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				dtos.add(new FriendDto(no, name, tel));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3. 친구 검색
	public ArrayList<FriendDto> schFriend(String schName, String schTel){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schTel);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				dtos.add(new FriendDto(no, name, tel));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}