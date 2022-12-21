package com.lec.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_printWriter {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		Scanner sc = new Scanner(System.in);
		String str;
		int year, month, day;
		Date birth = null;
		do {
			System.out.println("회원가입을 원하십니까(y/n)?");
			str = sc.next();
			if (str.trim().equalsIgnoreCase("n"))
				break;
			if (str.trim().equalsIgnoreCase("y")) {
				System.out.print("이름을 입력하세요 ");
				String name = sc.next();
				System.out.print("전화번호를 입력하세요");
				String tel = sc.next();
				System.out.print("생일을 입력하세요(YYYY-MM-DD)");
				String birthday = sc.next();
				StringTokenizer token = new StringTokenizer(birthday, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken());
					day = Integer.parseInt(token.nextToken());
					birth = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
					birthday = birthday.substring(birthday.indexOf("-") + 1); // "12-20"으로 만들고 now Date와 비교
					if (birthday.equals(today)) {
						System.out.println(name + "님 오늘 생일이시네요 축하드립니다");
					}
				} else {
					System.out.println("생일을 잘못 입력 하셨습니다 다시 회원가입해주세요");
					continue;
				}
				sc.nextLine();
				System.out.print("주소를 입력하세요");
				String address = sc.nextLine();
				members.add(new Member(name, tel, birth, address));
			}
		} while (true);
		sc.close();
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("txtFile/member.txt");
			for (Member member : members) {
				System.out.print(member);
				printWriter.write(member.toString());
			}
			String msg = String.format("\t\t\t.... 이하 %d명 가입", members.size());
			System.out.println(msg);
			printWriter.write(msg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
