package com.lec.quiz;
//국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner kr = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요: ");
		int kr1 = kr.nextInt();
		Scanner en = new Scanner(System.in);
		System.out.print("영어점수를 입력하세요: ");
		int en1 = en.nextInt();
		Scanner ma = new Scanner(System.in);
		System.out.print("수학 점수를 입력하세요: ");
		int ma1 = ma.nextInt();
		
		System.out.printf("국어점수는 (%d), 영어점수는 (%d), 수학점수는 (%d)이며\n", kr1, en1, ma1);
		double tot = kr1+ma1+en1;
		System.out.printf("총점은 (%d), 평균은 (%.2f)입니다", kr1+ma1+en1 , tot/3);
		
	}

}
