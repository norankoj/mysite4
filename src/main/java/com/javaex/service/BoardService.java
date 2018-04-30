package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDAO;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public List<BoardVO> list(){
	
		
		return dao.select();
	}
	
	public BoardVO getContent(BoardVO vo) {
		dao.updatehit(vo);
		return dao.getContent(vo);
	}
	
	public BoardVO modify(int no) {
		
		return dao.modify(no);
	}
	
	public int update(BoardVO vo) {
		
		return dao.update(vo);
	}
	
	public int delete(int no) {
		return dao.delete(no);
	}
	
	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}
}
