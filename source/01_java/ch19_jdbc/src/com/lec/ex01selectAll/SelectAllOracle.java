package com.lec.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "SELECT * FROM EMP";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver); // 1 ����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2 DB����
			stmt = conn.createStatement(); // 3 SQL���۰�ü
			rs	 = stmt.executeQuery(sql); // 4,5 SQL����+���۰�� �ޱ�
			if(rs.next()) { // select ����� 1�� �̻�
				System.out.println("���\t�̸�\t��å\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
				do {
					int 	empno = rs.getInt(1);
					String 	ename = rs.getString("ename");
					String	job	  = rs.getString(3);
					String	mgr	  = rs.getString(4);
					//String	hiredate = rs.getString(5);
					Date	hiredate = rs.getDate(5);
					Timestamp hiredate1 = rs.getTimestamp(5);
					int 	sal	  = rs.getInt(6);
					int		comm  = rs.getInt(7);
					int		deptno = rs.getInt(8);
					System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
					//System.out.print(hiredate + "\t" + hiredate1);
				}while(rs.next());
			}else { // select ����� 1�൵ ���� ���
				System.out.println("��ϵ� ��� ������ �����ϴ�");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
