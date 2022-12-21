package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 원하는 단수(2~9) 구구단을 
//출력하는 프로그램을 구현하시오
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("몇 단을 출력 할까요? ");
			num = scanner.nextInt();
		} while (2 >= num || num >= 9); // 2단보다 작거나 9단보다 크면 다시 출력
		gugudan(num);
	}

	private static void gugudan(int s) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(s + "*" + i + "=" + (s * i));

			// for(int i=1 ; i<=9 ; i++ ) {
			// System.out.println(num+"*"+i+"="+(num*i));
		}

	}
}
