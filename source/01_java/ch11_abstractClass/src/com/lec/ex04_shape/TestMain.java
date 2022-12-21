package com.lec.ex04_shape;

public class TestMain {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5), new Triangle(10, 5), new Rectangle(10, 20)};
		for(Shape s : shape) {
			s.draw();
			System.out.println("³ÐÀÌ´Â " + s.area());
		}
	}
}
