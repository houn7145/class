package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		int kr = 100;
		int ma = 99;
		int en = 100;
		System.out.printf("국어점수:%d\t수학점수:%d\t영어점수:%d\n", kr, ma, en );
		System.out.println("총점 = " + (kr+ma+en) );
		double total = kr+ma+en;
		System.out.println("평균 = " + (total/3.) );
	}

}
