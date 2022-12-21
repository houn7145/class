package com.lec.ex01_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // 사용자에게 입력받을 수를 저장
		System.out.print("첫번째 정수는? ");
		do {
			try {
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("수에 문자를 넣지 마세요");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		} while (true);
		System.out.print("두번째 정수는? ");
		try { // 예외가 생길 수 있는 부분을 다 넣음
			j = scanner.nextInt();
			System.out.println("i / j = " + (i / j)); // 예외가 발생할 수도 있는 부분
		} catch (ArithmeticException e) { // 예외가 발생 했을때만 실행하는 부분
			System.out.println(e.getMessage()); // 예외메세지 출력
			// e.printStackTrace(); // 더 자세히 나옴
		} catch (InputMismatchException e) { // 상위 클래스는 아래에 배치
			System.out.println("예외 메세지 :" + e.getMessage());
			System.out.println("두번째 정수를 잘못 입력하셔서 1로 처리합니다");
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("끝");
		scanner.close();
	}
}
