package com.lec.conditionQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�
// ��, ����ڴ� ������� 0, ������� 1, ����� 2�� �Է�
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���������� ������ �����մϴ�");
		System.out.println("����(0), ����(1), ��(2)�� �ϳ��� �����ϼ��� :");
		int you = scanner.nextInt(); 
		
		
		if(you == 0) {
			System.out.printf("����� ����(%d)�� �½��ϴ�\n", you);
		}else if(you == 1) {
			System.out.printf("����� ����(%d)�� �½��ϴ�\n", you);
		}else {
			System.out.printf("����� ��(%d)�� �½��ϴ�\n", you);
		}
			
		if(com == 0) {
				System.out.printf("��ǻ�ʹ� ����(%d)�� �½��ϴ�\n", com);
			}else if(com == 1) {
				System.out.printf("��ǻ�ʹ� ����(%d)�� �½��ϴ�\n", com);
			}else {
				System.out.printf("��ǻ�ʹ� ��(%d)�� �½��ϴ�\n", com);
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
