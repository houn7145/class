package com.lec.loopQuiz;
// 1~10������ ���� ����� ����غ���
public class Quiz1 {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1 ; i<11 ; i++) {
			System.out.print(i);
			if(i!=10) {
				System.out.print("*");
			}
			tot *= i;
		
		}
		System.out.println("=" + tot);
	}
}
