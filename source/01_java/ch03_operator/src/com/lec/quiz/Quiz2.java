package com.lec.quiz;
//�Է��� ���� ¦������ Ȧ������ ���
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int su = sc.nextInt();
		String result = (su %2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		System.out.printf("�Է��Ͻ� ��(%d)��  %s\n", su, result);
		sc.close();
		
	}
}
