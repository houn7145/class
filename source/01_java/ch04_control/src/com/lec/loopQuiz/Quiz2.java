package com.lec.loopQuiz;
//1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���
public class Quiz2 {
	public static void main(String[] args) {
		int tot = 0; int tot1 = 0;
		for(int i=1 ; i<11 ; i++) {
				if((i%2)==0) {
					tot += i;
				}else { 
					tot1 += i;
					
					
				}
			
		}System.out.println("tot, tot1");
	}
}
