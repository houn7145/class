package com.lec.ex05_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890ㅁ-101-1ㄱ","java","홍길동")
public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate; // 대출일
	private byte state; // 대출가능(0), 대출중(1)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if (state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "도서는 대출중입니다");
			return;
		}
		// state가 0(STATE_NOMAL)이라서 대출 진행

		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		state = STATE_BORROWED; // 대출중 상태로 전환
		System.out.println(bookTitle + "도서가 대출 처리 되었습니다");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + sdf1.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NOMAL) {
			throw new Exception(bookTitle + "도서는 반납완료된 책입니다. 확인하세요"); // 바꿈
		}

		checkOutDate.getTime();
		Date now = new Date();
		now.getTime();
		long diff = now.getTime() - checkOutDate.getTime(); // 대출시점부터 지금까지의 밀리세컨
		long day = diff / (24 * 60 * 60 * 1000); // 빌린 날
		if (day > 14) {
			System.out.println(bookTitle + "도서 연체되었습니다  연체료 일일 100원 부가합니다");
			System.out.printf("연체료는 %d원 입니다\n", (day - 14) * 100);
			System.out.println("연체료를 내셨나요? y/n");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			if (!str.trim().equalsIgnoreCase("y")) {
				System.out.println(bookTitle + "연체료를 내셔야 반납이 가능합니다");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
	}
	// checkOutDate와 현재시점간의 날짜 계산

	// 반납
	// 연체료 출력 - 연체료 냈는지 여부에 따라 반납처리
	// state가 1(STATE_BORROWED)이라서 반납 처리

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "著) - ";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		// msg = msg + "대출가능";
		msg += state == STATE_NOMAL ? "대출 가능" : "대출 중 " + sdf1.format(checkOutDate);
		return msg;
	}

	// getters
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setState(byte state) {
		this.state = state;
	}
}
