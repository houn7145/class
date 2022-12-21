package com.lec.ex01_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (String arr : array) {
			System.out.println(arr);
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + "번 인덱스 값 : " + array[i]);
		}
		System.out.println("-------- ArrayList --------");

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스 -> 2번으로 바뀌면서 뒷 순서가 쭉 밀림 @
		arrayList.add("str2"); // 2번 인덱스
		arrayList.add(1, "111111"); // 1번 인덱스에 111111 들어감 @
		System.out.println("현재 arrayList 사이즈는 : " + arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "------"); // 1번 인덱스의 값을 -----로 수정
		arrayList.add("str3"); // arrayList는 배열 크기가 정해져 있지 않음 (추가가능)
		for (String temp : arrayList) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		for (int i = 0 ; i < arrayList.size() ; i++) {
			System.out.println(i + "번째 인덱스 값은 : " +arrayList.get(i)); // .get 메소드로 가져옴
		}
		arrayList.remove(1); // 1번 인덱스 제거 (2번 인덱스가 1번 인덱스 자리로 바뀌면서 순서가 쭉 당겨짐)
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 제거
		System.out.println("1번 인덱스와 마지막 인덱스 제거 후 : " + arrayList);
		arrayList.clear(); // arrayList안 모든 데이터 제거 
		System.out.println(arrayList.isEmpty() ? "arrayList 사이즈가 0" : "arraryList 사이즈가 0이 아님");
	//	arrayList = null; // arrayList 자체를 없앰
		System.out.println(arrayList.size());
	}
}
