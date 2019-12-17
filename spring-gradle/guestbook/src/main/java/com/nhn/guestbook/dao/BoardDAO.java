package com.nhn.guestbook.dao;

import java.util.List;

import com.nhn.guestbook.dto.BoardDto;

public interface BoardDAO {
	public List<BoardDto> getBoard();
}
