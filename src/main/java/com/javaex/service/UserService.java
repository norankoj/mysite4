package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public int join(UserVO vo) {
		
		return dao.insert(vo);
	}
	
	public UserVO login(String email, String password) {
		
		return dao.getUser(email,password);
	}
	
	public UserVO modify(int no) {
		return dao.select(no);
	}
	
	public int update(UserVO vo) {
		return dao.update(vo);
	}

	

}
