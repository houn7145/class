package com.lec.ex02_thread;

public class Ex02_TargetTestMain {
	public static void main(String[] args) {
		// A라는 이름의 쓰레드를 생성 - target01.run()을 동시 수행 할 쓰레드
		Thread target01 = new TargetEx01();
		target01.setName("A");
		// B라는 이름의 쓰레드를 생성 - target02.run()을 동시 수행 할 쓰레드
		Thread target02 = new TargetEx02();
		target02.setName("B");
		target01.start();
		target02.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main 함수에서의 i : " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
