package com.nhn.guestbook.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nhn.guestbook.dto.BoardDto;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> getBoard() {
		return sqlSession.selectList("BoardMapper.getBoard");
	}

}
