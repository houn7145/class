package com.lec.ex06_atm;

public class AtmMain {
	public static void main(String[] args) {
		ATM atm = new ATM(1000);
		Runnable card = new AtmTarget(atm);
		Thread t1 = new Thread(card, "���ŢŸ�");
		Thread t2 = new Thread(card, "�ƺ�");
		t1.start();
		t2.start();
	}
}
