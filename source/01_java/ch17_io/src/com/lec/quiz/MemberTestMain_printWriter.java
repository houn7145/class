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
			System.out.println("ȸ�������� ���Ͻʴϱ�(y/n)?");
			str = sc.next();
			if (str.trim().equalsIgnoreCase("n"))
				break;
			if (str.trim().equalsIgnoreCase("y")) {
				System.out.print("�̸��� �Է��ϼ��� ");
				String name = sc.next();
				System.out.print("��ȭ��ȣ�� �Է��ϼ���");
				String tel = sc.next();
				System.out.print("������ �Է��ϼ���(YYYY-MM-DD)");
				String birthday = sc.next();
				StringTokenizer token = new StringTokenizer(birthday, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken());
					day = Integer.parseInt(token.nextToken());
					birth = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
					birthday = birthday.substring(birthday.indexOf("-") + 1); // "12-20"���� ����� now Date�� ��
					if (birthday.equals(today)) {
						System.out.println(name + "�� ���� �����̽ó׿� ���ϵ帳�ϴ�");
					}
				} else {
					System.out.println("������ �߸� �Է� �ϼ̽��ϴ� �ٽ� ȸ���������ּ���");
					continue;
				}
				sc.nextLine();
				System.out.print("�ּҸ� �Է��ϼ���");
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
			String msg = String.format("\t\t\t.... ���� %d�� ����", members.size());
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
