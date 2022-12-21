package com.lec.quiz;
// 객체 생성 : ("정우성", 90, 80, 100); -> 번호, 총점, 평균도 같이 초기화
// 데이터 : 번호 이름 국 영 수 총 평 new Student 
public class Student {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg;
	public static int count=0;
	
	
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3;
		num = ++count;
	}
	public void infoPrint() {
		System.out.printf("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", num, name, kor, eng, mat, tot, avg);
//	public String infoString() {
//		return String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", num, name, kor, eng, mat, tot, avg);
//	}
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
}
