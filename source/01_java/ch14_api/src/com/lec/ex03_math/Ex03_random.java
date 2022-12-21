package com.lec.ex03_math;

import java.util.Random;

// Math.random() : 0.0 ~ 1.0 난수 발생(double)
// 0 <= Math.random() * 45 < 45
// 1 <= (int)(Math.random() * 45)+1 < 46
// Random random = new Random()
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1~45까지의 정수 난수를 발생 : " + (int)(Math.random() * 45+1));
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt()); // 정수 난수
		System.out.println("double 난수 : " + random.nextDouble()); // Math.random이랑 유사
		System.out.println("true or false 중 난수 : " + random.nextBoolean());
		System.out.println("0~100까지의 정수 난수 : " + random.nextInt(101));
		System.out.println("0~44까지의 정수 난수 : " + random.nextInt(45));
		System.out.println("1~45까지의 정수 난수 : " + (random.nextInt(45)+1)); // 스트링 계산 전 ()
		System.out.println("가위(0), 바위(1), 보자기(2) 중 하나 : " + random.nextInt(3));
	} 

}
