package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.model.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("mvcBoard")
public class BoardController {
	@Autowired
	private BoardService bservice;
	@RequestMapping(value="list", method={RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", bservice.boardList(pageNum));
		model.addAttribute("paging", new Paging(bservice.boardTotCnt(), pageNum, 10, 5));
		return "mvcBoard/list";
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "mvcBoard/write";
	}	
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("writeResult", bservice.boardWrite(board, request));
		return "forward:list.do";
	}
	
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String conent(int bid, Model model) {
		model.addAttribute("contentBoard", bservice.boardDetail(bid));
		return "mvcBoard/content";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("board", bservice.boardModifyReplyView(bid));
		return "mvcBoard/modify";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("modifyResult", bservice.boardModify(board, request));
		return "forward:content.do";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", bservice.boardDelete(bid));
		return "forward:list.do";
	}
	
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("board", bservice.boardModifyReplyView(bid));
		return "mvcBoard/reply";
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("replyResult", bservice.boardReply(board, request));
		return "forward:list.do";
	}
}
