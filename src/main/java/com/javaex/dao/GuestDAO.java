package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int insert(GuestbookVO vo) {
		
		return sqlsession.insert("guest.insert",vo);
	}
	
	public List<GuestbookVO> select(){
		
		return sqlsession.selectList("guest.select");
	}

	public int delete(GuestbookVO vo) {
		return sqlsession.delete("guest.delete",vo);
	}

}
