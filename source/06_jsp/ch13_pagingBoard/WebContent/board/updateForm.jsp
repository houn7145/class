<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<%
		String num = request.getParameter("num");
		BoardDao bDao = BoardDao.getInstance();
		BoardDto dto = bDao.getBoardOneLine(num);
		// pageNum 추가
		String pageNum = request.getParameter("pageNum");
	%>
	<form action="<%=conPath %>/board/updatePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>"> <!-- pageNum 넘기기 -->
		<input type="hidden" name="num" value="<%=num %>"> <!-- num 넘기기 -->
		<table>
			<caption><%=num %>번 글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" readonly="readonly" value="<%=dto.getWriter()%>"></td>
			</tr>	
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required" value="<%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="content" required="required"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="<%=dto.getEmail() == null ? "" : dto.getEmail() %>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required" value="<%=dto.getPw()%>"></td>
			</tr>
			<tr>
				<td colspan='2'>
				<input type="submit" value="수정" class="btn">
				<input type="reset" value="취소" onclick="history.back()" class="btn">
				<input type="button" value="목록" onclick="location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum %>'" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>