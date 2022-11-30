package com.lec.loopQuiz;
//1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Quiz2 {
	public static void main(String[] args) {
		int tot = 0; // 짝수 누적 변수
		int tot1 = 0; // 홀수 누적 변수
		for(int i=1 ; i<11 ; i++) {
				if((i%2)==0) {
					tot += i;
				}else { 
					tot1 += i;
					
					
				}
			
		}System.out.println("1~10까지의 짝수의 합은 "+tot +", 홀수의 합은 "+tot1);
	}
}
