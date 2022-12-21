package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주소는 : " );
		// sc.nextLine(); // nextLine을 처음 받을 때는 버퍼 지우기 필요 x
		System.out.println();
		String add = sc.nextLine();
		System.out.println("입력하신 주소는 " + add);
		System.out.println("나이는 : ");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는 " + age);
		System.out.println("이름은 : ");
		// 현재 버퍼에 "\n"이 있는 상태
		sc.nextLine(); // 버퍼 지우기
		String name = sc.nextLine();
		System.out.println("입력하신 이름은 " + name);
		System.out.println("프로그램 끝");
	}

}
