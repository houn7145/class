package com.lec.ex03insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호 중복체크 후 부서명, 근무지를 입력받아 insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력할 부서 번호는 ? ");
		int deptno = sc.nextInt();
		String sql1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO =" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt == 0) {
				System.out.print("입력할 부서명은 ? ");
				String dname = sc.next();
				System.out.print("입력할 부서 위치는 ? ");
				String loc = sc.next();
				String sql2 = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int Ire = stmt.executeUpdate(sql2);
				System.out.println(Ire > 0 ? "입력성공" : "입력실패");
			} else {
				System.out.println("중복된 부서번호 입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
	}
}
