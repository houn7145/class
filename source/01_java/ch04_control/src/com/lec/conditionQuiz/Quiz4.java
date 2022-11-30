package com.lec.conditionQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오
// 단, 사용자는 가위대신 0, 바위대신 1, 보대신 2를 입력
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
		int you = scanner.nextInt();
		if(you==0) {
			System.out.print("당신은 가위");
		}else if(you == 1) {
			System.out.print("당신은 바위");
		}else if(you == 2) {
			System.out.print("당신은 보자기");
		}else {
			System.out.print("잘못 냈습니다");
			you = 3;
		}
		if(you!=3) {
			if(com==0) {
				System.out.println("\t컴퓨터는 가위");
			}else if(com==1) {
				System.out.println("\t컴퓨터는 바위");
			}else if(com ==2) {
				System.out.println("\t컴퓨터는 보자기");
			}// if - com
		}
		if(you==0) {
			if(com==0) {
				System.out.println("비겼어요");
			}else if(com==1) {
				System.out.println("컴퓨터가 이겼어요");
			}else {
				System.out.println("당신이 이겼어요");
			}
		}else if (you == 1) {
			if(com==0) {
				System.out.println("당신이 이겼어요");
			}else if(com==1) {
				System.out.println("비겼어요.");
			}else {
				System.out.println("컴퓨터가 이겼어요");
			}
		}else if (you==2) {
			if(com==0) {
				System.out.println("컴퓨터가 이겼어요");
			}else if(com==1) {
				System.out.println("당신이 이겼어요");
			}else {
				System.out.println("비겼어요");
				
//				int you, computer;
//				computer = (int)(Math.random()*3);
//				System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
//				you = scanner.nextInt(); // 0,1,2
//				if(you == 0) {
//					System.out.print("당신은 가위\t컴퓨터는 ");
//				}else if(you == 1) {
//					System.out.print("당신은 바위\t컴퓨터는 ");
//				}else if(you == 2) {
//					System.out.print("당신은 보자기\t컴퓨터는 ");
//				}else {
//					System.out.print("당신 잘못 냈어요. 다음엔 잘 내요");
//					you = 3;
//				}
//				if(you!=3) {
//					String msg = (computer==0) ? "가위" : (computer==1)?"바위":"보자기";
//					System.out.println(msg);
//					if( (you+2)%3 == computer ) {
//						System.out.println("당신이 이겼어요!!");
//					}else if((you+1)%3 == computer){
//						System.out.println("컴퓨터가 이겼어요. 메롱");
//					}else {
//						System.out.println("비겼어요.");
//					}
//				}
//				scanner.close();
			}
		}
	}
}

