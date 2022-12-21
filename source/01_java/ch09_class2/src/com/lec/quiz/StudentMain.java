package com.lec.quiz;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("���켺", 90, 80 ,95);
		Student s2 = new Student("���ϴ�", 100, 80 ,95);
		Student s3 = new Student("Ȳ����", 95, 80 ,90);
		Student s4 = new Student("������", 95, 90 ,99);
		Student s5 = new Student("������", 90, 90 ,90);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"��ȣ", "�̸�", "����", "����", "����", "����", "���"};
		int korTot = 0;
		int engTot = 0;
		int matTot = 0;
		int totTot = 0;
		int avgTot = 0;
		int[] total = new int[5];
		line();
		System.out.println("\t\t����ǥ");
		line('-');
		for(String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println(); // ����
		line('-');
		for(Student student : students) {
			student.infoPrint();
			total[0] += student.getKor(); // �������� ����
			total[1] += student.getEng(); // �������� ����
			total[2] += student.getMat(); // �������� ����
			total[3] += student.getTot(); // ������� ����
			total[4] += student.getAvg(); // ��� ����
		}
		line('-');
		System.out.print("\t\t����");
		for(int t : total) {
			System.out.print("\t"+t);
		}
		System.out.print("\n\t\t���");
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
			System.out.print("��");
		}
		System.out.println();
	}

}
