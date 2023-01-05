package com.lec.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� �Ѹ���, �ش� �μ��� ��������� ���
// 1. �ش� �μ���ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ�
// 2. �ش� �μ���ȣ�� �ִ� ��� : �μ� ������ ��� 
// 2-1. �ش� �μ� ����� �ִ� ��� : �������(���, �̸�, �޿�, ����̸�)�� ���
// 2-2. �ش� �μ� ����� ���� ��� : �ش� �μ� ����� �����ϴ�
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt1 = null, stmt2 = null;
		ResultSet rs1 = null, rs2 = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
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
				System.out.println(deptno + "�� �μ� ������ ������ �����ϴ�");
				System.out.println("�μ��� : " + dname);
				System.out.println("�μ���ġ : " + loc);
				if(rs2.next()) {
					System.out.println(deptno + "�� ��� ������ ������ �����ϴ�");
					do {
						String empno = rs2.getString("empno");
						String ename = rs2.getString("ename");
						int sal = rs2.getInt("sal");
						String manager = rs2.getString("manager");
						System.out.print("��� : " + empno + "\t");
						System.out.print("�̸� : " + ename + "\t");
						System.out.print("�޿� : " + sal + "\t") ;
						System.out.println("����̸� : " + manager);
					}while(rs2.next());
				}else {
					System.out.println("�ش� �μ� ����� �����ϴ�");
				}
			}else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�");
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
