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
	void testGuestBookController() {
		fail("Not yet implemented");
	}

	@Test
	void testGuestBook() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertBoard() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBoard() {
		BoardDto boardDto = new BoardDto();
		boardDto.setId(1);
		boardService.deleteBoard(boardDto);
		Assert.assertEquals(boardService.getBoardWithID(boardDto.getId()).getDeleted(), 1, 0);
	}

	@Test
	void testGetUpdateBoard() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBoard() {
		String changed = "변경된 방명록";
		String testPassword = "1234";
		int id = 1;
		//비밀번호 맞은 경우 테스트
		BoardDto boardDto = new BoardDto();
		String password = boardService.getBoardWithID(1).getPassword();
		boardDto.setPassword(password);
		boardDto.setId(id);
		boardDto.setContent(changed);
		BoardDto updatedBoardDto = boardService.updateBoard(boardDto);
		Assert.assertEquals(updatedBoardDto.getContent(), changed);
		
		// 비밀번호 틀린 경우 테스트
		boardDto = new BoardDto();
		boardDto.setPassword(testPassword);
		boardDto.setId(id);
		boardDto.setContent(changed);
		updatedBoardDto = boardService.updateBoard(boardDto);
		Assert.assertEquals(updatedBoardDto, null);
		
	}

}
