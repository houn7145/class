package com.lec.loophomework;

import java.util.Scanner;

//��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
//(��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�)
public class Homework1 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ��� (����: -1)");
		int you = scanner.nextInt();
		
		if(you<-1 || you>2) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ�");
		}else if(you == 0) {
			System.out.printf("����� ����(%d)�� �½��ϴ�\n", you);
		}else if(you == 1) {
			System.out.printf("����� ����(%d)�� �½��ϴ�\n", you);
		}else {
			System.out.printf("����� ��(%d)�� �½��ϴ�\n", you);
		}
			
		if((you+2)%3 == com) {
			System.out.println("����� �̰���ϴ�");
		}else if((you+1)%3 == com) {
			System.out.println("����� �����ϴ�");
		}else {
			System.out.println("�����ϴ�");
		}

	}
}
