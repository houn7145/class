<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>게시판</caption>
		<tr><th><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></th></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null) pageNum = "1";
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
		%>
	</table>
</body>
</html>