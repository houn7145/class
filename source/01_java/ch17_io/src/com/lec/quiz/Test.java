package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<>();
		friends.add(new Friend("홍길동","서울시 용산구","010-9999-1234", new Date(new GregorianCalendar(1998,4,22).getTimeInMillis())));
		friends.add(new Friend("신길동","서울시 마포구","010-9999-9999", new Date(new GregorianCalendar(1998,3,5).getTimeInMillis())));
		Scanner sc = new Scanner(System.in);
		while(true) { 
			boolean searchOK = false;
			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");
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
				System.out.println("해당 지역의 친구는 없습니다");
			}
		}
	}

}
