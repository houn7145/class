package com.lec.ex02_store;
// 3호점 : 김치찌개 6,000원, 부대찌개 7,000원, 비빔밥 7,000원, 얼큰순대국 6,000원
public class Store3 implements HeadQuarterStore{
	public Store3() {}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 : 7,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥: 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 : 6,000원");
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥 : 1,000원");
		
	}
	@Override
	public void storeName() {
		System.out.println("= = 증권가 3호점 = =");
	}

}
