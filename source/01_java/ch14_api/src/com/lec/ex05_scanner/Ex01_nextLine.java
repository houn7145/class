package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int age = sc.nextInt();
		System.out.println("�Է��� ���̴� " + age + "��");
		System.out.println("�̸� : ");
		String name = sc.next();
		System.out.println("�Է��� �̸��� " + name);
		System.out.println("�ּ� : ");
		sc.nextLine(); // ���ۿ� �����ִ� "\n"�� �����
		String add = sc.nextLine(); // "\n"���� ���� return�ϰ� "\n"�ڴ� ����
		System.out.println("�Է��� �ּҴ� " + add);
		System.out.println("��");
		sc.close();
	}
}
