package com.lec.quiz;

import java.util.Scanner;
import java.util.Random;

// you�� �� ������ �ݺ�
public class Homework2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int you;
		int computer;
		String youStr;
		String computerStr;
		final int NOTHING = 3;
		do {
			System.out.println("����,����,�� �� �ϳ��� �����ϼ���");
			youStr = scanner.next().trim();
			computer = random.nextInt(3);
			computerStr = (computer == 0) ? "����" : (computer == 1) ? "����" : "���ڱ�";
			
			if(youStr.equals("����")) {
				you = 0;
			}else if(youStr.equals("����")) {
				you = 1;
			}else if(youStr.equals("��")) {
				you = 2;
			}else {
				you = NOTHING;
				continue;
			}
			
			if((you + 2) % 3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� \n", youStr, computerStr);
			} else if (you == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n", youStr, computerStr);
			} else {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� \n", youStr, computerStr);
			}

		} while (you == NOTHING || (you + 2) % 3 != computer);// do~while
		scanner.close();
		System.out.println("BYE");
	}// main
}// class
