package com.lec.ex6_final;

import com.lec.constant.Constant;

public class FinalTestMain {
	public static void main(String[] args) {
	//	final double PI = 3.141592; // ���� �ٲ��� �ʴ� ���
		double r = 3;
		double area = r * r * Constant.PI; 
		double round = 2 * Constant.PI * r;
		System.out.println("���� ���̴� " + area);
		System.out.println("���� �ѷ��� " + round);
	}
}