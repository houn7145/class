<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String agree = request.getParameter("agree");
		if("y".equals(agree)){
			// 약관에 동의한 경우 : 세션 속성 값(id, pw, name)을 받아 파일에 저장 후 세션 삭제(pw, name) -> 다음 페이지로 이동
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			// 파일에 저장 (소스폴더의 webContent/WEB-INF/id.txt)
			String filePath = "C:/houn/source/06_jsp/ch08_session/WebContent/WEB-INF/" + id + ".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.write("오늘은 DB에 insert하는 대신 파일 출력\n");
			writer.println("아이디 : " + id); 
			writer.println("비밀번호 : " + pw); 
			writer.println("이 름 : " + name); 
			writer.close();
			session.removeAttribute("pw");
			session.removeAttribute("name");
			// 세션의 id 속성은 유지(로그인 페이지에서 사용)
			response.sendRedirect("result.jsp?msg=success");
		}else{
			// 약관에 동의하지 않은 경우 : 모든 세션 속성 삭제 -> 다음 페이지로 이동
			session.invalidate();
			response.sendRedirect("result.jsp?msg=fail");
		}
	
	%>
</body>
</html>