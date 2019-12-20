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
	
	@Override
	public BoardDto getBoardWithID(int boardId) {
		return sqlSession.selectOne("BoardMapper.getBoardWithID", boardId);
	}
	
	@Override
	public void insertBaord(BoardDto boardDto) {
		sqlSession.insert("BoardMapper.insertBoard", boardDto);
	}
	
	@Override
	public void deleteBoard(BoardDto boardDto) {
		sqlSession.delete("BoardMapper.deleteBoard", boardDto);
	}

	@Override
	public int updateBoard(BoardDto boardDto) {
		return sqlSession.update("BoardMapper.updateBoard", boardDto);
	}
}
