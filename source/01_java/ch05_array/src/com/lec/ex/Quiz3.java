package com.lec.ex;
// 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?
public class Quiz3 {
	public static void main(String[] args) {
		int[] coinunit = {500,100,50,10};
		int money =2680;
		System.out.println(money+"원은");
		for(int i =0; i<coinunit.length ; i++) {
			System.out.println((coinunit[i]) +"원 "+ (money/coinunit[i]) + "개");
			money = money%coinunit[i];
		}
		
	}

}
