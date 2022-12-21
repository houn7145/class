package com.lec.ex;
//76,45,34,89,100,50,90,932 8개의 값을 1차원 배열로 초기화 후
//이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시오.
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
