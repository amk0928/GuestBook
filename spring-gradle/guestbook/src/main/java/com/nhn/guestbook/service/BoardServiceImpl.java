package com.nhn.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhn.guestbook.dao.BoardDAO;
import com.nhn.guestbook.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	protected BoardDAO boardDAO;
	
	
	public List<BoardDto> getBoard() {
		return boardDAO.getBoard();
	}

}
