package com.javaex.dao;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int insert(UserVO vo) {
	
		return sqlsession.insert("user.insert",vo);
	}
	
	public UserVO getUser(String email, String password) {
		Map<String,String> usermap = new HashMap<String, String>();
		usermap.put("email",email);
		usermap.put("password", password);
		
		return sqlsession.selectOne("user.selectUserByEmailPw",usermap);
	}
	
	public UserVO select(int no) {
		
		return sqlsession.selectOne("user.select",no);
	}
	
     public int update(UserVO vo) {
		
		return sqlsession.update("user.update",vo);
	}
     
     public UserVO idCheck(String email) {
    	 
    	 return sqlsession.selectOne("user.idCheck", email);
     }


}
