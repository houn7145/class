package com.lec.ex02person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 메소드1, 메소드2, 메소드3, 메소드4
public class PersonDao {
	// 변수 - 생성자 - 메소드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private static PersonDao INSTANCE;

	public static PersonDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}

	private PersonDao() {
		try {
			Class.forName(driver); // 1단계는 생성자에서 한번
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 기능 dto(이름, 직업명, 국, 영, 수)를 받아 DB에 insert하고 SUCCESS/FAIL을 return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
		// DB insert하고 결과를 result에 할당
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

	// 2번 기능 직업명을 받아 DB에 select한 결과를 ArrayList<PersonDto> return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB에 결과를 dtos에 add한다
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RN, S.* "
				+ "    FROM(SELECT P.PNAME||'('||PNO||'번)'PNAME, JNAME, KOR, ENG, MAT, SUM "
				+ "            FROM PERSON P,JOB J,(SELECT PNAME, KOR+ENG+MAT SUM "
				+ "                                    FROM PERSON ORDER BY SUM DESC)A "
				+ "                                    WHERE P.PNAME = A.PNAME AND P.JNO = J.JNO AND JNAME = ?"
				+ "                                    ORDER BY SUM DESC)S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String rank = rs.getString("rn");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
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

	// 3번 기능 DB에 전체 select한 결과를 ArrayList<PersonDto> return
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT RN||'등' RN, P.PNAME||'('||PNO||')'PNAME, JNAME, P.KOR, P.ENG, P.MAT, SUM "
				+ "    FROM JOB J, PERSON P,(SELECT ROWNUM RN, PNAME, SUM "
				+ "        FROM(SELECT PNAME, KOR+ENG+MAT SUM FROM PERSON ORDER BY SUM DESC))A "
				+ "    WHERE J.JNO=P.JNO AND A.PNAME = P.PNAME";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PersonDto dto = new PersonDto(); // ★dto 객체생성은 while문 안에
				dto.setRank(rs.getString("rn"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// 4번 기능 jnames들을 ArrayList<String>로 return
	public ArrayList<String> jnamelist() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jnames.add(rs.getString("jname"));
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
		return jnames;
	}
}
