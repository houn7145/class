package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� �̸��� �Ķ���͸� ���� �޾��� ��(menu, rest)
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(menu!=null){
			out.println("<h2>������ �޴���" + Arrays.toString(menu) + "</h2>");
		}else {
			out.println("<h2>������ �޴��� �����ϴ�</h2>");
		}
		if(rest!=null){
			out.println("<h2>������ �Ĵ���" + Arrays.toString(rest) + "</h2>");
		}else {
			out.println("<h2>������ �Ĵ��� �����ϴ�</h2>");
		}
		out.println("<h2>������ ������ " + nation + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
