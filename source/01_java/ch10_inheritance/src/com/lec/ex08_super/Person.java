package com.lec.ex08_super;
// this.~ : �� ��ü�� ~
// this() : �� Ŭ������ ������ �Լ�(�Լ��� �� ���ٿ� �ۼ�)
// super.~ : �θ�Ŭ������ ~
// super() : �θ�Ŭ������ ������ �Լ�(�Լ��� �� ���ٿ� �ۼ�)
public class Person {
	private String name;
	private String character;
	public Person() {
		super(); // �θ�Ŭ������ �Ű����� ���� ������ �Լ�
		System.out.println("�Ű����� ���� Person ������");
	}
	public Person(String name, String character) {
		super();
		this.name = name;
		this.character = character;
		System.out.println("�Ű����� 2��¥�� Person ������");
	}
	public void intro() {
		System.out.println(name + "��" + character);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
