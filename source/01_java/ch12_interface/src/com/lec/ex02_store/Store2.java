package com.lec.ex02_store;
// 2호점 : 부대찌개 5,000원, 비빔밥 5,000원, 공기밥 무료
public class Store2 implements HeadQuarterStore {
	public Store2() {}
	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 : 5,000원");
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥 : 무료");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 : 5,000원");
		
	}
	@Override
	public void storeName() {
		System.out.println("= = 대학가 2호점 = =");
	}
}
