package com.lec.loopQuiz;

import java.util.Scanner;

// 사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 단을 입력하세요: ");
		int num = scanner.nextInt();
		for(int i=1 ; i<=9 ; i++ ) {
			System.out.println(num+"*"+i+"="+(num*i));
			
		}
	}
}
