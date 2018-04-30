package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class Usercontroller {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/joinform")
	public String joinform() {
		System.out.println("joinform");

		return "user/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(UserVO vo) {
		System.out.println("join");
		System.out.println(vo.toString());

		userService.join(vo);
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/loginform")
	public String loginform() {
		System.out.println("로그인화면");
		return "user/loginform";
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		UserVO authUser = userService.login(email, password); // 헷갈릴까봐 바꾼것
		// System.out.println(vo.toString());

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
			
		} else {

			return "redirect:/user/loginform?result=fail";
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/main";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpSession session, Model model) {
		System.out.println("수정폼");
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		UserVO vo= userService.modify(authUser.getNo());
		model.addAttribute("vo", vo);
		return"user/modifyform";
	}
	
	@RequestMapping("/update")
	public String update(HttpSession session, UserVO vo) {
		System.out.println("업데이트 완료");
		System.out.println(vo.toString());
		int no =userService.update(vo);
		System.out.println(no+"저장");
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		authUser.setName(vo.getName());
		return"redirect:/main";
	}
	
	@ResponseBody //바디에 데이터보낼꺼니까 이렇게 표시를 하면 기존방식이랑 다르다는 것! 
	@RequestMapping(value="/emailcheck",method=RequestMethod.POST)
	public boolean exists(@RequestParam ("email")String email) {
		System.out.println("ajax 이메일 체크"+email);
		//DB에 보내서 service에서 true/false 로 처리해 받아오기
		boolean isExists = true;
		
		//다 처리했다고 치고 true로 왓다고 하고 리턴에 true로 보냄 
		return isExists;
	
	}
	

}
