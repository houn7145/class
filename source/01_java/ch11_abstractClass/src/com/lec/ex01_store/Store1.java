package com.lec.ex01_store;
// 1ȣ�� : ��ġ�-4,500 �δ��-5,000 �����-6,000 ���뱹-������ �����-1,000��
public class Store1 extends HeadQuarterStore {
	public Store1(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 �� ����");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 4,500��");
	}

	@Override
	public void bibim() {
		System.out.println("����� : 5,000d��");
	}
	@Override
	public void gongibab() {
		System.out.println("����� : 1,000��");
	}
}
