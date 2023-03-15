package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dto.AdminDto;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = new AdminDao();
		int result = aDao.loginCheck(aid, apw);
		if(result == AdminDao.LOGIN_SUCCESS) {
			AdminDto admin = aDao.getAdmin(aid);
			session.setAttribute("admin", admin);
			request.setAttribute("adminLoginChk", "관리자 계정으로 들어오셨습니다");
		}else {
			request.setAttribute("adminLoginChk", "관리자 계정으로 로그인이 실패되었습니다");
		}
	}
}
