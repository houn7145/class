package com.lec.ex02_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon2[] sawon = {new Sawon2("a01", "ȫ�浿", Sawon2.COMPUTER,2022,12,12),
				new Sawon2("a02", "��浿", Sawon2.PLANNING, 2022,12,15), 
				new Sawon2("b01", "�̱浿", Sawon2.HUMANRESOURCES)};
		for(Sawon2 sawons : sawon) {
			System.out.println(sawons);
		}
	}
}


