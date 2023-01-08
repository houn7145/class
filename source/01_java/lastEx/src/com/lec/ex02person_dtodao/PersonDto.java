package com.lec.ex02person_dtodao;

// 입력용 : 이름, 직업명, 국, 영, 수  | 출력용 : rn, 이름(pno), 직업명, 국, 영, 수, 총점
public class PersonDto {
	private String rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;

	public PersonDto() {}

//	입력용 : 이름, 직업명, 국, 영, 수
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

//  출력용 : rn, 이름(pno), 직업명, 국, 영, 수, 총점	
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
