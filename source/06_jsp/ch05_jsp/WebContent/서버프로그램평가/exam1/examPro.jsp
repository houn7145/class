<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			text-align: center;
		}
		h2:first-child{
			color:red;
		}
		.button{
			width:80px;
			height:30px;
			background-color: lightblue;
			margin: 10px 5px;
			border-color: navy;
		}
	</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int su = Integer.parseInt(request.getParameter("su"));
		Random random = new Random(); 
		int ran = random.nextInt(3)+1;
		if(su!=(ran)){
			String msg = "<h2>Wrong! Try Again!<br>("+su+"은(는) 아니고 정답은 "+ ran +")</h2>";
			msg = URLEncoder.encode(msg,"utf-8");
			response.sendRedirect("exam.jsp?msg=" + msg);
		}
	%>
	<h2>정답입니다<br></h2>
	<h2>동전이 있던 곳은 <%=ran %></h2>
	<button class="button" onclick = "location.href='exam.jsp'">다시 도전</button>
</body>
</html>