package com.lec.ex;

public class Ex03_arrayCopy {
	public static void main(String[] args) {
		int[] score = {10,20,0,40,50};
		int[] s = new int[score.length]; // 복제 후 공간만 확보, 공간은 0으로 초기화
//		for(int idx=0; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		s[0] = 999;
		for(int idx=0; idx<s.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
	}

}
