package com.lec.conditionQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�
// ��, ����ڴ� ������� 0, ������� 1, ����� 2�� �Է�
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ��� : ");
		int you = scanner.nextInt();
		if(you==0) {
			System.out.print("����� ����");
		}else if(you == 1) {
			System.out.print("����� ����");
		}else if(you == 2) {
			System.out.print("����� ���ڱ�");
		}else {
			System.out.print("�߸� �½��ϴ�");
			you = 3;
		}
		if(you!=3) {
			if(com==0) {
				System.out.println("\t��ǻ�ʹ� ����");
			}else if(com==1) {
				System.out.println("\t��ǻ�ʹ� ����");
			}else if(com ==2) {
				System.out.println("\t��ǻ�ʹ� ���ڱ�");
			}// if - com
		}
		if(you==0) {
			if(com==0) {
				System.out.println("�����");
			}else if(com==1) {
				System.out.println("��ǻ�Ͱ� �̰���");
			}else {
				System.out.println("����� �̰���");
			}
		}else if (you == 1) {
			if(com==0) {
				System.out.println("����� �̰���");
			}else if(com==1) {
				System.out.println("�����.");
			}else {
				System.out.println("��ǻ�Ͱ� �̰���");
			}
		}else if (you==2) {
			if(com==0) {
				System.out.println("��ǻ�Ͱ� �̰���");
			}else if(com==1) {
				System.out.println("����� �̰���");
			}else {
				System.out.println("�����");
				
//				int you, computer;
//				computer = (int)(Math.random()*3);
//				System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ��� : ");
//				you = scanner.nextInt(); // 0,1,2
//				if(you == 0) {
//					System.out.print("����� ����\t��ǻ�ʹ� ");
//				}else if(you == 1) {
//					System.out.print("����� ����\t��ǻ�ʹ� ");
//				}else if(you == 2) {
//					System.out.print("����� ���ڱ�\t��ǻ�ʹ� ");
//				}else {
//					System.out.print("��� �߸� �¾��. ������ �� ����");
//					you = 3;
//				}
//				if(you!=3) {
//					String msg = (computer==0) ? "����" : (computer==1)?"����":"���ڱ�";
//					System.out.println(msg);
//					if( (you+2)%3 == computer ) {
//						System.out.println("����� �̰���!!");
//					}else if((you+1)%3 == computer){
//						System.out.println("��ǻ�Ͱ� �̰���. �޷�");
//					}else {
//						System.out.println("�����.");
//					}
//				}
//				scanner.close();
			}
		}
	}
}

