package com.lec.ex02_store;
// 1ȣ�� : ��ġ�-4,500 �δ��-5,000 �����-6,000 ���뱹-������ �����-1,000��
public class Store1 implements HeadQuarterStore {
	public Store1() {}
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
	@Override
	public void storeName() {
		System.out.println("= = ���ð� 1ȣ�� = =");
		
	}
}
