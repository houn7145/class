package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	private Date date;
	private String saNum;
	private String name;
	private String departmont;
	static String COMPUTER = "COMPUTER";
	static String PLANNING = "PLANNING";
	static String DESIGN = "DESIGN";
	static String ACCOUNTING = "ACCOUNTING";
	static String HUMANRESOURCES = "HUMANRESOURCES";
	
	public Sawon(String saNum, String name, String departmont) {
		this.saNum = saNum;
		this.name = name;
		this.departmont = departmont;
		date = new Date();
	}
	public Sawon(String saNum, String name, String departmont, int year, int month, int day) {
		this.saNum = saNum;
		this.name = name;
		this.departmont = departmont;
		date = new Date((new GregorianCalendar(year, month - 1, day).getTimeInMillis()));
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
		if(departmont.length()>8) {
			return "[���]" + saNum + "\t[�̸�]" + name + "\t[�μ�]" + departmont + "\t[�Ի���]" + sdf1.format(date);
		}else 
			return "[���]" + saNum + "\t[�̸�]" + name + "\t[�μ�]" + departmont + "\t\t[�Ի���]" + sdf1.format(date);
	}
	public String getSaNum() {
		return saNum;
	}
	public String getName() {
		return name;
	}
	public String getDepartmont() {
		return departmont;
	}
	public Date getDate() {
		return date;
	}
	
	
	
}
