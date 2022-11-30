package com.lec.conditionQuiz;

import java.util.Scanner;

// 현재 몇월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램을 구현하세요
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("몇월인지 숫자만 입력하세요: ");
		int mon = scanner.nextInt();
		switch(mon) {
		case 3: case 4: case 5:
			System.out.printf("입력하신 %d월은 봄 입니다", mon);break;
		case 6: case 7: case 8:
			System.out.printf("입력하신 %d월은 여름 입니다", mon);break;
		case 9: case 10: case 11:
			System.out.printf("입력하신 %d월은 가을 입니다", mon);break;
		case 12: case 1: case 2:
			System.out.printf("입력하신 %d월은 겨울 입니다", mon);break;
		default:
			System.out.println("유효하지 않는 개월입니다");
		}
	}

}
