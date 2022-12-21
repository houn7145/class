package com.lec.ex02_thread;

// Thread t1 = new ThreadEx("A");
// Thread t2 = new Thread();
// t2.setName("B");
public class ThreadEx extends Thread {
	public ThreadEx() {
	}

	public ThreadEx(String name) {
		super(name); // 쓰레드 이름
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "쓰레드의 i = " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
