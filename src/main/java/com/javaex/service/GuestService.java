package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDAO;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestService {

	@Autowired
	private GuestDAO dao;
	
	
	public int add(GuestbookVO vo) {
		
		return dao.insert(vo);
	}
	
	public List<GuestbookVO> select(){
		return dao.select();
	}

	public int delete(GuestbookVO vo) {
		return dao.delete(vo);
	}
	
	public GuestbookVO write(GuestbookVO vo) {
		//insert
		int no=dao.insert2(vo);
		
		//select
		
		return dao.selectNo(no);
	}
}
