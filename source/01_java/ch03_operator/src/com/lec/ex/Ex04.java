package com.lec.ex;
// �������� : %%(AND �Ѵ�  true), ||(OR �ϳ��� true), !(�ݴ�)
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&& : (i<j) && (++j>h)�� " + ((i<j) && (++j>h)) );
		System.out.println("j = " +j); // j=11
		
		System.out.println("&& : (i>j) && (++j>h)�� " + ((i>j) && (++j>h)) );
		System.out.println("j = " +j);
		//���� f�̱⿡ �ڴ� ��� x 
		//&&������ ��� ������ false�� ��� ������ ���� ������� ����
		
		System.out.println("|| : (i<j) || (++j>h)�� " + ((i<j) || (++j>h)) );
		System.out.println("j = " +j); // j=11
		
		System.out.println("|| : (i>j) || (++j>h)�� " + ((i>j) || (++j>h)) );
		System.out.println("j = " +j);
		//���� t�� ��쿡 �ڿ��� ��� x
		//���� f�� ��쿡 �ڸ� ���
	}

}
