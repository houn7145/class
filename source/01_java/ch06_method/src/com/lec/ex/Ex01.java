package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int  i=1 ; i<=10 ; i++ ) {
			tot +=i;
		}
		System.out.println("1~10까지의 정수의 합은 " + tot);
		System.out.println( tot%2==0 ? "짝수입니다" : "홀수입니다");
		// ---------------------------------------------------
		tot = 0;
		for(int  i=10 ; i<=100 ; i++ ) {
				tot +=i;
		}
		System.out.println("10~100까지의 정수의 합은 " + tot);
		System.out.println( tot%2==0 ? "짝수입니다" : "홀수입니다");
	}

}
