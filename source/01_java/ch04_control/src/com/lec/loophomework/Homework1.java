package com.lec.loophomework;

import java.util.Scanner;

//컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.
//(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다)
public class Homework1 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요 (종료: -1)");
		int you = scanner.nextInt();
		
		if(you<-1 || you>2) {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나");
		}else if(you == 0) {
			System.out.printf("당신은 가위(%d)를 냈습니다\n", you);
		}else if(you == 1) {
			System.out.printf("당신은 바위(%d)를 냈습니다\n", you);
		}else {
			System.out.printf("당신은 보(%d)를 냈습니다\n", you);
		}
			
		if((you+2)%3 == com) {
			System.out.println("당신이 이겼습니다");
		}else if((you+1)%3 == com) {
			System.out.println("당신이 졌습니다");
		}else {
			System.out.println("비겼습니다");
		}

	}
}
