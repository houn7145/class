package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = new BoardDao();
		int result = bDao.deleteBoard(fid);
		if(result == BoardDao.SUCCESS) {
			request.setAttribute("deleteBoardResult", "글 삭제 완료");
		}else {
			request.setAttribute("deleteBoardResult", "글 삭제 실패");
		}
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}
}
