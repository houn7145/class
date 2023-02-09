package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String color1 = request.getParameter("color1");
		String col1 = "";
		String[] fontColor = {"red", "orange", "yellow", "green", "blue", "navy", "purple"};
		out.println("<html>");
		for(int i = 0 ; i <= fontColor.length ; i++) {
			col1 = fontColor[i];
		}
		out.println("<body style='background-color:" + color1 + ";"
				+ "color:" + col1 +"';>");
		out.println("<h2>GET방식 요청입니다</h2>");
		out.println("<h2>글자색은 " + col1 + " 배경색은 " + color1 + "입니다</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String color2 = request.getParameter("color2");
		String col2 = "";
		String[] fontColor = {"red", "orange", "yellow", "green", "blue", "navy", "purple"};
		out.println("<html>");
		for(int i = 0 ; i < 1 ; i++) {
			col2 += fontColor[i];
		}
		out.println("<body style='background-color:" + color2 + ";"
				+ "color:" + col2 +"';>");
		out.println("<h2>POST방식 요청입니다</h2>");
		out.println("<h2>글자색은 " + col2 + " 배경색은 " + color2 + "입니다</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
