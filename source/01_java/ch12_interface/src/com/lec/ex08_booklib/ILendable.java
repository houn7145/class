package com.lec.ex08_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NOMAL = 0; // ���� ����
	public void checkOut(String borrower, String checkOutDate); // ����
	public void chechIn(); // �ݳ�
	public void printState(); // å��ȣ å�̸�(����) ���Ⱑ�ɿ��� ���
}