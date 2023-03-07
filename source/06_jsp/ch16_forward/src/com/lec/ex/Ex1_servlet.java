package com.lec.ex;

import java.io.IOException;
import java.net.URLEncoder;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex1_servlet")
public class Ex1_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		Member member =  new Member(id, pw, name);
		// dao 생성해서 dao의 메소드 호출, 결과에 따라서 ~.jsp로 보냄
		// request.setAttribute("member", member);
		// View 단으로
		// RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatchar/ex1_view.jsp");
		// dispatcher.forward(request, response);
		response.sendRedirect("2_redirect/ex1_view.jsp?id=" + id + "&pw=" + pw 
					+ "&name=" + URLEncoder.encode(name, "utf-8"));
	}
	
}
