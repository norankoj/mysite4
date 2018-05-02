package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVO;

@Controller
@RequestMapping("/guest")
public class Guestbookcontroller {

	@Autowired
	private GuestService service;

	@RequestMapping("/list")
	public String guest(Model model) {
		List<GuestbookVO> list = service.select();
		model.addAttribute("list", list);
		return "guestbook/list";
	}

	@RequestMapping("/insert")
	public String insert(GuestbookVO vo) {
		int no = service.add(vo);
		System.out.println(no + "삽입완료");
		return "redirect:/guest/list";
	}

	@RequestMapping("/deleteform")
	public String select(@RequestParam("no") int no) {
		System.out.println("삭제페이지");
		return "guestbook/deleteform";
	}

	@RequestMapping("/delete")
	public String delete(GuestbookVO vo) {
		System.out.println(vo);
		service.delete(vo);

		return "redirect:/guest/list";
	}

	@RequestMapping("/list-ajax")
	public String ajax_list() {
		System.out.println("ajax-list 연결");

		return "guestbook/ajax-list";
	}

}
