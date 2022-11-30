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
			
//			if(month==12 || month==1 || month==2) {
//				System.out.println("입력하신 개월은 겨울이네요");
//			}else if(month==3 || month==4 || month==5) {
//				System.out.println("입력하신 개월은 봄이네요");
//			}else if(month==6 || month==7 || month==8) {
//				System.out.println("입력하신 개월은 여름이네요");
//			}else if(month==9 || month==10 || month==11) {
//				System.out.println("입력하신 개월은 가을이네요");
//			}else {
//				System.out.println("유효한 개월 수가 아닙니다.");
//			}
//			scanner.close();
		}
	}

}
