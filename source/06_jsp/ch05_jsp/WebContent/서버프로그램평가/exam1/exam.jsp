<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			text-align: center;
		}
		h2{
			color:red;
		}
		.button{
			width:80px;
			height:30px;
			margin: 10px 5px;
			background-color: lightblue;
			border-color: navy;
		}
	</style>
</head>
<body>
	<form action="examPro.jsp" method="get">
		<button class="button" name="su" value="1">1번</button>
		<button class="button" name="su" value="2">2번</button>
		<button class="button" name="su" value="3">3번</button>
	</form>
	<div id="msg">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.println(msg);
			}
		%>
	</div>
</body>
</html>