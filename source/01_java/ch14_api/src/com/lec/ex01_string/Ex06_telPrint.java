package com.lec.ex01_string;

import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		while (true) { // 010-8888-7777
			System.out.println("��ȭ��ȣ�� �Է��ϼ���(����� x) : ");
			tel = scanner.next();
			if (tel.equalsIgnoreCase("x")) {
				System.out.println("����");
				break;
			}
			System.out.println("�Է��� ��ȭ��ȣ : " + tel);
			System.out.print("¦����° ���ڿ� : ");
			
			for (int i = 0; i < tel.length(); i++) {

				if (i % 2 == 0) {
					System.out.printf("%s ", tel.charAt(i));
				}
			}
			System.out.println();
			System.out.print("��ȭ��ȣ �Ųٷ� : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.printf("%s", tel.charAt(i));
			}
			System.out.println();
			System.out.println("��ȭ��ȣ �� ���ڸ��� : " + tel.substring(tel.indexOf("0"), tel.indexOf("-")));
			System.out.println("��ȭ��ȣ �� �ڸ��� : " + tel.substring(tel.lastIndexOf("-") + 1));
		}
	}
}
