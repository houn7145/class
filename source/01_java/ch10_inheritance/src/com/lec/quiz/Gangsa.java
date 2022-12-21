package com.lec.quiz;

public class Gangsa extends Person {
	private String subject;
	
	public static int count=0;

	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setNo("lecturer" + (++count));
	}
	
	@Override
	public void print() {
		System.out.println("(번호)"+getNo()+"\t(ID)"+getId()+"\t(이름):"+ getName() +"\t(과목)"+subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	


	
	
	
		
	

}
