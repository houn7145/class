package com.lec.ex02_thread;

public class Ex02_TargetTestMain {
	public static void main(String[] args) {
		// A��� �̸��� �����带 ���� - target01.run()�� ���� ���� �� ������
		Thread target01 = new TargetEx01();
		target01.setName("A");
		// B��� �̸��� �����带 ���� - target02.run()�� ���� ���� �� ������
		Thread target02 = new TargetEx02();
		target02.setName("B");
		target01.start();
		target02.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main �Լ������� i : " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
