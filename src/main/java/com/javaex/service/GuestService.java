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

	public boolean delete(GuestbookVO vo) {
		int no = dao.delete(vo);
		if (no == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public GuestbookVO write(GuestbookVO vo) {
		//insert
		int no=dao.insert2(vo);
		
		//select
		
		return dao.selectNo(no);
	}
}
