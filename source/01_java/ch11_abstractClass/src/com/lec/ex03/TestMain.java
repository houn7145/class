package com.lec.ex03;

import com.lec.ex02.SuperClass;

public class TestMain {
	public static void main(String[] args) {
		GrandChild g = new GrandChild();
		g.method1(); g.method2(); g.method3(); g.method4();
		ChildAbstract ca= new GrandChild();
		ca.method1(); ca.method2(); ca.method3(); ca.method4();
		System.out.println("===========================");
		SuperClass s = new GrandChild();
		s.method1(); s.method2(); s.method3(); // method4는 불가능
	}
}
