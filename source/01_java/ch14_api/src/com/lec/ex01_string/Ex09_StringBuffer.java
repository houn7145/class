package com.lec.ex01_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.append("def"); // abc+def
		System.out.println("append �� : " + strBuffer);
		System.out.println("append �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.insert(3, "AAA"); // 3��°�� AAA �߰� : abcAAAdef
		System.out.println("inset �� : " + strBuffer);
		System.out.println("insert �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.delete(3, 6); // 3��°���� 6��° �ձ��� ���� : abcdef
		System.out.println("delete �� : " + strBuffer);
		System.out.println("delete �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		int capacitySize = strBuffer.capacity(); // ������ ����ũ��
		System.out.println("������ ����ũ�� : " + capacitySize);
		strBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789");
		System.out.println("append �� : " + strBuffer);
		System.out.println("append �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		System.out.println("���� ���ڸ� �߰��� �� ����ũ�� : " + strBuffer.capacity());
	}
}
