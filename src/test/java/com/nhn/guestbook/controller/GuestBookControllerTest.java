package com.nhn.guestbook.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhn.guestbook.dto.BoardDto;
import com.nhn.guestbook.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class GuestBookControllerTest {
	@Autowired
	BoardService boardService;

	@Test
	void testInsertBoard() {
		String testEmail ="test@test.com";
		String testPassword = "1234";
		String testContent = "This is a test case";
		BoardDto boardDto = new BoardDto();
		boardDto.setEmail(testEmail);
		boardDto.setPassword(testPassword);
		boardDto.setContent(testContent);
		
		int id = boardService.insertBoard(boardDto);
		
		boardDto = boardService.getBoardWithID(id);
		Assert.assertEquals(testEmail, boardDto.getEmail());
		Assert.assertEquals(testPassword, boardDto.getPassword());
		Assert.assertEquals(testContent, boardDto.getContent());
		
		
		//email validation test case
		
		testEmail = "test";
		boardDto = new BoardDto();
		boardDto.setEmail(testEmail);
		boardDto.setPassword(testPassword);
		boardDto.setContent(testContent);
		id = boardService.insertBoard(boardDto);
		Assert.assertEquals(id, -1);
		
	}

	@Test
	void testUpdateBoard() {
		String changed = "changed board";
		String testPassword = "1234";
		int id = 1;
		//if password is correct
		BoardDto boardDto = new BoardDto();
		String password = boardService.getBoardWithID(1).getPassword();
		boardDto.setPassword(password);
		boardDto.setId(id);
		boardDto.setContent(changed);
		BoardDto updatedBoardDto = boardService.updateBoard(boardDto);
		Assert.assertEquals(updatedBoardDto.getContent(), changed);
		
		testPassword = "qwer";
		// if password is incorrect
		boardDto = new BoardDto();
		boardDto.setPassword(testPassword);
		boardDto.setId(id);
		boardDto.setContent(changed);
		updatedBoardDto = boardService.updateBoard(boardDto);
		Assert.assertEquals(updatedBoardDto, null);
		
	}
	
	@Test
	void testDeleteBoard() {
		BoardDto boardDto = new BoardDto();
		boardDto.setId(1);
		boardService.deleteBoard(boardDto);
		Assert.assertEquals(boardService.getBoardWithID(boardDto.getId()).getDeleted(), 1, 0);
	}

}
