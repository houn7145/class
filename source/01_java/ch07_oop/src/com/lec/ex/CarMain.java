package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // 배열과 같이 0으로 초기화
		myPorsche.setColor("빨강"); //myPorsche.color= "빨강";
		System.out.println(myPorsche.getColor()+"색 차량 배기량 : " + myPorsche.getCc());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("진회");// youPorsche.color = "진회";
		yourPorsche.drive();
		System.out.println("내차 속도 : " + myPorsche.getSpeed());
	}
}
