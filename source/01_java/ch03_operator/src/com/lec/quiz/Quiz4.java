package com.lec.quiz;
//���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ���: ");
		int su = sc.nextInt();
		String result = (su>=65)? "��ο��":"�Ϲ�";
		System.out.printf("�Է��Ͻ� ����(%d)�� %s �Դϴ�", su, result);
	}

}
