package com.lec.ex02_protected;

public class ChildMain {

	public static void main(String[] args) {
		Child child1 = new Child(); // �Ű����� ���� ������ �Լ� ȣ��
		child1.setI(1); child1.setJ(2);
		child1.sum();
		System.out.println("=======================");
		Child child2 = new Child(3, 4); // �Ű����� �ִ� ������ �Լ� ȣ��
		child2.sum();
	}
}
