package com.lec.quiz;

public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NOMAL = 0; // 대출 가능
	public void checkOut(String borrower, String checkOutDate); // 대출
	public void chechIn(); // 반납
	public void printState(); // 책번호 책이름(저자) 대출가능여부 출력
}
