package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ּҴ� : " );
		// sc.nextLine(); // nextLine�� ó�� ���� ���� ���� ����� �ʿ� x
		System.out.println();
		String add = sc.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� " + add);
		System.out.println("���̴� : ");
		int age = sc.nextInt();
		System.out.println("�Է��Ͻ� ���̴� " + age);
		System.out.println("�̸��� : ");
		// ���� ���ۿ� "\n"�� �ִ� ����
		sc.nextLine(); // ���� �����
		String name = sc.nextLine();
		System.out.println("�Է��Ͻ� �̸��� " + name);
		System.out.println("���α׷� ��");
	}

}
