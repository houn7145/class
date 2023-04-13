package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.uitest.vo.Student;

@Controller
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value="input.do", method=RequestMethod.GET)
	public String input(Student student) {
		return "student/input";
	}
	
	@RequestMapping(value="input.do", method=RequestMethod.POST)
	public String input(Student student, Model model) {
		int sum = student.getKor() + student.getEng() + student.getMat();
		model.addAttribute("sum", sum);
		model.addAttribute("avg", sum/3.0);
		return "student/result";
	}
}
