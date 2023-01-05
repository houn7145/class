package com.lec.ex06preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 입력받은 부서번호 중복체크후 부서명, 근무지를 입력받아 insert
// 단 중복된 부서번호 일 경우 계속 받음
public class EX2_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String insertQuery = "INSERT INTO DEPT VALUES (?, ?, ?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.print("입력할 부서번호는 ?");
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); // 매개변수안에 빈칸
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("중복된 부서번호는 입력 불가합니다");
			} else {
				System.out.print("입력할 부서명은 ?");
				String dname = sc.next();
				System.out.print("입력할 부서 위치는 ?");
				String loc = sc.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "입력성공" : "입력실패");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("중복된 부서번호이거나 길게 입력한 경우 : " + e.getMessage());
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