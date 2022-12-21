package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); // 0번 인덱스
		linkedList.add("str1"); // 1번 인덱스
		linkedList.add("str2"); // 2번 인덱스
		linkedList.remove("str0");
		for(int i = 0 ; i<linkedList.size() ; i++) {
			System.out.println(i + " : " + linkedList.get(i));
		}
		linkedList.clear(); // 데이터 제거
		if(linkedList.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}else { 
			for(String temp : linkedList) {
				System.out.println(temp);
			}
		}
		System.out.println(linkedList.size());
	}
}
