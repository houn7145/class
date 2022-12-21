package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str;
		do {
			System.out.println("회원가입 하시겠습니까? y/n");
			str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요");
				String name = sc.next();
				System.out.println("입력하신 이름은 : " + name);
				System.out.println("전화번호를 입력하세요 ");
				String tel = sc.next();
				System.out.println("입력하신 전화번호는 : " + tel);
				sc.nextLine();
				System.out.println("주소를 입력하세요 : ");
				String address = sc.nextLine();
				System.out.println("입력하신 주소는 : " + address);
				customers.add(new Customer(name, tel, address));
				
//				Customer newCustomer = new Customer();
//				System.out.print("가입하실 회원님 이름은?");
//				newCustomer.setName(scanner.next());
//				System.out.print("가입하실 회원님 전화는?");
//				newCustomer.setTel(scanner.next());
//				System.out.print("가입하실 회원님 주소는?");
//				scanner.nextLine();// 버퍼지우는 용도
//				newCustomer.setAddress(scanner.nextLine());
//				customers.add(newCustomer);
				continue;
			}
			if (str.equalsIgnoreCase("n") && customers.size() == 0) {
				System.out.println("가입한 회원이 없습니다");
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
