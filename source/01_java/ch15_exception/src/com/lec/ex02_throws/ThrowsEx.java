package com.lec.ex02_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception {
		actionC();
	}
	private void actionC() throws IndexOutOfBoundsException{
		System.out.println("actrinC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws IndexOutOfBoundsException{
		System.out.println("actionB ���ݺ�");
		actionA();
		System.out.println("actionB �Ĺݺ�");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException{ // ���ܰ� �߻��ϸ� �ڿ��� ȣ�� x
		System.out.println("actionA ���ݺ�");
		int[] arr = {0,1,2};
		System.out.println(arr[3]);
		System.out.println("actionA �Ĺݺ�");
	}
}
