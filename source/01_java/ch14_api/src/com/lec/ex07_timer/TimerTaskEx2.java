package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("~ ~ ~ 작업 2 : 1초후 0.5초마다 실행될 예정인 Timer Task");
	}
}
