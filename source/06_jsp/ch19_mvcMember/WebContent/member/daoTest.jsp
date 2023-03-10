<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>5. 회원정보 수정(aaa)</h1>
	<%
		String mid = "aaa";
		MemberDao dao = new MemberDao();
		MemberDto member = dao.getMember(mid);
		out.println("<p>수정전 : " + member + "</p>");
		member.setMname("박박박");
		member.setMemail("ppp@p.com");
		member.setMaddress(null);
		dao.modifyMember(member);
		out.println("<p>수정후 : " + dao.getMember(mid)+ "</p>");
	%>
	<h1>6. 회원 리스트(4~6)</h1>
	<%
		ArrayList<MemberDto> members = dao.getMemberList(4, 6);
		for(MemberDto m : members){
			out.println(m + "<br>");
		}
	%>
	<h1>7. 회원수 : <%=dao.getMemberTotCnt() %></h1>
	<h1>8. 회원탈퇴(aaa)</h1>
	<%
		int result = dao.withdrawalMember(mid);
		out.println(result == MemberDao.SUCCESS ? "탈퇴완료" : "탈퇴실패");
	%>
</body>
</html>