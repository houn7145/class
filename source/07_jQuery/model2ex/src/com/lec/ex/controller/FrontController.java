package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.ALoginService;
import com.lec.ex.service.JoinService;
import com.lec.ex.service.MLoginService;
import com.lec.ex.service.MLogoutService;
import com.lec.ex.service.MModifyService;
import com.lec.ex.service.MWithdrawalService;
import com.lec.ex.service.MemailConfirmService;
import com.lec.ex.service.MidConfirmService;
import com.lec.ex.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		
		if(command.equals("/main.do")) { // 첫 화면
			viewPage = "main/main.jsp";
		/************************************************
		 **************** member 관련 요청 *****************
		 ************************************************/
		}else if(command.equals("/joinView.do")) { // 회원가입view
			viewPage = "member/join.jsp";
			
		}else if(command.equals("/midConfirm.do")) { // id 중복체크
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
			
		}else if(command.equals("/memailConfirm.do")){ // email 중복체크
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp";
			
		}else if(command.equals("/join.do")) { // 회원가입 후 로그인view로
			service = new JoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
			
		}else if(command.equals("/loginView.do")) { // 로그인 view
			viewPage = "member/login.jsp";
			
		}else if(command.equals("/login.do")) { // 로그인 후 메인페이지로
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if(command.equals("/logout.do")) { // 로그아웃 후 메인페이지로
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if(command.equals("/modifyView.do")) { // 정보수정view로
			viewPage = "member/modify.jsp";
			
		}else if(command.equals("/modify.do")) { // 정보수정 완료 후 메인페이지로
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if(command.equals("/withdrawal.do")) { // 회원탈퇴 완료 후 메인페이지로
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		/************************************************
		 ***************** admin 관련 요청*****************
		 ************************************************/
		}else if(command.equals("/adminLoginView.do")) { // 관리자모드 클릭시 관리자모드 로그인view로
			viewPage = "admin/adminLogin.jsp";
			
		}else if(command.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		/************************************************
		 ***************** fileboard 관련 요청 ************
		 ************************************************/
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
