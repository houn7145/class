package com.lec.ex06_toy;

public class AirPlaneToy implements IMissile, ILight {

	public AirPlaneToy() {
		System.out.println("������Դϴ�");
		canLight();
		canMissile();
	}

	@Override
	public void canLight() {
		System.out.println("�Һ��߻� �� �� �ֽ��ϴ�");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");

	}

}
