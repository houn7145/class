package com.lec.ex;
// �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�
// int[] arr =  { 10, 20, 30, 40, 50}
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int totarr= 0;
		for(int i=0 ; i<arr.length ; i++) {
			totarr += arr[i];
		}
		
		System.out.printf("�迭�� ����� ���� �հ�� : %d", totarr);
		
	}

}
