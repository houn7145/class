package com.lec.ex06_wrapper;
// java com.lec.ex6_warapper.Ex02 10 20 30 1 ����
// ��� - ���� ���� ���� : 4
// 		���� ���� �� : 61
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("���� ���� ���� : " + args.length);
		int total = 0; // ���� ����
		for(int i = 0 ; i<args.length ; i++) {
			total += Integer.parseInt(args[i]);
			System.out.println(args[i]);
		}
		System.out.println("���� ����  : " + total);
	}
}
