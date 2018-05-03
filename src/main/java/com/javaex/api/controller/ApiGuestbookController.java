package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVO;

@Controller
@RequestMapping("/api/gb")
public class ApiGuestbookController {
	
	@Autowired
	private GuestService service;
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public List<GuestbookVO> list() {
		System.out.println("list-ajax : guestbook");
		List<GuestbookVO> list = service.select();
		//System.out.println(list.toString());
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public GuestbookVO add(@RequestBody GuestbookVO vo) {
		System.out.println("add");
		System.out.println(vo.toString());
		
		GuestbookVO guestvo= service.write(vo);
		
		return guestvo;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public boolean delete(GuestbookVO vo) {
		System.out.println("ajax-delete");
		boolean isExists = service.delete(vo);
	
		return isExists;
	}
}
