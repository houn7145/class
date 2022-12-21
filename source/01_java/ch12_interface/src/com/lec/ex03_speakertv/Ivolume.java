package com.lec.ex03_speakertv;
// 인터페이스 - static final 변수(상수)와 추상메소드, 예외 (default 메소드, static 메소드)
// 작업명세서 
public interface Ivolume {
	public void volumeUp(); // 볼륨 레벨을 1씩 올림
	public void volumeUp(int level); // 볼륨 레벨을 level씩 올림
	public void volumeDown(); // 볼륨 레벨을 1씩 내림
	public void volumeDown(int level); // 볼륨 레벨을 level씩 내림
	public default void setMute(boolean mute) { // default 메소드
		if(mute) {
			System.out.println("무음");
		}else {
			System.out.println("무음해제");
		}
	}
	public static void changeBattery() { // static 메소드
		System.out.println("건전기를 교환합니다");
	}
}
