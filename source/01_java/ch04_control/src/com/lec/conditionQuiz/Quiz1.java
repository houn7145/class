package com.lec.conditionQuiz;

import java.util.Scanner;

// 수를 입력받아 절대값을 출력하는 프로그램
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 입력하세요");
		int num = scanner.nextInt();
		if(num>0) {
			System.out.printf("입력하신 수(%d)의 절대값은 (%d)입니다",num,num);
		}else {
			System.out.printf("입력하신 수(%d)의 절대값은 (%d)입니다",num,-(num));
		}
		
	}

}
