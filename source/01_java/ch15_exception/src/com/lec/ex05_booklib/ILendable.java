package com.lec.ex05_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NOMAL = 0; // 대출 가능
	public void checkOut(String borrower); // 대출
	public void checkIn() throws Exception; // 반납
}
