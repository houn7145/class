package com.lec.conditionQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오
// 단, 사용자는 가위대신 0, 바위대신 1, 보대신 2를 입력
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("컴퓨터와 가위바위보 게임을 시작합니다");
		System.out.println("가위(0), 바위(1), 보(2)중 하나를 선택하세요 :");
		int you = scanner.nextInt(); 
		
		
		if(you == 0) {
			System.out.printf("당신은 가위(%d)를 냈습니다\n", you);
		}else if(you == 1) {
			System.out.printf("당신은 바위(%d)를 냈습니다\n", you);
		}else {
			System.out.printf("당신은 보(%d)를 냈습니다\n", you);
		}
			
		if(com == 0) {
				System.out.printf("컴퓨터는 가위(%d)를 냈습니다\n", com);
			}else if(com == 1) {
				System.out.printf("컴퓨터는 바위(%d)를 냈습니다\n", com);
			}else {
				System.out.printf("컴퓨터는 보(%d)를 냈습니다\n", com);
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
