package com.lec.ex02_store;
// 추상클래스 : 하나 이상의 추상메소드를 갖고 있으면 추상클래스라 부름
// 추상클래스로는 객체를 만들 수 없음
// 본사
// HeadQuarterStore head  = new HeadQuarterStore (" = = 본사 = =");
public interface HeadQuarterStore { 
	// 추상메소드 : 나를 상속한 클래스에서 반드시 override 필요
	// 메소드의 선언만 있을 뿐,구현은 없음
	public abstract void kimchi(); 
	public abstract void bude() ;
	public abstract void bibim() ;
	public abstract void sunde() ;
	public abstract void gongibab();
	public abstract void storeName();
}
