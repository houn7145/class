package com.lec.ex01_store;
// �߻�Ŭ���� : �ϳ� �̻��� �߻�޼ҵ带 ���� ������ �߻�Ŭ������ �θ�
// �߻�Ŭ�����δ� ��ü�� ���� �� ����
// ����
// HeadQuarterStore head  = new HeadQuarterStore (" = = ���� = =");
public abstract class HeadQuarterStore { 
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	// �߻�޼ҵ� : ���� ����� Ŭ�������� �ݵ�� override �ʿ�
	// �޼ҵ��� ���� ���� ��,������ ����
	public abstract void kimchi(); 
	public abstract void bude() ;
	public abstract void bibim() ;
	public abstract void sunde() ;
	public abstract void gongibab();
	public String getStoreName() {
		return storeName;
	}
}
