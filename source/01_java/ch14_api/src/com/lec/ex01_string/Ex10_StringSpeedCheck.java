package com.lec.ex01_string;

public class Ex10_StringSpeedCheck {
	public static void main(String[] args) {
		System.out.println("1970.01.01부터 현재까지의 밀리세컨 : " + System.currentTimeMillis());
		String str = "a";
		long start = System.currentTimeMillis(); // 시작 시점의 밀리세컨 할당
		for(int i=0 ; i<100000 ; i++) {
			// String 변수 10만번 변경하기
			str = str.concat("b");
		}
		long end = System.currentTimeMillis();// 끝난 시점의 밀리세컨 할당
		System.out.println("String 10만번 변경 경과 시간 : " +(end-start));
		StringBuffer strBuffer = new StringBuffer("a");
		start = System.currentTimeMillis(); // 시작시점 밀리세컨
		for(int i=0 ; i<100000 ; i++) {
			strBuffer.append("b");
		}
		end = System.currentTimeMillis(); // 끝난시점 밀리세컨
		System.out.println("StringBuffer 10만번 변경 경과 시간 : " + (end-start));
		StringBuilder strBuilder = new StringBuilder("a");
		start = System.currentTimeMillis(); // 시작시점 밀리세컨
		for(int i=0 ; i<100000 ; i++) {
			strBuilder.append("b");
		}
		end = System.currentTimeMillis(); // 끝난시점 밀리세컨
		System.out.println("StringBuilder 10만번 변경 경과 시간 : " + (end-start));
		
	}
	

}
