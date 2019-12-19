package com.nhn.guestbook.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhn.guestbook.dao.BoardDAO;
import com.nhn.guestbook.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	protected BoardDAO boardDAO;
	
	
	public List<BoardDto> getBoard() {
		Predicate<BoardDto> filterPredicate = item -> 0 == item.getDeleted();
		Stream<BoardDto> stream = boardDAO.getBoard().stream()
				.filter(filterPredicate);
		return stream.collect(Collectors.toList());
	}
	
	public void insertBoard(BoardDto boardDto) {
		boardDAO.insertBaord(boardDto);
	}
	
	public void deleteBoard(BoardDto boardDto) {
		boardDAO.deleteBoard(boardDto);
	}

}
