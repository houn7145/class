package com.lec.ex2;
import com.lec.ex2_human.*;
import com.lec.ex2_human.kid.Kid;
// ctrl + shigt + o : 불필요한 import 제거
public class HumanMain {
	public static void main(String[] args) {
		Woman woman1    =    new Woman();
		Woman woman2    =    new Woman();
	// --------------	   ----------------
	// 레퍼런스(객체)변수선언    객체선언(인스턴스 생성)
		// System.out.println("woman1과 woman2가 같은지 : " + (woman1 == woman2));
		System.out.println("woman1과 woman2가 같은 객체인지 : " + woman1.equals(woman2));
		// 객체를 비교할 때는 .equals란 메소드를 사용
		Man man = new Man();
		Kid kid1 = new Kid("홍아기");
		// Kid kid2 = new Kid(); // 개발자가 생성자 함수를 만들면 디폴트 생성자 함수는 자동 생성을 안함
		Man hong = new Man("홍길동");
		Man kim = new Man("김길동", 22, 100, 67);
		Man kim2 = kim;
		
		kim2.setHeight(185); kim2.setWeight(300);
		System.out.println("kim과 kim2가 같은 객체인지 : " + kim.equals(kim2)); // 객체 비교
		double bmi = kim.calculateBMI();
		System.out.println(kim2.getName()+"의 bmi지수는 " + bmi);
	}
}
