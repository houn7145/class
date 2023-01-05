package com.lec.ex03insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �Է¹��� �μ���ȣ �ߺ�üũ �� �μ���, �ٹ����� �Է¹޾� insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("�Է��� �μ� ��ȣ�� ? ");
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
				System.out.print("�Է��� �μ����� ? ");
				String dname = sc.next();
				System.out.print("�Է��� �μ� ��ġ�� ? ");
				String loc = sc.next();
				String sql2 = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int Ire = stmt.executeUpdate(sql2);
				System.out.println(Ire > 0 ? "�Է¼���" : "�Է½���");
			} else {
				System.out.println("�ߺ��� �μ���ȣ �Դϴ�");
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
