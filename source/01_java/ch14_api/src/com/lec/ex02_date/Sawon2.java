package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	private Date date;
	private String saNum;
	private String name;
	private String dept;
	static String COMPUTER = "COMPUTER";
	static String PLANNING = "PLANNING";
	static String DESIGN = "DESIGN";
	static String ACCOUNTING = "ACCOUNTING";
	static String HUMANRESOURCES = "HUMANRESOURCES";
	
	public Sawon2(String saNum, String name, String dept) {
		this.saNum = saNum;
		this.name = name;
		this.dept = dept;
		date = new Date();
	}
	public Sawon2(String saNum, String name, String departmont, int year, int month, int day) {
		this.saNum = saNum;
		this.name = name;
		this.dept = dept;
		date = new Date((new GregorianCalendar(year, month - 1, day).getTimeInMillis()));
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
		if(dept.length()>8) {
			return "[���]" + saNum + "\t[�̸�]" + name + "\t[�μ�]" + dept + "\t[�Ի���]" + sdf1.format(date);
		}else 
			return "[���]" + saNum + "\t[�̸�]" + name + "\t[�μ�]" + dept + "\t\t[�Ի���]" + sdf1.format(date);
		
	}
	public String getSaNum() {
		return saNum;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public Date getDate() {
		return date;
	}
	
	
	
}
