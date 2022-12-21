package com.lec.quiz;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890��-01-11", "java", "ȫ�浿"), 
				new BookLib("890��-01-12", "oracle", "���浿"),
				new BookLib("890��-02-01", "mysql", "���浿"), 
				new BookLib("890��-01-01", "jdbc", "���̵�"),
				new BookLib("890��-01-01", "html", "�̿���") };
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:����/2:�ݳ�/3:ålist/0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower = null, checkOutDate = null; // ����ڿ��� ���� å�̸�, ������, ������
		do {
			System.out.println("1:����/ 2:�ݳ�/ 3:å list/ 0:����");
			fn = scanner.nextInt();
			switch (fn) {
			case 1: // ������� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.print("�����ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if (idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				} else { // book[idx] ������ ����
					// 3.å����Ȯ��
					if (books[idx].getState() == BookLib.STATE_BORROWED) { // ������
						books[idx].checkOut(borrower, checkOutDate); // ������ �޼ҵ� ȣ��
					} else { // 4.�������Է�

						System.out.print("��������? : ");
						borrower = scanner.next(); // space x
						// 5.�������Է�
						System.out.println("��������? : ");
						checkOutDate = scanner.next(); // space x
						// 6.����޼ҵ� ȣ��
						books[idx].checkOut(borrower, checkOutDate);
					} // if - ����Ȯ��
				} // if - ���� ��ȸ
				break;
			case 2: // �ݳ����� : 1.å�̸��Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.print("�ݳ��ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if (idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				} else {
					// 3.�ݳ��޼ҵ� ȣ��
					books[idx].chechIn();
				}
				break;
			case 3: // å list ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ�� (Book book : books){}
				for (BookLib book : books) {
					book.printState();
				}
			}
		} while (fn != 0);
		System.out.println("����");
	}
}
