package com.lec.ex02person_dtodao;

import java.util.ArrayList;
import java.util.Scanner;

public class personMainDD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<String> jobs = dao.jnamelist(); // 직업명들 저장
		do {
			System.out.print("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = sc.next(); // String
			switch (fn) {
			case "1": // 이름, 직업명(jobs), 국,영,수 받아 insert
				System.out.print("입력하고자 하는 이름은 ?");
				String pname = sc.next();
				System.out.print("입력하고자 하는 직업명은 ?");
				System.out.println(jobs);
				String jname = sc.next();
				System.out.print("국어 점수는 ?");
				int kor = sc.nextInt();
				System.out.print("영어 점수는 ?");
				int eng = sc.nextInt();
				System.out.print("수학 점수는 ?");
				int mat = sc.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				break;
			case "2": // 직업명받아 직업 출력
				System.out.print("출력하고자 하는 직업명은 ?");
				System.out.println(jobs);
				jname = sc.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				if (dtos.isEmpty()) {
					System.out.println(jname + "직업군의 사람은 없습니다");
				} else {
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3":
				dtos = dao.selectAll();
				if (dtos.size() == 0) {
					System.out.println("등록된 사람이 없습니다");
				} else {
					for (int idx = 0; idx < dtos.size(); idx++) {
						System.out.println(dtos.get(idx));
					}
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}