package com.nhn.guestbook.dao;

import java.util.List;

import com.nhn.guestbook.dto.BoardDto;

public interface BoardDAO {
	public List<BoardDto> getBoard();
	public void insertBaord(BoardDto boardDto);
	public void deleteBoard(BoardDto boardDto);
}
