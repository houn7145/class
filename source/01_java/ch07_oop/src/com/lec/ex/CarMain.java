package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // �迭�� ���� 0���� �ʱ�ȭ
		myPorsche.setColor("����"); //myPorsche.color= "����";
		System.out.println(myPorsche.getColor()+"�� ���� ��ⷮ : " + myPorsche.getCc());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("��ȸ");// youPorsche.color = "��ȸ";
		yourPorsche.drive();
		System.out.println("���� �ӵ� : " + myPorsche.getSpeed());
	}
}
