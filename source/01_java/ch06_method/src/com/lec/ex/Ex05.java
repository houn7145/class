package com.lec.ex;

import java.util.Scanner;

// 5! = 5~1 ���� ��
// 1! = 1 ����� ����� �Է�
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� !�� ����ұ��? ");
		int num = scanner.nextInt();
		long result = factorial(num);
		System.out.println(num + "! = " + result);
	}
	private static long factorial(int s) {
		long result = 1; // �������� ������ ���� (������ 1)
		for(int i=s ; i>=1 ; i--) {
		result *= i; //result = result * i;
		}
		return result;
	}
}
