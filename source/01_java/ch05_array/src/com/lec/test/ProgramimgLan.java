package com.lec.test;
//76,45,34,89,100,50,90,93 8���� ���� 1���� �迭�� �ʱ�ȭ ��
//�հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� 
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] su = {76,45,34,89,100,50,90,93};
		int totsu = 0;
		for(int i=0 ; i<su.length ; i++) {
			totsu += su[i];
		
		}
		int maxi=0, maxsu=0;
		int mini=0, minsu=999;
		for(int i=0 ; i<su.length ; i++) {
			if(su[i] > maxsu) {
				maxsu = su[i];
				maxi = i;
			}
			if(su[i] < minsu) {
				minsu = su[i];
				mini = i;
			}
		}
		System.out.printf("�հ�: %d\t, ���: %.2f\n�ִ밪: %d, �ּҰ�: %d\t",totsu, (double)totsu/8, maxsu, minsu);
	}		
}