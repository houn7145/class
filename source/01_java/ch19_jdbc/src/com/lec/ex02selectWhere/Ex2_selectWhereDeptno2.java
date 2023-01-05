package com.lec.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 받아 부서정보를 뿌리고, 해당 부서의 사원정보도 출력
// 1. 해당 부서번호가 없는 경우 : 존재하지 않는 부서입니다
// 2. 해당 부서번호가 있는 경우 : 부서 정보를 출력 
// 2-1. 해당 부서 사원이 있는 경우 : 사원정보(사번, 이름, 급여, 상사이름)를 출력
// 2-2. 해당 부서 사원이 없는 경우 : 해당 부서 사원이 없습니다
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt1 = null, stmt2 = null;
		ResultSet rs1 = null, rs2 = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서번호는 ?");
		int deptno = sc.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER FROM EMP W, EMP M WHERE W.MGR = M.EMPNO AND W.DEPTNO =" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt1 = conn.createStatement();
			stmt2 = conn.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			rs2 = stmt2.executeQuery(sql2);
			if(rs1.next()) {
				String dname = rs1.getString(1);
				String loc 	 = rs1.getString(2);
				System.out.println(deptno + "번 부서 정보는 다음과 같습니다");
				System.out.println("부서명 : " + dname);
				System.out.println("부서위치 : " + loc);
				if(rs2.next()) {
					System.out.println(deptno + "번 사원 정보는 다음과 같습니다");
					do {
						String empno = rs2.getString("empno");
						String ename = rs2.getString("ename");
						int sal = rs2.getInt("sal");
						String manager = rs2.getString("manager");
						System.out.print("사번 : " + empno + "\t");
						System.out.print("이름 : " + ename + "\t");
						System.out.print("급여 : " + sal + "\t") ;
						System.out.println("상사이름 : " + manager);
					}while(rs2.next());
				}else {
					System.out.println("해당 부서 사원이 없습니다");
				}
			}else {
				System.out.println("해당 부서가 존재하지 않습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs2!=null) rs2.close();
				if(rs1!=null) rs1.close();
				if(stmt2!=null) stmt2.close();
				if(stmt1!=null) stmt1.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
