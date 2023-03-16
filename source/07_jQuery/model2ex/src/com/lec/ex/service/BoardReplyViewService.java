package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = new BoardDao();
		request.setAttribute("replyBoard", bDao.modifyViewBoard_replyViewBoard(fid));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}
}
