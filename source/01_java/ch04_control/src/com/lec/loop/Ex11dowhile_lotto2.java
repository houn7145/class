package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζ� ������ ���߱�
public class Ex11dowhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // ��ǻ�� �ζǺ�ȭ�� ����ڷ� ���� �Է� ���� �� 
		int min=1, max=45;
		Scanner scanner = new Scanner(System.in);
		// 0 <= Math.random() < 1 : �Ǽ�
		// 0 <= Math.random()*45 < 45 : �Ǽ�
		// 0 <= Math.random()*45+1 < 46 : �Ǽ�
		// 0 <= (int)(Math.random()*45+1) < 46 : ����
		lotto = (int)(Math.random()*45+1); // �ζǹ�ȣ
		do {
			System.out.printf("�ζ� ��ȣ �Ѱ��� ���� ������(%d~%d) : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("�־��� ������ Ȯ���ϼ���.");
				
			}else if(su>lotto) {
				max = su-1;
				//System.out.println(su+"���� ���� ���� �����ϼ���");
			}else if(su<lotto) {
				min = su+1;
				//System.out.println(su+"���� ū ���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.println("������ϴ� ���ϵ帳�ϴ�");
	}

}
