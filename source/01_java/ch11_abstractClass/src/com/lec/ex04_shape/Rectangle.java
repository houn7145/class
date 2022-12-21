package com.lec.ex04_shape;

public class Rectangle extends Shape {
	private int w; // 가로
	private int h; // 세로

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		return w*h;
	}
	@Override
	public void draw() {
		System.out.print("사각형 ");
		super.draw();
	}

}
