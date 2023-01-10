package com.lec.ex02person_dtodao;

// �Է¿� : �̸�, ������, ��, ��, ��  | ��¿� : rn, �̸�(pno), ������, ��, ��, ��, ����
public class PersonDto {
	private String rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;

	public PersonDto() {}

//	�Է¿� : �̸�, ������, ��, ��, ��
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

//  ��¿� : rn, �̸�(pno), ������, ��, ��, ��, ����	
	public PersonDto(String rank, String pname, String jname, int kor, int eng, int mat, int sum) {
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}