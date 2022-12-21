package com.lec.ex01_trycatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] arr = {0,1,2};
		for( int i = 0; i<=arr.length ; i++) {
			try {
				System.out.println("arr[" + i + "] = " + arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : " + e.getMessage());
			}finally { // 정리
				System.out.println("try절 실행 후에도, catch절 실행 후에도 실행되는 절");
			}
		}
	}
}
