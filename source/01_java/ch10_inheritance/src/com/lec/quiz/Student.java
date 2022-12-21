package com.lec.quiz;

public class Student extends Person {
	private String ban;
	public static int count=0;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setNo("student" + (++count));
	}

	@Override
	public void print() {
		System.out.println("(번호)"+getNo()+"\t(ID)"+getId()+"\t(이름):"+ getName() +"\t(반)"+ban);
	}

	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
}
