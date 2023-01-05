package com.lec.ex06preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재하는 부서번호인지 확인 후, 부서명, 근무지를 입력받아 update
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT COUNT(*) CNT FROM  DEPT WHERE DEPTNO =?";
		String sql2 = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?";
		try {
			System.out.print("수정할 부서 번호는 ? ");
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("수정할 부서명은 ? ");
				pstmt.setString(1, sc.next());
				System.out.print("수정할 부서 위치는 ? ");
				pstmt.setString(2, sc.next());
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? deptno + "번 부서정보 수정성공" : "수정실패");
			} else {
				System.out.println("없는 부서번호 입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
	}
}
