package com.lec.loop;

public class Ex08while {
	public static void main(String[] args) {
		int tot = 0; //누적합을 저장하기 위한 변수
		int i=1;
		while(i<=10) {
			tot += i;
			System.out.printf("i가 %d일 때 누적합은 %d이다\n", i, tot);
			i++;
//		for(int i=1 ; i<=10 ; i++ ) {
//			tot += i; //tot = tot +i;
//			System.out.printf("i가 %d일 때 누적합은 %d이다\n", i, tot);
		}
	}

}
