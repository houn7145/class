package com.lec.ex;

import java.util.Scanner;

// 5! = 5~1 전부 곱
// 1! = 1 계산은 양수만 입력
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇 !을 계산할까요? ");
		int num = scanner.nextInt();
		long result = factorial(num);
		System.out.println(num + "! = " + result);
	}
	private static long factorial(int s) {
		long result = 1; // 누적곱을 저장할 변수 (무조건 1)
		for(int i=s ; i>=1 ; i--) {
		result *= i; //result = result * i;
		}
		return result;
	}
}
