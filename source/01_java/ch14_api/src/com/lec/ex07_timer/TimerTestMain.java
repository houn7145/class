package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // true를 안쓰면 프로그램 종료시 timer가 메모리에 상주하지 않음
		TimerTask task1 = new TimerTaskEx1(); 
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);	  // 2초후 한번만  run()을 실행
		timer.schedule(task2, 1000, 500); // 1초후 0.5초마다 run()을 실행
		Thread.sleep(11000);
		System.out.println("끝");
	}

}
