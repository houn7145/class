package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // ���Ⱑ��(0), ������(1)

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + "������ �������Դϴ�");
			return;
		}
		// state�� 0(STATE_NOMAL)�̶� ���� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ������ ���·� ��ȯ
		System.out.println(getBookTitle() + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void chechIn() {
		if (state == STATE_NOMAL) {
			System.out.println(getBookTitle() + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		// state�� 1(STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL;
		System.out.println(getBookTitle() + "������ �ݳ� �Ϸ�Ǿ����ϴ�");

	}

	@Override
	public void printState() {
		String msg = getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "��) - ";
		// msg = msg + "���Ⱑ��";
		msg += state == STATE_NOMAL ? "���� ����" : "���� ��";
		System.out.println(msg);
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
