package com.lec.ex01_string;
// ��ȭ��ȣ ���ڸ��� �Է¹޾� �˻��� ��ȭ��ȣ(�ߺ��� ���ڸ� ����)�� ���� ���

import java.util.Scanner;
public class Ex07_searchPostTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "02-717-8888", "010-7777-8888", "010-6666-8888"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false; // �˻��� ����� ������ true
			System.out.print("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ��� �Է��ϼ��� (�շ�� x�� �Է�): ");
			String searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(int i=0 ; i<tels.length ; i++) {
			//	int idx = tels[i].lastIndexOf("-"); //8,6,....
			//	String postTel= tels[i].substring(idx+1);
			//	System.out.println(i+"��° ���ڸ� : " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-")+1);
				if(postTel.equals(searchTel)) {
					System.out.println("�˻��Ͻ� ��ȭ��ȣ�� : " + tels[i] );
					searchOk = true; // ��ȭ��ȣ ��¿���
				}
			}
			if(!searchOk) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ ���ڸ��� �����ϴ�");
			}
		}
	}
}
