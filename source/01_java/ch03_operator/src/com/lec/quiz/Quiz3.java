package com.lec.quiz;
// �μ��� �Է¹޾� 
// �� ���� ������ ����� O�� X�� ���
// ù��° ���� �� ū�� ����� O�� X�� ���
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ���: ");
		int su = sc.nextInt();
		Scanner st = new Scanner(System.in);
		System.out.print("�ι�° ���� �Է��ϼ���: ");
		int sy= st.nextInt();
		
		String result1 = (su==sy) ? "O" : "X";
		System.out.printf("�Է��Ͻ� �� ��(%d, %d)�� ���� �������� %s\n", su, sy, result1);
		String result2 = (su>sy) ? "O" : "X";
		System.out.printf("�Է��Ͻ� �� ��(%d, %d)�� ù��° ���� �� ū���� %s\n", su, sy, result2);
		
	}

}
