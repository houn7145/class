package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	private final int SUCCESS = 1;
	private final int FAIL = 0;
	private DataSource ds;

	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 글목록(startRow ~ endRow까지)
	public ArrayList<BoardDto> list(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM(SELECT ROWNUM RN, A.* FROM (SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A)"
				+ "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				dtos.add(
						new BoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip));
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
		return dtos;
	}

	// 2. 전체 글 갯수
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
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

	// 3. 원글 쓰기
	public int write(String mid, String ftitle, String fcontent, String ffilename, String fip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ftitle);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setString(5, fip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패");
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
	// 4. fID로 조회수 1 올리기
		private void hitUp(int fid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE FILEBOARD SET FHIT = FHIT + 1" + 
				    " WHERE FID = ?";
;
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fid);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + " 조회수 올리기 실패");
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		public BoardDto content(int fid) {
			BoardDto dto = null;
			hitUp(fid); // 글 상세보기 시 조회수 1 올림
			Connection 		  conn 	= null;
			PreparedStatement pstmt = null;
			ResultSet		  rs 	= null;
			String sql = "SELECT * FROM FILEBOARD WHERE FID = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fid);
				rs = pstmt.executeQuery();
				if(rs.next()) { // 결과값이 1줄이거나 0줄이기에 if
					String bname	= rs.getString("bname");
					String btitle	= rs.getString("btitle");
					String bcontent	= rs.getString("bcontent");
					Date bdate = rs.getDate("bdate");
					int bhit		= rs.getInt("bhit");
					int bgroup		= rs.getInt("bgroup");
					int bstep		= rs.getInt("bstep");
					int bindent		= rs.getInt("bindent");
					String bip		= rs.getString("bip");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs 	 != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return dto;
		}
	// 10. -- 10. 회원탈퇴시 탈퇴하는 회원의 mid로 작성한 글 전부 삭제
	public void deleteBoardList(String mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			System.out.println("글삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글삭제 실패");
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
}
