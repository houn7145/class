package com.lec.ex05_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NOMAL = 0; // ���� ����
	public void checkOut(String borrower); // ����
	public void checkIn() throws Exception; // �ݳ�
}
