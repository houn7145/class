package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // ������ �Լ� 1�� ����
		S aObj = new A(); // A aObj = new A(); // ������ �Լ� 2�� ����(�θ�� + �ڽĴ�)
		S bObj = new B(); // B bObj = new B();
		S cObj = new C(); // C cObj = new C();	
	//	System.out.println("aObj�� bObj�� ����? " + aObj.equals(bObj));
		S[] arr = {sObj, aObj, bObj, cObj};
    //	S[] arr = {new S(), new A(), new B(), new C()};
		for(S a : arr) {
			System.out.println("s = " + a.s);
		}
	}
}
