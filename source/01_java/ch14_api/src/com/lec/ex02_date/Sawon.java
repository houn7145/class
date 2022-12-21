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
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년MM월dd일");
		if(departmont.length()>8) {
			return "[사번]" + saNum + "\t[이름]" + name + "\t[부서]" + departmont + "\t[입사일]" + sdf1.format(date);
		}else 
			return "[사번]" + saNum + "\t[이름]" + name + "\t[부서]" + departmont + "\t\t[입사일]" + sdf1.format(date);
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
