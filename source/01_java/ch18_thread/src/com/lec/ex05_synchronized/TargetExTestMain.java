package com.lec.ex05_synchronized;
// target 객체는 1개, Thread는 N개 = 쓰레드 하나가 target 객체를 공유
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target = new TargetEx(); // run()함수에서 A면 num증가, A가 아니면 num=0
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}
}
