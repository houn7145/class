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
			System.out.println(i + "�� �ε��� �� : " + array[i]);
		}
		System.out.println("-------- ArrayList --------");

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 1�� �ε��� -> 2������ �ٲ�鼭 �� ������ �� �и� @
		arrayList.add("str2"); // 2�� �ε���
		arrayList.add(1, "111111"); // 1�� �ε����� 111111 �� @
		System.out.println("���� arrayList ������� : " + arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "------"); // 1�� �ε����� ���� -----�� ����
		arrayList.add("str3"); // arrayList�� �迭 ũ�Ⱑ ������ ���� ���� (�߰�����)
		for (String temp : arrayList) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		for (int i = 0 ; i < arrayList.size() ; i++) {
			System.out.println(i + "��° �ε��� ���� : " +arrayList.get(i)); // .get �޼ҵ�� ������
		}
		arrayList.remove(1); // 1�� �ε��� ���� (2�� �ε����� 1�� �ε��� �ڸ��� �ٲ�鼭 ������ �� �����)
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ����
		System.out.println("1�� �ε����� ������ �ε��� ���� �� : " + arrayList);
		arrayList.clear(); // arrayList�� ��� ������ ���� 
		System.out.println(arrayList.isEmpty() ? "arrayList ����� 0" : "arraryList ����� 0�� �ƴ�");
	//	arrayList = null; // arrayList ��ü�� ����
		System.out.println(arrayList.size());
	}
}
