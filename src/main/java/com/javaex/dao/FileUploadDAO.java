package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.FileVO;

@Repository
public class FileUploadDAO {

	@Autowired 
	private SqlSession sqlsession;
	
	public int insert(FileVO filevo) {
		
		return sqlsession.insert("fileUpload.insert",filevo);
	}

	public List<FileVO> selectList(){
		
		return sqlsession.selectList("fileUpload.getList");
	}
	
	
}
