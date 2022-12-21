package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		
		int i =10; // int 변수 선언과 초기화
		// 1. 배열 변수 선언과 초기화
		int[] iArr = {10,20,30,40,50};
		iArr[2] = 300; // 배열은 index로 접근(0~4)
		// System.out.println(iArr[2]);
		for(int idx=0 ; idx<iArr.length; idx++) { // iArr.length : 배열 방의 갯수
			System.out.println(iArr[idx]);
			
		
		}
		// 2. 배열 변수 선언과 배열 메모리 공간 확보
		int[] iArr2 = new int[5]; // 선언시 0으로 초기화
		iArr2[0] = 999;
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n",idx, iArr2[idx]);
		
		}
		// 3. 배열 변수 선언
		int[] iArr3;
		iArr3 = new int[3]; // {0,0,0}
		// 확장 for문
		for(int temp : iArr3) {
			System.out.println(temp); // idx와 같이 출력 불가능
		}
		// 배열 방의 값을 변경  - 일반 for문 = 가능함
		for(int idx=0 ; idx<iArr3.length ; idx ++) {
			iArr3[idx] = 999;
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(idx+"번째: "+ iArr3[idx]);
		}
		// 배열 방의 값을 변경 - 확장 for문 = 불가능함
		for(int ia : iArr3) {
			ia = 111;
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}
}
