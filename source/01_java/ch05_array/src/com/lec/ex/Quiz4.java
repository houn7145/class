package com.lec.ex;
//76,45,34,89,100,50,90,932 8���� ���� 1���� �迭�� �ʱ�ȭ ��
//�̵� ������ ũ�� ������ ��Ÿ���� ���α׷��� �ۼ� �Ͻÿ�.
public class Quiz4 {
	public static void main(String[] args) {
		int[] su = {76,45,34,89,100,50,90,92};
		int i, j;
		int temp;
		for(i=0; i<su.length ; i++) {
			for(j=i+1 ; j<su.length ; j++) {
				if(su[i] > su[j]) {
					temp = su[i];
					su[i] = su[j];
					su[j] = temp;
				}
			}
			
		}
		for(int t : su) {
			System.out.println((t+"\t"));
		}
	}
}
