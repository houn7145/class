package com.lec.ex01_parentChild;
// pStr, getPapaName(), getMamiName(); 다 사용가능
public class ChildClass extends ParentClass {
	String cStr = "자식클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
}
