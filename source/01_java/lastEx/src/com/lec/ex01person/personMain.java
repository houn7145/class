package com.lec.ex01person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class personMain {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null; // 1, 2�� ���
		Statement stmt = null; // 3�� ���, �������(jobs)
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // ������� ����
		// ��������� jobs�� add
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver); // (1)����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement();// (3)
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println("e:" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		} // ������ ��������
		System.out.println(jobs);
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch (fn) {
			case "1": // �̸�, ������(jobs), ��,��, �� �޾� insert
				sql = "INSERT INTO PERSON " + "    VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), " + " ?, ?, ?)";
				try {
					// 1�ܰ� ����̹��ε�� �ѹ��� �ϸ� ��(������ ����)
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
					pstmt = conn.prepareStatement(sql);
					System.out.print("�Է��ϰ��� �ϴ� �̸��� ?");
					String pname = sc.next();
					pstmt.setString(1, pname);
					System.out.print("�Է��ϰ��� �ϴ� �������� ?");
					System.out.println(jobs);
					String jname = sc.next();
					pstmt.setString(2, jname);
					System.out.print("���� ������ ?");
					int kor = sc.nextInt();
					pstmt.setInt(3, kor);
					System.out.print("���� ������ ?");
					int eng = sc.nextInt();
					pstmt.setInt(4, eng);
					System.out.print("���� ������ ?");
					int mat = sc.nextInt();
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // ������޾� ���� ���
				sql = "SELECT ROWNUM||'��' RN, S.*" + "    FROM(SELECT P.PNAME, JNAME, KOR, ENG, MAT,SUM"
						+ "    FROM PERSON P,JOB J,(SELECT PNAME, KOR+ENG+MAT SUM"
						+ "    FROM PERSON ORDER BY SUM DESC)A"
						+ "    WHERE P.PNAME = A.PNAME AND P.JNO = J.JNO AND JNAME = UPPER(?)"
						+ "    ORDER BY SUM DESC)S";
				try {
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
					pstmt = conn.prepareStatement(sql);
					System.out.print("����ϰ��� �ϴ� �������� ?");
					System.out.println(jobs);
					String jname = sc.next();
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) { // �ش�μ� ��� ����Ʈ ���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							String rn = rs.getString("rn");
							String pname = rs.getString("pname");
							jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname, kor, eng, mat, sum);
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ ���� �������� �����ϴ�");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
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
				break;
			case "3":
				sql = "SELECT RN||'��' RN, P.PNAME, JNAME, P.KOR, P.ENG, P.MAT, SUM"
						+ "    FROM JOB J, PERSON P,(SELECT ROWNUM RN, PNAME, SUM"
						+ "    FROM(SELECT PNAME, KOR+ENG+MAT SUM FROM PERSON ORDER BY SUM DESC))A"
						+ "    WHERE J.JNO=P.JNO AND A.PNAME = P.PNAME";
				try {
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) { // �ش�μ� ��� ����Ʈ ���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							String rn = rs.getString("rn");
							String pname = rs.getString("pname");
							String jname1 = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname1, kor, eng, mat, sum);
						} while (rs.next());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
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
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
