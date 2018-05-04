package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;
import com.javaex.vo.FileVO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private FileUploadService service;
	
    @RequestMapping("/upload")
	public String add(@RequestParam("file") MultipartFile file) {
    	System.out.println("gallery-연결");
    	
    	service.restore(file);

		return "redirect:/gallery/list";
	}
    
    @RequestMapping("/list")
    public String List(Model model) {
    	
    	java.util.List<FileVO> fileList= service.list();
    	model.addAttribute("fileList",fileList);
    	return "gallery/list";
    }

}
