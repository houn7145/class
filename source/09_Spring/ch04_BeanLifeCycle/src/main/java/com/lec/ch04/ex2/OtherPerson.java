package com.lec.ch04.ex2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;

@Data
public class OtherPerson {
	private String name;
	private int age;
	@PostConstruct
	public void postConstruct() {
		System.out.println("OtherPerson형 빈 객체 생성하자마자 자동 호출 : postConstruct()");
	}
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("OtherPerson형 객체 소멸 전 자동 호출 : preDestroyMethod()");
	}
}
