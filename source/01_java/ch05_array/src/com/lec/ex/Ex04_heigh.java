package com.lec.ex;

import java.util.Scanner;

// �迭�� �̿��Ͽ� �л���(����, ö��, �浿, ����, ����)�� Ű�� �Է¹ް�, ���ġ�� ���غ���
// ���� ū �л��� ���� ���� �л��� ������ ����
public class Ex04_heigh {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��", "�浿", "����", "����"};
		int[]  arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0; 
		// Ű �Է¹ޱ� + totHight�� ����
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű��?");
			arrHeight[idx] = scanner.nextInt();
			totHeight += arrHeight[idx]; // ����
		}
		for(int idx=0; idx<arrName.length ; idx++) {
			System.out.printf("%d��° %s�� Ű�� %d\n", idx, arrName[idx], arrHeight[idx]);
		}
		System.out.println("���Ű�� " + (double)totHeight/arrHeight.length);
		// ���� ū �л��� ���� ���� �л�
		int maxIdx=0, maxHeight=0; // ������� ���ϱ� ���� ������(���� ������ �ʱ�ȭ)
		int minIdx=0, minHeight=9999; // �ִܽ��� ���ϱ� ���� ������(ū ������ �ʱ�ȭ)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {
				maxHeight = arrHeight[idx];
				maxIdx = idx;
				
			}//if
			if(arrHeight[idx] < minHeight) {
				minHeight = arrHeight[idx];
				minIdx = idx;
			}//if - �ּҰ�
		}//for
		System.out.printf("���� ū �л��� %s�� Ű�� %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("���� ���� �л��� %s�� Ű�� %d\n", arrName[minIdx], minHeight);
	}//main
}//class