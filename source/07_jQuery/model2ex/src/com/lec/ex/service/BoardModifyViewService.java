package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = new BoardDao();
		request.setAttribute("modifyBoard", bDao.modifyViewBoard_replyViewBoard(fid));
	}
}
