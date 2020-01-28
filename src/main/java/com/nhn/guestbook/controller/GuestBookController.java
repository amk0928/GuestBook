package com.nhn.guestbook.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(value="/", method=RequestMethod.POST, consumes= {"multipart/form-data"})
	public String insertBoard(
			ModelMap modelMap,
			@RequestPart("board") @Valid BoardDto boardDto,
			@RequestPart("files") @Valid MultipartFile[] files, 
			HttpServletResponse httpServletResponse
			) {
		if(boardService.insertBoard(boardDto) == -1)
			httpServletResponse.setStatus(401);
		System.out.println(files.length);
		for(int i=0; i < files.length; i++) {
			System.out.println(files[i].getOriginalFilename());
		}
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
	
	
	@RequestMapping(value="/update/{boardId}", method=RequestMethod.GET)
	public String getUpdateBoard(ModelMap modelMap, @PathVariable int boardId) {
		modelMap.addAttribute("boards", boardService.getBoardWithID(boardId));
		return "update";
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public BoardDto updateBoard(ModelMap modelMap, @RequestBody BoardDto boardDto, HttpServletResponse httpServletResponse) {
		if(boardService.updateBoard(boardDto) == null) {
			httpServletResponse.setStatus(401);
			return null;
		} else {
			return boardDto;
		}
	}
}
