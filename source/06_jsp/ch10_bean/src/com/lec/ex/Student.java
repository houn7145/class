package com.lec.ex;

public class Student {
	private String gradeNum;
	private String name;
	private int grade;
	private String ban;
	private int jumsu;
	public Student() {}
	public Student(String gradeNum, String name, int grade, String ban, int jumsu) {
		this.gradeNum = gradeNum;
		this.name = name;
		this.grade = grade;
		this.ban = ban;
		this.jumsu = jumsu;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public int getJumsu() {
		return jumsu;
	}
	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
}
