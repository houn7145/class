package com.lec.ex02_protected.copy;
// private i, j // public setI(), getI(), setJ(), getJ()
public class Child extends SuperIJ {
	private int total;
	public Child() {
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j ) { // // super �̿��Ͽ� ����
		super(i,j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ� - i, j �ʱ�ȭ ");
//		// setI(i); 
//		this.i = i; // protected�� ����
//		// setJ(j);
//		this.j = j; // protected�� ����
	}
	public void sum() {
		// total = getI() + getJ(); 
		total = i + j; // protected�� ����
		System.out.println("i= " + getI() +", j="+getJ() + ", total=" + total);
	}
}
