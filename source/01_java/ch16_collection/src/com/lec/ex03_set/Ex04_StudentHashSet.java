package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex04_StudentHashSet {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println(s1.equals(s2));
		HashSet<Student> students = new HashSet<>();
		students.add(s1);
		students.add(s1); // new를 하지 않아서 하나만 들어감
		students.add(new Student(1, "홍길동"));
		students.add(new Student(1, "홍길동"));
		students.add(new Student(3, "장보고"));
		students.add(new Student(6, "이순신"));
		students.add(new Student(3, "신길동"));
		students.add(new Student(3, "신길동")); // hashCode와 equals를 오버라이드하여 1개만 들어감 
		System.out.println(students);
		students.remove(new Student(1, "홍길동"));
		System.out.println("홍딜동 remove 후 : " + students);
		
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
