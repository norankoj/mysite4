package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlsession;
	
	public List<BoardVO> select(){
		
		return sqlsession.selectList("Board.select");
	}
	
	public BoardVO getContent(BoardVO vo) {
		
		return sqlsession.selectOne("Board.getContent",vo);
	}
	
	public BoardVO modify(int no) {
		
		return sqlsession.selectOne("Board.getContent",no);
	}
	
	public int update(BoardVO vo) {
		
		return sqlsession.update("Board.update",vo);
	}
	
	public int updatehit (BoardVO vo) {
		
		return sqlsession.update("Board.updatehit",vo);
	}
	
	public int delete(int no) {
		
		return sqlsession.update("Board.delete",no);
	}
	
	public int insert(BoardVO vo) {
		return sqlsession.insert("Board.insert",vo);
	}
}
