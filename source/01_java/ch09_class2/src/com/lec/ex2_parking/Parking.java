package com.lec.ex2_parking;

import com.lec.constant.Constant;

//데이터 no, inTime, outTtime, fee 
//메소드 : out(int outTime)
public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee; // 주차요금
//	private final int HOURLYPARKINGRATE = 2000; // 상수 (final 변수)
	public Parking() {}
	
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println("주차장 들어올 때 결과 : "+ no +"님 어서오세요");
		System.out.println("\t\t입차시간 : " + inTime +"시");
		
	}
	

	public void out(int outTime) { // 출차시간 
		this.outTime = outTime; // 초기화
		fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
		System.out.println("주차장 나갈 때 결과 : "+ no + "님 안녕히 가세요");
		System.out.println("\t\t출차시간 : " + outTime + "시");
		System.out.println("\t\t주차요금 : " + fee + "원");
	}

	
	
	
	
}
