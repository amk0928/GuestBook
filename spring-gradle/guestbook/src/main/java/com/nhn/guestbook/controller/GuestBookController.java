package com.nhn.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
