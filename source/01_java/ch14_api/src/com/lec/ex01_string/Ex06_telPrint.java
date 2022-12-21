package com.lec.ex01_string;

import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		while (true) { // 010-8888-7777
			System.out.println("전화번호를 입력하세요(종료는 x) : ");
			tel = scanner.next();
			if (tel.equalsIgnoreCase("x")) {
				System.out.println("종료");
				break;
			}
			System.out.println("입력한 전화번호 : " + tel);
			System.out.print("짝수번째 문자열 : ");
			
			for (int i = 0; i < tel.length(); i++) {

				if (i % 2 == 0) {
					System.out.printf("%s ", tel.charAt(i));
				}
			}
			System.out.println();
			System.out.print("전화번호 거꾸로 : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.printf("%s", tel.charAt(i));
			}
			System.out.println();
			System.out.println("전화번호 맨 앞자리는 : " + tel.substring(tel.indexOf("0"), tel.indexOf("-")));
			System.out.println("전화번호 뒷 자리는 : " + tel.substring(tel.lastIndexOf("-") + 1));
		}
	}
}
