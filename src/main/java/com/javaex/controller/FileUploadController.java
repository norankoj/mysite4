package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;
import com.javaex.vo.FileVO;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
	@Autowired 
	private FileUploadService fileuploadService;
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("file- form");
		return"fileupload/form";
	}
	
	/*@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file,Model model) {
		System.out.println(file.toString());
		System.out.println(file.getOriginalFilename());
		
		FileVO filevo = fileuploadService.restore(file);
		System.out.println(filevo.toString());
		model.addAttribute("filevo",filevo);
		return"fileupload/result";
	}*/
	
	

}
