package com.lec.quiz;

import java.util.Scanner;
import java.util.Random;

// you가 질 때까지 반복
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
			System.out.println("가위,바위,보 중 하나를 선택하세요");
			youStr = scanner.next().trim();
			computer = random.nextInt(3);
			computerStr = (computer == 0) ? "가위" : (computer == 1) ? "바위" : "보자기";
			
			if(youStr.equals("가위")) {
				you = 0;
			}else if(youStr.equals("바위")) {
				you = 1;
			}else if(youStr.equals("보")) {
				you = 2;
			}else {
				you = NOTHING;
				continue;
			}
			
			if((you + 2) % 3 == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요 \n", youStr, computerStr);
			} else if (you == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요\n", youStr, computerStr);
			} else {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요 \n", youStr, computerStr);
			}

		} while (you == NOTHING || (you + 2) % 3 != computer);// do~while
		scanner.close();
		System.out.println("BYE");
	}// main
}// class
