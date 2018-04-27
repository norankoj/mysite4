package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping("/board")
public class Boardcontroller {
	@Autowired
	private BoardService service;

	@RequestMapping("/list")
	public String board(Model model) {
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		return "board/list";
	}

	@RequestMapping("/view")
	public String view(BoardVO vo, Model model) {

		BoardVO VO = service.getContent(vo);
		model.addAttribute("vo", VO);
		return "board/view";
	}

	@RequestMapping("/modify")
	public String modify(@RequestParam("no") int no, Model model) {

		BoardVO vo = service.modify(no);
		model.addAttribute("vo", vo);
		return "board/modify";
	}

	@RequestMapping("/update")
	public String update(BoardVO vo) {
		int no = service.update(vo);
		System.out.println(no + "업데이트 완료");
		return "redirect:/board/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no) {

		int num = service.delete(no);
		System.out.println(num + "삭제완료");

		return "redirect:/board/list";
	}

	@RequestMapping("/write")
	public String write() {

		return "board/write";

	}

	@RequestMapping("/insert")
	public String insert(BoardVO vo, HttpSession session) {
		UserVO authUser = (UserVO) session.getAttribute("authUser");
		vo.setUser_no(authUser.getNo());
		int num = service.insert(vo);
		System.out.println(num + "등록완료");
		return "redirect:/board/list";
	}

}
