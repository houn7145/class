package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� 
//����ϴ� ���α׷��� �����Ͻÿ�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("�� ���� ��� �ұ��? ");
			num = scanner.nextInt();
		} while (2 >= num || num >= 9); // 2�ܺ��� �۰ų� 9�ܺ��� ũ�� �ٽ� ���
		gugudan(num);
	}

	private static void gugudan(int s) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(s + "*" + i + "=" + (s * i));

			// for(int i=1 ; i<=9 ; i++ ) {
			// System.out.println(num+"*"+i+"="+(num*i));
		}

	}
}
