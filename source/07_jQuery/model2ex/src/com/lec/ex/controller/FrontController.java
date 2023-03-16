package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.ALoginService;
import com.lec.ex.service.BoardContentService;
import com.lec.ex.service.BoardDeleteService;
import com.lec.ex.service.BoardListService;
import com.lec.ex.service.BoardModifyService;
import com.lec.ex.service.BoardModifyViewService;
import com.lec.ex.service.BoardReplyService;
import com.lec.ex.service.BoardReplyViewService;
import com.lec.ex.service.BoardWriteService;
import com.lec.ex.service.JoinService;
import com.lec.ex.service.MAllViewService;
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
	private int overlap = 0; // 새로고침시 중복 방지
	
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
			overlap = 1;
			
		}else if(command.equals("/midConfirm.do")) { // id 중복체크
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
			
		}else if(command.equals("/memailConfirm.do")){ // email 중복체크
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp";
			
		}else if(command.equals("/join.do")) { // 회원가입 후 로그인view로
			if(overlap == 1) {
				service = new JoinService();
				service.execute(request, response);
				overlap = 0;
			}
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
			overlap = 1;
			
		}else if(command.equals("/modify.do")) { // 정보수정 완료 후 메인페이지로
			if(overlap == 1) {
				service = new MModifyService();
				service.execute(request, response);
				overlap = 0;
			}
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
			
		}else if(command.equals("/adminLogin.do")) { // 관리자 로그인시 전체회원view로
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
			
		}else if(command.equals("/allView.do")) { // 전체회원 보여주는 jsp
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
			
		/************************************************
		 ***************** fileboard 관련 요청 ************
		 ************************************************/
		}else if(command.equals("/boardWriteView.do")) { // 글작성
			viewPage = "fileBoard/boardWrite.jsp";
			overlap = 1;
			
		}else if(command.equals("/boardWrite.do")) { // 글 작성후 리스트 페이지로
			if(overlap == 1) {
				service = new BoardWriteService();
				service.execute(request, response);
				overlap = 0;
			}
			viewPage = "boardList.do";
		}else if(command.equals("/boardList.do")) { // 글 리스트 페이지
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "fileBoard/boardList.jsp";
			
		}else if(command.equals("/boardContent.do")) { // 글 상세보기
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "fileBoard/boardContent.jsp";
			
		}else if(command.equals("/boardModifyView.do")) { // 글 수정
			service = new BoardModifyViewService();
			service.execute(request, response);
			overlap = 1;
			viewPage = "fileBoard/boardModify.jsp";
			
		}else if(command.equals("/boardModify.do")) { // 글 수정 후 글 목록 리스트로
			if(overlap == 1) {
				service = new BoardModifyService();
				service.execute(request, response);
				overlap = 0;
			}
			viewPage = "boardList.do";
			
		}else if(command.equals("/boardDelete.do")) { // 글 삭제 후 글 목록 리스트로
			service = new BoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
			
		}else if(command.equals("/boardReplyView.do")) { // 답변글 달기 요청시 답변글 작성 페이지로
			service = new BoardReplyViewService();
			service.execute(request, response);
			overlap = 1;
			viewPage = "fileBoard/boardReply.jsp";
			
		}else if(command.equals("/boardReply.do")) { // 답변 글 작성 후 글 목록 리스트로
			if(overlap == 1) {
				service = new BoardReplyService();
				service.execute(request, response);
				overlap = 0;
			}
			viewPage = "boardList.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
