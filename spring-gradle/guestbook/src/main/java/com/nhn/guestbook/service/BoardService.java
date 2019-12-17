package com.nhn.guestbook.service;

import java.util.List;
import java.util.Map;

import com.nhn.guestbook.dto.BoardDto;

public interface BoardService {
	List<BoardDto> getBoard();
}
