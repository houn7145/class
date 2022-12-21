package com.lec.ex1_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square(); // 같은 패키지라 임폴트를 안함
		System.out.println("s1의 한변은 " + s1.getSide()); // 0으로 초기화
		s1.setSide(2);
		System.out.println("수정된 s1의 넓이는 " +s1.area());
		Square s2 = new Square(10);
		System.out.println("s2의 한변은 " + s2.getSide());
		System.out.println("s2의 넚이는 " + s2.area());
	}
}
