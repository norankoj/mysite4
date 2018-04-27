package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Maincontoller {

	@RequestMapping(value="/main")
	public String main() {
		System.out.println("연결완료");
		return"main/index";
	}
}
