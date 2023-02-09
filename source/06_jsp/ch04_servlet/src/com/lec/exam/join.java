package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("bitrh");
		String hobby = request.getParameter("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mailSend = request.getParameter("mailSend");
		out.println("<html>");
		out.println("<link href=\"css/join.css\" rel=\"stylesheet\">");
		out.println("<div id=\"joinForm_wrap\">");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<table>");
		out.println("</table>");
		out.println("<body>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
