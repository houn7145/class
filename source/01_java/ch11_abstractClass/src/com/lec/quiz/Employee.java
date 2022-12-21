package com.lec.quiz;
// name, computePay, computeIncentive
public abstract class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;
	}
	public abstract int computePay();
	public final int computeIncentive() {
		int temp = computePay();
		if(temp >= 3000000)
		 {
		}return (int)(temp*0.05);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
