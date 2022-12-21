package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.println("입력한 나이는 " + age + "살");
		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("입력한 이름은 " + name);
		System.out.println("주소 : ");
		sc.nextLine(); // 버퍼에 남이있는 "\n"을 지우기
		String add = sc.nextLine(); // "\n"앞의 값을 return하고 "\n"뒤는 지움
		System.out.println("입력한 주소는 " + add);
		System.out.println("끝");
		sc.close();
	}
}
