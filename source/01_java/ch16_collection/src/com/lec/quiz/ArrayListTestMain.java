package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str;
		do {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? y/n");
			str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ���");
				String name = sc.next();
				System.out.println("�Է��Ͻ� �̸��� : " + name);
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� ");
				String tel = sc.next();
				System.out.println("�Է��Ͻ� ��ȭ��ȣ�� : " + tel);
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ��� : ");
				String address = sc.nextLine();
				System.out.println("�Է��Ͻ� �ּҴ� : " + address);
				customers.add(new Customer(name, tel, address));
				
//				Customer newCustomer = new Customer();
//				System.out.print("�����Ͻ� ȸ���� �̸���?");
//				newCustomer.setName(scanner.next());
//				System.out.print("�����Ͻ� ȸ���� ��ȭ��?");
//				newCustomer.setTel(scanner.next());
//				System.out.print("�����Ͻ� ȸ���� �ּҴ�?");
//				scanner.nextLine();// ��������� �뵵
//				newCustomer.setAddress(scanner.nextLine());
//				customers.add(newCustomer);
				continue;
			}
			if (str.equalsIgnoreCase("n") && customers.size() == 0) {
				System.out.println("������ ȸ���� �����ϴ�");
			}
		} while (!str.equalsIgnoreCase("n"));
//		for (int i = 0; i < customers.size(); i++) {
//			System.out.println(customers.get(i));
//			
//		}
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
