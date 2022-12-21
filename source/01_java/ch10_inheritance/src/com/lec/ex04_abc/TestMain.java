package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // 생성자 함수 1개 실행
		S aObj = new A(); // A aObj = new A(); // 생성자 함수 2개 실행(부모단 + 자식단)
		S bObj = new B(); // B bObj = new B();
		S cObj = new C(); // C cObj = new C();	
	//	System.out.println("aObj와 bObj가 같냐? " + aObj.equals(bObj));
		S[] arr = {sObj, aObj, bObj, cObj};
    //	S[] arr = {new S(), new A(), new B(), new C()};
		for(S a : arr) {
			System.out.println("s = " + a.s);
		}
	}
}
