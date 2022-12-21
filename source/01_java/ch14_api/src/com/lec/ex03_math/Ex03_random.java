package com.lec.ex03_math;

import java.util.Random;

// Math.random() : 0.0 ~ 1.0 ���� �߻�(double)
// 0 <= Math.random() * 45 < 45
// 1 <= (int)(Math.random() * 45)+1 < 46
// Random random = new Random()
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1~45������ ���� ������ �߻� : " + (int)(Math.random() * 45+1));
		Random random = new Random();
		System.out.println("int ���� : " + random.nextInt()); // ���� ����
		System.out.println("double ���� : " + random.nextDouble()); // Math.random�̶� ����
		System.out.println("true or false �� ���� : " + random.nextBoolean());
		System.out.println("0~100������ ���� ���� : " + random.nextInt(101));
		System.out.println("0~44������ ���� ���� : " + random.nextInt(45));
		System.out.println("1~45������ ���� ���� : " + (random.nextInt(45)+1)); // ��Ʈ�� ��� �� ()
		System.out.println("����(0), ����(1), ���ڱ�(2) �� �ϳ� : " + random.nextInt(3));
	} 

}
