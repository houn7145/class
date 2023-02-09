package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Quiz5")
public class Quiz5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<link href=\"css/Quiz5.css\" rel=\"stylesheet\">");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th colspan='2'>반갑습니다 " + name + "님</th></tr>");
		out.println("<tr>");
		out.println("<th>글제목</th>");
		out.println("<td>"+ title +"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>글내용</th>");
		out.println("<td><pre>"+ value +"</pre></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
