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
	
	public BoardDto getBoardWithID(int boardId) {
		return boardDAO.getBoardWithID(boardId);
	}
	
	public int insertBoard(BoardDto boardDto) {
		String emailReg = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		if(boardDto.getEmail().matches(emailReg)) {
			boardDAO.insertBaord(boardDto);
		} else {
			return -1;
		}
		return boardDto.getId();
	}
	
	public void deleteBoard(BoardDto boardDto) {
		boardDAO.deleteBoard(boardDto);
	}
	
	public BoardDto updateBoard(BoardDto boardDto) {
		if (boardDAO.getBoardWithID(boardDto.getId()).getPassword().equals(boardDto.getPassword())) {
			boardDAO.updateBoard(boardDto);
			return boardDto;
		} else {
			return null;
		}
	}

}
