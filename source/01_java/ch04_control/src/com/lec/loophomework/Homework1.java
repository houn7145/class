package com.lec.loophomework;

import java.util.Scanner;

//��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
//(��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�)
public class Homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		while(true) {
			System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ���(����:-1) ");
			you = scanner.nextInt();
			if(you==-1) break;
			computer = (int)(Math.random()*3);
			String computerStr = (computer==0) ? "����" : (computer==1)?"����":"���ڱ�";
			String youStr = (you==0) ? "����" : (you==1)?"����":"���ڱ�";
			if(you<-1 || you>2) {
				System.out.println("����(0),����(1),��(2) �� �ϳ�");
			}else {
				if( (you+2)%3 == computer ) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� ^.^\n", youStr, computerStr);
				}else if((you+1)%3 == computer){
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� ��.��\n", youStr, computerStr);
				}else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n",  youStr, computerStr);
				}
			}
		}//while
		scanner.close();
		System.out.println("BYE");
	}//main
}//class