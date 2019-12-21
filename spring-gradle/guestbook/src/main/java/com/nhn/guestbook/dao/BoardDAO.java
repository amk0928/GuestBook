package com.nhn.guestbook.dao;

import java.util.List;

import com.nhn.guestbook.dto.BoardDto;

public interface BoardDAO {
	public List<BoardDto> getBoard();
	public BoardDto getBoardWithID(int boardId);
	public int insertBaord(BoardDto boardDto);
	public void deleteBoard(BoardDto boardDto);
	public int updateBoard(BoardDto BoardDto);
}
