package com.lec.quiz;
//����, ����, ���� ������ ����ڿ��� �Է¹޾�, �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner kr = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���: ");
		int kr1 = kr.nextInt();
		Scanner en = new Scanner(System.in);
		System.out.print("���������� �Է��ϼ���: ");
		int en1 = en.nextInt();
		Scanner ma = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���: ");
		int ma1 = ma.nextInt();
		
		System.out.printf("���������� (%d), ���������� (%d), ���������� (%d)�̸�\n", kr1, en1, ma1);
		double tot = kr1+ma1+en1;
		System.out.printf("������ (%d), ����� (%.2f)�Դϴ�", kr1+ma1+en1 , tot/3);
		
	}

}
