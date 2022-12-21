package com.lec.test;
//76,45,34,89,100,50,90,93 8개의 값을 1차원 배열로 초기화 후
//합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 
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
		System.out.printf("합계: %d\t, 평균: %.2f\n최대값: %d, 최소값: %d\t",totsu, (double)totsu/8, maxsu, minsu);
	}		
}