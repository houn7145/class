package com.lec.ex05_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890��-101-1��","java","ȫ�浿")
public class Book implements ILendable {
	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	private String borrower; // ������
	private Date checkOutDate; // ������
	private byte state; // ���Ⱑ��(0), ������(1)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if (state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "������ �������Դϴ�");
			return;
		}
		// state�� 0(STATE_NOMAL)�̶� ���� ����

		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		state = STATE_BORROWED; // ������ ���·� ��ȯ
		System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + sdf1.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NOMAL) {
			throw new Exception(bookTitle + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���"); // �ٲ�
		}

		checkOutDate.getTime();
		Date now = new Date();
		now.getTime();
		long diff = now.getTime() - checkOutDate.getTime(); // ����������� ���ݱ����� �и�����
		long day = diff / (24 * 60 * 60 * 1000); // ���� ��
		if (day > 14) {
			System.out.println(bookTitle + "���� ��ü�Ǿ����ϴ�  ��ü�� ���� 100�� �ΰ��մϴ�");
			System.out.printf("��ü��� %d�� �Դϴ�\n", (day - 14) * 100);
			System.out.println("��ü�Ḧ ���̳���? y/n");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			if (!str.trim().equalsIgnoreCase("y")) {
				System.out.println(bookTitle + "��ü�Ḧ ���ž� �ݳ��� �����մϴ�");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
	// checkOutDate�� ����������� ��¥ ���

	// �ݳ�
	// ��ü�� ��� - ��ü�� �´��� ���ο� ���� �ݳ�ó��
	// state�� 1(STATE_BORROWED)�̶� �ݳ� ó��

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��) - ";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		// msg = msg + "���Ⱑ��";
		msg += state == STATE_NOMAL ? "���� ����" : "���� �� " + sdf1.format(checkOutDate);
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
