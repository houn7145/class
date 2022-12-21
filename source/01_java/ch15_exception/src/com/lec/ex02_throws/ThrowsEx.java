package com.lec.ex02_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception {
		actionC();
	}
	private void actionC() throws IndexOutOfBoundsException{
		System.out.println("actrinC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws IndexOutOfBoundsException{
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException{ // 예외가 발생하면 뒤에는 호출 x
		System.out.println("actionA 전반부");
		int[] arr = {0,1,2};
		System.out.println(arr[3]);
		System.out.println("actionA 후반부");
	}
}
