package com.lec.ex01_string;

public class Ex10_StringSpeedCheck {
	public static void main(String[] args) {
		System.out.println("1970.01.01���� ��������� �и����� : " + System.currentTimeMillis());
		String str = "a";
		long start = System.currentTimeMillis(); // ���� ������ �и����� �Ҵ�
		for(int i=0 ; i<100000 ; i++) {
			// String ���� 10���� �����ϱ�
			str = str.concat("b");
		}
		long end = System.currentTimeMillis();// ���� ������ �и����� �Ҵ�
		System.out.println("String 10���� ���� ��� �ð� : " +(end-start));
		StringBuffer strBuffer = new StringBuffer("a");
		start = System.currentTimeMillis(); // ���۽��� �и�����
		for(int i=0 ; i<100000 ; i++) {
			strBuffer.append("b");
		}
		end = System.currentTimeMillis(); // �������� �и�����
		System.out.println("StringBuffer 10���� ���� ��� �ð� : " + (end-start));
		StringBuilder strBuilder = new StringBuilder("a");
		start = System.currentTimeMillis(); // ���۽��� �и�����
		for(int i=0 ; i<100000 ; i++) {
			strBuilder.append("b");
		}
		end = System.currentTimeMillis(); // �������� �и�����
		System.out.println("StringBuilder 10���� ���� ��� �ð� : " + (end-start));
		
	}
	

}
