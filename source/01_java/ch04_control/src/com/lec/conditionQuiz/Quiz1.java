package com.lec.conditionQuiz;

import java.util.Scanner;

// ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int num = scanner.nextInt();
		if(num>0) {
			System.out.printf("�Է��Ͻ� ��(%d)�� ���밪�� (%d)�Դϴ�",num,num);
		}else {
			System.out.printf("�Է��Ͻ� ��(%d)�� ���밪�� (%d)�Դϴ�",num,-(num));
		}
		
	}

}
