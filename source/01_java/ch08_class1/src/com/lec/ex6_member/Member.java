package com.lec.ex6_member;
// ������ : id, pw, name, email, address,birth, gender
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	
	public Member() {}

	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}

	public String infoString() {
		
	String result = "���̵� : " + id;
//	result += "\n��й�ȣ : " + pw; ��������
	result += "\n�̸� : " + name;
	result += "\n�̸��� : " + email;
	result += "\n�ּ� : " + address;
	result += "\n���� : " + birth;
	result += "\n���� : " + (gender=='m' ? '��' : (gender=='f' ? '��' : '��'));
		return result;
	}
//	public void print() {
//	System.out.println("���̵� : " + id);
//	System.out.println("��й�ȣ  : " + pw);
//	System.out.println("�̸�  : " + name);
//	System.out.println("�̸��� : " + email);
//	System.out.println("�ּ� : " + address);
//	System.out.println("���� : " + birth);
//	System.out.println("���� : " + (gender == 'm' ? '��' : (gender=='f' ? '��' : '��')) );
//}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	

}
