package com.lec.ex02_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawon = {new Sawon("a01", "ȫ�浿", Sawon.COMPUTER,2022,12,12),
				new Sawon("a02", "��浿", Sawon.PLANNING, 2022,12,15), 
				new Sawon("b01", "�̱浿", Sawon.HUMANRESOURCES)};
		for(Sawon sawons : sawon) {
			System.out.println(sawons);
		}
	}
}


