package com.lec.ex02_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawon = {new Sawon("a01", "È«±æµ¿", Sawon.COMPUTER,2022,12,12),
				new Sawon("a02", "±è±æµ¿", Sawon.PLANNING, 2022,12,15), 
				new Sawon("b01", "ÀÌ±æµ¿", Sawon.HUMANRESOURCES)};
		for(Sawon sawons : sawon) {
			System.out.println(sawons);
		}
	}
}


