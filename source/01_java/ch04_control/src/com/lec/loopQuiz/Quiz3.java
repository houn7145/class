package com.lec.loopQuiz;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ���
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� ���� �Է��ϼ���: ");
		int num = scanner.nextInt();
		for(int i=1 ; i<=9 ; i++ ) {
			System.out.println(num+"*"+i+"="+(num*i));
			
		}
	}
}
