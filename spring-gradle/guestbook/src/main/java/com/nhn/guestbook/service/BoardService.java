package com.nhn.guestbook.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nhn.guestbook.dto.BoardDto;

public interface BoardService {
	List<BoardDto> getBoard();
	public void insertBoard(BoardDto boardDto);
	void deleteBoard(BoardDto boardDto);
}
