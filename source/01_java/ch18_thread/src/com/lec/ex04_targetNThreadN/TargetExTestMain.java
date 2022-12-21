package com.lec.ex04_targetNThreadN;
// target 객체는 N개, Thread는 N개 = 쓰레드 하나가 target 객체를 공유
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable targetA = new TargetEx(); // run()함수에서 A면 num증가, A가 아니면 num=0
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}
}
