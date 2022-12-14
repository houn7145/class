package com.lec.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex04_object.Friend;

// 오늘 생일인 친구들 출력
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-12", "서울 서대문"),
				new Friend("김길동", "010-8888-9999", "12-01", "수원 영통"),
				new Friend("신길동", "010-9999-7777", "02-10", "서울 용산"),
				new Friend("마길동", "010-6666-6666", "03-03", "인천 송도") };
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		String monthStr = month < 10 ? "0" + month : "" + month; // int인 month를 String으로 변환 :"12"
		// String SmonthStr = month<10 ? "0" + month :String.valueOf(month); // "12"
		String dayStr = day < 10 ? "0" + day : "" + day;
		String today = monthStr + "-" + dayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("오늘 생일인 친구 목록을 검색합니다");
		for (int idx = 0; idx < friends.length; idx++) {
			String birth = friends[idx].getBirth();
			if (today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // 한명 이상 출력 시 none은 false
			} // if
		} // for
		if (none) {
			System.out.println("오늘 생일인 친구가 없습니다");
		}
	}// main
}// calss
