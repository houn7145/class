package com.lec.quiz;

public class Staff extends Person {
	private String department;
	
	public static int count=0;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		setNo("staff"+(++count));
		
	}
	@Override
	public void print() {
		System.out.println("(번호)"+getNo()+"\t(ID)"+getId()+"\t(이름):"+ getName() +"\t(부서)"+department);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
