package com.lec.conditionQuiz;

import java.util.Scanner;

// ���� ��������� Ű����κ��� �Է¹޾� ������ ����ϴ� ���α׷��� �����ϼ���
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� ���ڸ� �Է��ϼ���: ");
		int mon = scanner.nextInt();
		switch(mon) {
		case 3: case 4: case 5:
			System.out.printf("�Է��Ͻ� %d���� �� �Դϴ�", mon);break;
		case 6: case 7: case 8:
			System.out.printf("�Է��Ͻ� %d���� ���� �Դϴ�", mon);break;
		case 9: case 10: case 11:
			System.out.printf("�Է��Ͻ� %d���� ���� �Դϴ�", mon);break;
		case 12: case 1: case 2:
			System.out.printf("�Է��Ͻ� %d���� �ܿ� �Դϴ�", mon);break;
		default:
			System.out.println("��ȿ���� �ʴ� �����Դϴ�");
			
//			if(month==12 || month==1 || month==2) {
//				System.out.println("�Է��Ͻ� ������ �ܿ��̳׿�");
//			}else if(month==3 || month==4 || month==5) {
//				System.out.println("�Է��Ͻ� ������ ���̳׿�");
//			}else if(month==6 || month==7 || month==8) {
//				System.out.println("�Է��Ͻ� ������ �����̳׿�");
//			}else if(month==9 || month==10 || month==11) {
//				System.out.println("�Է��Ͻ� ������ �����̳׿�");
//			}else {
//				System.out.println("��ȿ�� ���� ���� �ƴմϴ�.");
//			}
//			scanner.close();
		}
	}

}
