package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String[] su = request.getParameterValues("su");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(su == null) {
			out.println("선택한 구구단이 없습니다");
		}else {
			for(int i = 0; i < su.length ; i++) {
				out.println(su[i] + "단" + "<br>");
				for(int j = 1; j < 10 ; j++) {
					out.println(su[i] + " * " + j + " = " + (Integer.parseInt(su[i]) * j) + "<br>");
				}
			}
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
