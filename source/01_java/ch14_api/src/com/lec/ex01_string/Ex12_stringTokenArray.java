package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenArray {
	public static void main(String[] args) {
		String str = "�ں��� ���� ���� ��ҿ� �嵿��";
		StringTokenizer Tokenizer = new StringTokenizer(str);
		String[] arr = new String[Tokenizer.countTokens()];
		int idx = 0;
		while(Tokenizer.hasMoreTokens()) {
			arr[idx] = Tokenizer.nextToken();
			idx++;
		}
		System.out.println("�迭�� ����� ������ : ");
		for(String a : arr) {
			System.out.println(a);
		}
	}
}
