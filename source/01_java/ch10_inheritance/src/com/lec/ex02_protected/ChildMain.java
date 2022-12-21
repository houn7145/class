package com.lec.ex02_protected;

public class ChildMain {

	public static void main(String[] args) {
		Child child1 = new Child(); // 매개변수 없는 생성자 함수 호출
		child1.setI(1); child1.setJ(2);
		child1.sum();
		System.out.println("=======================");
		Child child2 = new Child(3, 4); // 매개변수 있는 생성자 함수 호출
		child2.sum();
	}
}
