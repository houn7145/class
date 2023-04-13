package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// http://localhost:8090/ch08/의 요청 처리 로직
	@RequestMapping("/")
	public String home() {
//		model.addAttribute("greeting", "안녕, 스프링!");
		return "main"; // view 페이지 : "/WEB-INF/views/" + "main" + ".jsp"
	}
}
