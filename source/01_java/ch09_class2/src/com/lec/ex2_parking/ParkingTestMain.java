package com.lec.ex2_parking;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111��1111", 6);
		Parking car2 = new Parking("222��2222", 8);
		car1.out(8); // �����ð�
		car2.out(9); // �����ð�
		Parking car3 = new Parking("333��3333", 9);
	}
}

