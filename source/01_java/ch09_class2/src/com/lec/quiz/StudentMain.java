package com.lec.quiz;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 80 ,95);
		Student s2 = new Student("김하늘", 100, 80 ,95);
		Student s3 = new Student("황정민", 95, 80 ,90);
		Student s4 = new Student("강동원", 95, 90 ,99);
		Student s5 = new Student("유아인", 90, 90 ,90);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};
		int korTot = 0;
		int engTot = 0;
		int matTot = 0;
		int totTot = 0;
		int avgTot = 0;
		int[] total = new int[5];
		line();
		System.out.println("\t\t성적표");
		line('-');
		for(String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println(); // 개행
		line('-');
		for(Student student : students) {
			student.infoPrint();
			total[0] += student.getKor(); // 국어점수 누적
			total[1] += student.getEng(); // 영어점수 누적
			total[2] += student.getMat(); // 수학점수 누적
			total[3] += student.getTot(); // 평균점수 누적
			total[4] += student.getAvg(); // 평균 누적
		}
		line('-');
		System.out.print("\t\t총점");
		for(int t : total) {
			System.out.print("\t"+t);
		}
		System.out.print("\n\t\t평균");
		for(int t :total) {
			System.out.printf("\t%d",t/students.length);
		}
		System.out.println();
		line();
	}
	private static void line(char c) {
		System.out.println("\t");
		for(int i = 0 ; i<=65; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	private static void line() {
		for(int i = 0; i<65 ; i++) {
			System.out.print("■");
		}
		System.out.println();
	}

}
