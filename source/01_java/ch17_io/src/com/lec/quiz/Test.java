package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<>();
		friends.add(new Friend("ȫ�浿","����� ��걸","010-9999-1234", new Date(new GregorianCalendar(1998,4,22).getTimeInMillis())));
		friends.add(new Friend("�ű浿","����� ������","010-9999-9999", new Date(new GregorianCalendar(1998,3,5).getTimeInMillis())));
		Scanner sc = new Scanner(System.in);
		while(true) { 
			boolean searchOK = false;
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchAdd = sc.next();
			if(searchAdd.equalsIgnoreCase("x"))
				break;
			for(Friend friend : friends) {
				String add = friend.getAddress();
				String postAdd = add.substring(0,2);
				if(searchAdd.equals(postAdd)) {
					System.out.println(friend);
					searchOK = true;
				}
			}
			if(!searchOK) {
				System.out.println("�ش� ������ ģ���� �����ϴ�");
			}
		}
	}

}
