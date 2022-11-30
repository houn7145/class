package com.lec.quiz;
// 두수를 입력받아 
// 두 수가 같은지 결과를 O나 X로 출력
// 첫번째 수가 더 큰지 결과를 O나 X로 출력
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요: ");
		int su = sc.nextInt();
		Scanner st = new Scanner(System.in);
		System.out.print("두번째 수를 입력하세요: ");
		int sy= st.nextInt();
		
		String result1 = (su==sy) ? "O" : "X";
		System.out.printf("입력하신 두 수(%d, %d)가 같은 값인지는 %s\n", su, sy, result1);
		String result2 = (su>sy) ? "O" : "X";
		System.out.printf("입력하신 두 수(%d, %d)중 첫번째 수가 더 큰지는 %s\n", su, sy, result2);
		
	}

}
