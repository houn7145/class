package com.lec.ex06_wrapper;

// Wrapper 클래스 : Integer, Double, Long, Boolean... 기초데이터를 객체데이터로 뱐환하는 클래스
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		Integer iObj = 10; // new Integer(10); // 자동으로 객체 생성
		int sum = i + iObj; // int sum = i + iObj.intValue();와 동일
		System.out.println("합은 : " + sum);
		System.out.println(iObj.equals(10));
	}
}
