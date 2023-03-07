package com.lec.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터를 받아 join 로직 실행
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth"); // 파라미터는 String으로 넘어옴
		Timestamp birth = null;
		if(! birthStr.equals("")) {
			birth = Timestamp.valueOf(birthStr + " 00:00:00");
		}
		MemberDto newMember = new MemberDto(id, pw, name, birth, null); // rdate는 null
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(newMember); // 0 아니면 1
		request.setAttribute("joinResult", result);
	}
}
