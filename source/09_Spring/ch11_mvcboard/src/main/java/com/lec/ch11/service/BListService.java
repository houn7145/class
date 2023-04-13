package com.lec.ch11.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map으로 변경
		// model.addAttribute("pageNum", "value");
		String pageNum = (String) map.get("pageNum");
		if(pageNum == null) pageNum = "1";
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		// 출력될 boardList
		model.addAttribute("boardList", bDao.list(startRow, endRow));
		// 출력될 순차번호, 역 순차번호
		int orderNum = startRow; // 순차번호
		int totCnt = bDao.getBoardTotCnt(); // 전체 글 갯수
		int inverseNum = totCnt - startRow + 1; // 역 순차번호
		int pageCnt = (int)Math.ceil((double)totCnt / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		startPage = currentPage - (currentPage - 1) % BLOCKSIZE;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) endPage = pageCnt;
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("pageNum", currentPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
	}
}
