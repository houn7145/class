package com.lec.ex;
// �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?
public class Quiz3 {
	public static void main(String[] args) {
		int[] coinunit = {500,100,50,10};
		int money =2680;
		System.out.println(money+"����");
		for(int i =0; i<coinunit.length ; i++) {
			System.out.println((coinunit[i]) +"�� "+ (money/coinunit[i]) + "��");
			money = money%coinunit[i];
		}
		
	}

}
