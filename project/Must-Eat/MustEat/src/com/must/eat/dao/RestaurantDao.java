package com.must.eat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.must.eat.dto.RavgDto;
import com.must.eat.dto.RestaurantDto;

public class RestaurantDao {
	public static final int SUCCESS = 1; // 등록 성공;
	public static final int FAIL = 0; // 등록 실패;
	private DataSource ds;
	
	public RestaurantDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// -- 1-1. 맛집 리스트 보기 - 페이징 
	public ArrayList<RestaurantDto> getRestaurantList(int startRow, int endRow) {
		ArrayList<RestaurantDto> Restaurants = new ArrayList<RestaurantDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM RESTAURANT ORDER BY RRDATE DESC)A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rno = rs.getInt("rno");
				String mid = rs.getString("mid");
				int cno = rs.getInt("cno");
				String rname = rs.getString("rname");
				String rcontent = rs.getString("rcontent");
				String rplace = rs.getString("rcontent");
				String mainimg = rs.getString("mainimg");
				String subimg1 = rs.getString("subimg1");
				String subimg2 = rs.getString("subimg2");
				String rtel = rs.getString("rtel");
				Restaurants.add(new RestaurantDto(rno, mid, cno, rname, rcontent, rplace, mainimg, subimg1, subimg2, rtel, 0, null, 0));
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
		return Restaurants;
	}
	
	// -- 1-2. 페이징시 필요한 등록한 맛집 갯수
	public int getRestaurantTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM RESTAURANT";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
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
		return totCnt;
	}
	
	// -- 2. 맛집 등록
	public int insertRestaurant(RestaurantDto dto) {
		int result = FAIL;
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RESTAURANT (RNO, MID, CNO, RPLACE, RNAME, RCONTENT, MAINIMG, SUBIMG1, SUBIMG2, RTEL)" + 
				"    VALUES (RES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setInt(2, dto.getCno());
			pstmt.setString(3, dto.getRplace());
			pstmt.setString(4, dto.getRname());
			pstmt.setString(5, dto.getRcontent());
			pstmt.setString(6, dto.getMainimg());
			pstmt.setString(7, dto.getSubimg1());
			pstmt.setString(8, dto.getSubimg2());
			pstmt.setString(9, dto.getRtel());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("등록 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "등록 실패");
		} finally {
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
	
	// -- 3. 등록한 맛집 수정
	public int modifyRestaurant(RestaurantDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RESTAURANT SET CNO = ?," + 
				"                      RPLACE = ?," + 
				"                      RNAME = ?," + 
				"                      RCONTENT = ?," + 
				"                      MAINIMG = ?," + 
				"                      SUBIMG1 = ?," + 
				"                      SUBIMG2 = ?," + 
				"                      RTEL = ?" + 
				"    WHERE RNO = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCno());
			pstmt.setString(2, dto.getRplace());
			pstmt.setString(3, dto.getRname());
			pstmt.setString(4, dto.getRcontent());
			pstmt.setString(5, dto.getMainimg());
			pstmt.setString(6, dto.getSubimg1());
			pstmt.setString(7, dto.getSubimg2());
			pstmt.setString(8, dto.getRtel());
			pstmt.setInt(9, dto.getRno());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("정보수정 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "정보수정 실패");
		} finally {
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
	
	// -- 4. 등록한 맛집 삭제
	public int DeleteRestaurant(String rno) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RESTAURANT WHERE RNO = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rno);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("맛집삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "맛집삭제 실패");
		} finally {
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
	
	// -- 5-1. 평점 등록
	public int insertRavg(RavgDto dto) {
		int result = FAIL;
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RAVG (ANO, RNO, AVG)" + 
				"    VALUES (RAVG_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRno());
			pstmt.setDouble(2, dto.getAvg());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("평점등록 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "평점등록 실패");
		} finally {
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
	
	// -- 5-2. 평점 등록 횟수 업데이트
	public void avgHitUp(int rno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RESTAURANT SET AVGHIT = AVGHIT + 1" + 
				"    WHERE RNO = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.executeUpdate();
			System.out.println("횟수 업데이트 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "횟수 업데이트 실패");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// -- 6. 평점 출력
	public int avg(int rno) {
		int avgResult = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT AVG(AVG) FROM RAVG WHERE RNO = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, rno);
			rs.next();
			avgResult = rs.getInt(1);
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
		return avgResult;
	}
	
	// -- 7. 맛집 클릭시 상세보기
	public RestaurantDto getRestaurant(int rno) {
		RestaurantDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RNO = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				int cno = rs.getInt("cno");
				String rname = rs.getString("rname");
				String rcontent = rs.getString("rcontent");
				String rplace = rs.getString("rplace");
				String mainimg = rs.getString("mainimg");
				String subimg1 = rs.getString("subimg1");
				String subimg2 = rs.getString("subimg2");
				String rtel = rs.getString("rtel");
				int rhit = rs.getInt("rhit");
				Timestamp rrdate = rs.getTimestamp("rrdate");
				int avghit = rs.getInt("avghit");
				dto = new RestaurantDto(rno, mid, cno, rname, rcontent, rplace, mainimg, subimg1, subimg2, rtel, rhit, rrdate, avghit);
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
		return dto;
	}
	// -- 8. 맛집 이름으로 검색 
	public ArrayList<RestaurantDto> getSchRestaurant(String rname){
		ArrayList<RestaurantDto> dtos = new ArrayList<RestaurantDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RNAME LIKE '%' || ? || '%'";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rno = rs.getInt("rno");
				String mid = rs.getString("mid");
				int cno = rs.getInt("cno");
				String rcontent = rs.getString("rcontent");
				String rplace = rs.getString("rplace");
				String mainimg = rs.getString("mainimg");
				String subimg1 = rs.getString("subimg1");
				String subimg2 = rs.getString("subimg2");
				String rtel = rs.getString("rtel");
				int rhit = rs.getInt("rhit");
				Timestamp rrdate = rs.getTimestamp("rrdate");
				int avghit = rs.getInt("avghit");
				dtos.add(new RestaurantDto(rno, mid, cno, rname, rcontent, rplace, mainimg, subimg1, subimg2, rtel, rhit, rrdate, avghit));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dtos;
	}
}