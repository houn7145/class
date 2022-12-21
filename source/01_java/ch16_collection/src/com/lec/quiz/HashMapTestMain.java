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
			System.out.println("회원가입 하시겠습니까? y/n");
			str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요");
				String name = sc.next();
				System.out.println("입력하신 이름은 : " + name);
				System.out.println("전화번호를 입력하세요 ");
				String tel = sc.next();
				System.out.println("입력하신 전화번호는 : " + tel);
				if(customers.get(tel) != null) {
					System.out.println("이미 가입되어 있는 전화번호입니다. 전호번호는 중복하여 가입 불가합니다");
					continue;
				}
				sc.nextLine();
				System.out.println("주소를 입력하세요 : ");
				String address = sc.nextLine();
				System.out.println("입력하신 주소는 : " + address);
				customers.put(tel, new Customer(name, tel, address));
				continue;
				
//				Customer newCustomer = new Customer();
//				System.out.print("가입하실 회원님 이름은?");
//				newCustomer.setName(scanner.next());
//				System.out.print("가입하실 회원님 전화는?");
//				tel = scanner.next();
//				// 기존에 가입한 전화번호인지 확인하는 방법
//				if(customers.get(tel)!=null) {
//					System.out.println("이미 가입되어 있는 전화번호입니다. 전호번호는 중복하여 가입 불가합니다");
//					continue;
//				}
//				newCustomer.setTel(tel);
//				System.out.print("가입하실 회원님 주소는?");
//				scanner.nextLine();// 버퍼지우는 용도
//				newCustomer.setAddress(scanner.nextLine());
//				customers.put(tel, newCustomer);
			}
			if (str.equalsIgnoreCase("n") && customers.size() == 0) {
				System.out.println("가입한 회원이 없습니다");
			}
		} while (!str.equalsIgnoreCase("n"));
		Iterator<String> cus = customers.keySet().iterator();
		while (cus.hasNext()) {
			String key = cus.next();
			System.out.println(customers.get(key));
		}
	}
}