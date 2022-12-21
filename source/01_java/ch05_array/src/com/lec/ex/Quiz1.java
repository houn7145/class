package com.lec.ex;
// 배열에 담긴 값을 더하는 프로그램을 작성
// int[] arr =  { 10, 20, 30, 40, 50}
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int totarr= 0;
		for(int i=0 ; i<arr.length ; i++) {
			totarr += arr[i];
		}
		
		System.out.printf("배열에 저장된 값의 합계는 : %d", totarr);
		
	}

}
