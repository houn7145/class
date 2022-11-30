package com.lec.var;
// println() : 콘솔창 풀력(개행포함)
// print() : 콘솔창 출력(개행 미포함)
// printf() : 콘솔창 출력(포멧 지정)
public class VarEX02 {
	public static void main(String[] args) {
		// 타입 변수명 할당연산자 값;
		int i = 10;
		byte j = 127;
		double h = 10.15;
		i = 100;
		System.out.println("i="+i+"\tj="+j+"\th="+h);
		System.out.printf("i=%d \tj=%d \th=%.2f\n", i, j, h );
		char c1 = 'A';
		char c2 = '홍';
		// %c : 문자, %s : 문자열
		// %d : 정수, %f : 실수,  %b : boolean
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
		System.out.println("프로그램 끝");
		
		
	}
	
}
