package com.lec.condition;

import java.util.Scanner;

// �Է¹��� ���� Ȧ������ ¦������ ���
public class Ex06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���: ");
		int num = scanner.nextInt();
		if(num%2==0) {
			System.out.println("¦���Դϴ�");
		}else {
			System.out.println("Ȧ���Դϴ�");
		}
	}
}
