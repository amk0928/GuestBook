package com.nhn.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhn.guestbook.dto.BoardDto;
import com.nhn.guestbook.service.BoardService;

@Controller
public class GuestBookController {
	private BoardService boardService;
	
	@Autowired
	GuestBookController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String guestBook(ModelMap modelMap) {
		modelMap.addAttribute("boards", boardService.getBoard());
		return "main";
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insertBoard(
			ModelMap modelMap,
			@RequestBody BoardDto boardDto
			) {
		boardService.insertBoard(boardDto);
		modelMap.addAttribute("boards", boardService.getBoard());
		return "main";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteBoard(
			ModelMap modelMap,
			@RequestBody BoardDto boardDto) {
		boardService.deleteBoard(boardDto);
		modelMap.addAttribute("boards", boardService.getBoard());
		return "main";
		
	}
	
}
