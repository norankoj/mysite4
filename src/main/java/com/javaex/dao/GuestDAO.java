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
	
	public int insert2(GuestbookVO vo) {
		System.out.println(vo.toString());
		sqlsession.insert("guest.insert2",vo);
		System.out.println(vo.toString());
		return vo.getNo(); //필요없는데 해줌 생각해봐라 
	}
	
	public List<GuestbookVO> select(){
		
		return sqlsession.selectList("guest.select");
	}
	
	public GuestbookVO selectNo(int no) {
		return sqlsession.selectOne("guest.selectNo", no);
	}

	public int delete(GuestbookVO vo) {
		return sqlsession.delete("guest.delete",vo);
	}

}
