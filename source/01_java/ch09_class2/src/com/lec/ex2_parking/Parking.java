package com.lec.ex2_parking;

import com.lec.constant.Constant;

//������ no, inTime, outTtime, fee 
//�޼ҵ� : out(int outTime)
public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee; // �������
//	private final int HOURLYPARKINGRATE = 2000; // ��� (final ����)
	public Parking() {}
	
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println("������ ���� �� ��� : "+ no +"�� �������");
		System.out.println("\t\t�����ð� : " + inTime +"��");
		
	}
	

	public void out(int outTime) { // �����ð� 
		this.outTime = outTime; // �ʱ�ȭ
		fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
		System.out.println("������ ���� �� ��� : "+ no + "�� �ȳ��� ������");
		System.out.println("\t\t�����ð� : " + outTime + "��");
		System.out.println("\t\t������� : " + fee + "��");
	}

	
	
	
	
}
