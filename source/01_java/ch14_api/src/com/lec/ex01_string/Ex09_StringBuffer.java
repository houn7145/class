package com.lec.ex01_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		strBuffer.append("def"); // abc+def
		System.out.println("append 후 : " + strBuffer);
		System.out.println("append 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		strBuffer.insert(3, "AAA"); // 3번째에 AAA 추가 : abcAAAdef
		System.out.println("inset 후 : " + strBuffer);
		System.out.println("insert 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		strBuffer.delete(3, 6); // 3번째부터 6번째 앞까지 삭제 : abcdef
		System.out.println("delete 후 : " + strBuffer);
		System.out.println("delete 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		int capacitySize = strBuffer.capacity(); // 버퍼의 가용크기
		System.out.println("버퍼의 가용크기 : " + capacitySize);
		strBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789");
		System.out.println("append 후 : " + strBuffer);
		System.out.println("append 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		System.out.println("많은 문자를 추가한 후 가용크기 : " + strBuffer.capacity());
	}
}
