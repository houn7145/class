package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05_juminNo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		String sc;
		sc = scanner.next();
		char gender = sc.charAt(7);
		if(gender=='1' || gender=='3') {
			System.out.println("�����Դϴ�");
			
		}else if(gender=='2' || gender=='4') {
			System.out.println("�����Դϴ�");
		}else
			System.out.println("�ùٸ��� ���� �ֹι�ȣ �Դϴ�");
	
			// ���2 String���� ����
			String genderStr = sc.substring(7,8); // "2"
			if(genderStr.equals("1") || genderStr.equals("3")) {
				System.out.println("�����̽ñ���");
			}else if(genderStr.equals("2") || genderStr.equals("4")) {
				System.out.println("�����̽ñ���");
			}else {
				System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�");
			}
			// ���3. genderStr�� ������ ��ȯ
			int genderInt = Integer.parseInt(genderStr); // ������Ʈ���� ������ ("2"�� 2��)
			if(genderInt==1 || genderInt ==3) {
				System.out.println("�����̽ñ���");
			}else if(genderInt == 2 || genderInt== 4) {
				System.out.println("�����̽ñ���");
			}else {
				System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�");
			}
		}
}
