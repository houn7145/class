package com.lec.ex03_excetions;

public class Ex01_NullPointEx {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		String greering = null;
		System.out.println(greeting.toUpperCase());
	}

}
