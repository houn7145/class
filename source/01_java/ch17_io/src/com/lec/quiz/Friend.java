package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String address;
	private String phone;
	private Date birthday;
	public Friend() {
	}
	public Friend(String name, String address, String phone, Date birthday) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
		
	}@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		return "�� ��:" + name + " \n" + "�ּ�:" + address + " \n" + "�ڵ���:" + phone + " \n" + "�� ��:" + sdf1.format(birthday) + "\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
