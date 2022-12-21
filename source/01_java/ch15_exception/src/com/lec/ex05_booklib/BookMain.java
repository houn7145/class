package com.lec.ex05_booklib;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890��-01-11", "java", "ȫ�浿"),
					   new Book("890��-01-12", "oracle", "���浿"),
					   new Book("890��-02-01", "mysql", "���浿"),
					   new Book("890��-01-01", "jdbc", "���̵�"),
					   new Book("890��-01-01", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:����/2:�ݳ�/3:ålist/0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower; // ����ڿ��� ���� å�̸�, ������
		
		do {
			System.out.println("1:����/ 2:�ݳ�/ 3:å list/ 0:����");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // ������� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.print("�����ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for(idx=0 ; idx < books.length ; idx ++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}// for
				if(idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				}else { // book[idx] ������ ����
					// 3.å����Ȯ��
					if(books[idx].getState() == Book.STATE_BORROWED) { // ������
						System.out.println("���� ���� ���� �����Դϴ�");
					}else {
						// 4.�������Է�
						System.out.print("��������? : ");
						borrower = scanner.next(); // space x
						// 5.�������Է� 
						// 6.����޼ҵ� ȣ��
						books[idx].checkOut(borrower);
					}// if - ����Ȯ��
				}// if - ���� ��ȸ
				break;
			case 2: // �ݳ����� : 1.å�̸��Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.print("�ݳ��ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for(idx=0 ; idx < books.length ; idx ++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}// for
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else {
					// 3.�ݳ��޼ҵ� ȣ��
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println("�ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");
					} // �ٲ� try catch
				}
				break;
			case 3: // å list ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ�� (Book book : books){}
				for(Book book : books ) {
					System.out.println(book);
				}
			}
		}while(fn!=0);
		System.out.println("����");
	}
}
