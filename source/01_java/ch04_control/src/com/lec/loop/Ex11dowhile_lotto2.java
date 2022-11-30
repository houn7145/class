package com.lec.loop;

import java.util.Scanner;

// 컴퓨터가 발생한 로또 난수를 맞추기
public class Ex11dowhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // 컴퓨터 로또변화와 사용자로 부터 입력 받은 수 
		int min=1, max=45;
		Scanner scanner = new Scanner(System.in);
		// 0 <= Math.random() < 1 : 실수
		// 0 <= Math.random()*45 < 45 : 실수
		// 0 <= Math.random()*45+1 < 46 : 실수
		// 0 <= (int)(Math.random()*45+1) < 46 : 정수
		lotto = (int)(Math.random()*45+1); // 로또번호
		do {
			System.out.printf("로또 번호 한개를 맞춰 보세요(%d~%d) : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("주어진 범위를 확인하세요.");
				
			}else if(su>lotto) {
				max = su-1;
				//System.out.println(su+"보다 작은 수를 도전하세요");
			}else if(su<lotto) {
				min = su+1;
				//System.out.println(su+"보다 큰 수를 도전하세요");
			}
		}while(su!=lotto);
		System.out.println("맞췄습니다 축하드립니다");
	}

}
