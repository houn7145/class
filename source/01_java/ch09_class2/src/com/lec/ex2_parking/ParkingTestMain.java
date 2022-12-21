package com.lec.ex2_parking;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111루1111", 6);
		Parking car2 = new Parking("222루2222", 8);
		car1.out(8); // 출차시간
		car2.out(9); // 출차시간
		Parking car3 = new Parking("333루3333", 9);
	}
}

