package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birthday;
	private String address;

	public Member() {
	}

	public Member(String name, String tel, Date birthday, String address) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		return name + "\t" + tel + "\t" + sdf1.format(birthday) + "\t" + address + "\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
