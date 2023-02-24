<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null) pageNum = "1";
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 10, BLOCKSIZE = 10; // 페이지당 갯수 | 블록당 페이지 수
	// (현재페이지 - 1) * 페이지당 갯수+ 1
	int startRow = (currentPage - 1) * PAGESIZE + 1;
	// 시작번호 + 페이지당갯수 - 1
	int endRow = startRow + PAGESIZE - 1;
	
%>
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
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt();
			if(totalCnt == 0){
				out.println("<tr><td colspan='5'> 등록된 글이 없습니다 </td></tr>");
			}else{
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow);
				for(BoardDto dto : dtos){
					out.println("<tr><td>" + dto.getNum() + "</td>");
					out.println("	 <td>" + dto.getWriter() + "</td>");
					out.println("	 <td class='left'>" + dto.getSubject() + "</td>");
					out.println("    <td>" + dto.getEmail() + "</td>");
					out.println("    <td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>