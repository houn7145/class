package com.lec.method;
// sum(int, int) - sum(10, 100) / sum(10) - �Լ��� �����ε� / evenOdd(55) / abs(-9)
public class Arithmetic {
	public int sum(int from, int to) { // from���� to���� ���� ���� ��
		int result = 0; // ��������
		for(int i=from; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) {
		int result = 0;
		for(int i =1; i<=to ; i++) {
			result +=i;
		}
		return result;
	}
	public String evenOdd(int value) {
		return value%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
	}
	public static int abs(int value) { // ���밪�� reture. ���������� ������ ��� ->
		int result = value>=0? value : -value;
		return result;
	}
}
