package com.lec.ex05_booklib;

import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) {
		Book book1 = new Book("890��", "java", "ȫ�浿");
		Book book2 = new Book("890��", "jsp", "ȫ���");
		book1.checkOut("������");
		book2.checkOut("������");
		book2.setCheckOutDate(new Date(new GregorianCalendar(2022, 10, 1).getTimeInMillis()));
		
		try {
			book1.checkIn();
			book2.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
