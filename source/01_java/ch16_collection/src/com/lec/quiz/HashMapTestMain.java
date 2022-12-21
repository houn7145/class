package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTestMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<>();
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
				if(customers.get(tel) != null) {
					System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ�Դϴ�. ��ȣ��ȣ�� �ߺ��Ͽ� ���� �Ұ��մϴ�");
					continue;
				}
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ��� : ");
				String address = sc.nextLine();
				System.out.println("�Է��Ͻ� �ּҴ� : " + address);
				customers.put(tel, new Customer(name, tel, address));
				continue;
				
//				Customer newCustomer = new Customer();
//				System.out.print("�����Ͻ� ȸ���� �̸���?");
//				newCustomer.setName(scanner.next());
//				System.out.print("�����Ͻ� ȸ���� ��ȭ��?");
//				tel = scanner.next();
//				// ������ ������ ��ȭ��ȣ���� Ȯ���ϴ� ���
//				if(customers.get(tel)!=null) {
//					System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ�Դϴ�. ��ȣ��ȣ�� �ߺ��Ͽ� ���� �Ұ��մϴ�");
//					continue;
//				}
//				newCustomer.setTel(tel);
//				System.out.print("�����Ͻ� ȸ���� �ּҴ�?");
//				scanner.nextLine();// ��������� �뵵
//				newCustomer.setAddress(scanner.nextLine());
//				customers.put(tel, newCustomer);
			}
			if (str.equalsIgnoreCase("n") && customers.size() == 0) {
				System.out.println("������ ȸ���� �����ϴ�");
			}
		} while (!str.equalsIgnoreCase("n"));
		Iterator<String> cus = customers.keySet().iterator();
		while (cus.hasNext()) {
			String key = cus.next();
			System.out.println(customers.get(key));
		}
	}
}