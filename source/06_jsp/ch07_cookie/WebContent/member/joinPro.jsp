<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		//Date birthDate = Date.valueOf(birth); // Date.valueO : string을 date형으로 변환
		//Timestamp birthTimestamp = Timestamp.valueOf(birth + " 00:00:00");
		Date birthDate = null;
		Timestamp birthTimestamp = null;
		if(birth != null && !birth.equals("")){
			birthDate = Date.valueOf(birth);
			birthTimestamp = Timestamp.valueOf(birth + " 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		Date date	= new Date(System.currentTimeMillis());
	%>
	<div id='joinForm_wrap'>
	<div id='join_title'>회원가입정보</div>
	<h2>name : <%=name %></h2>
	<h2>id : <%=id %></h2>
	<h2>pw : <%=pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\{}\\[\\]:;\"'?/<>,\\.]", "*")%></h2>
	<h2>birth : <%=birth %></h2>
	<h2>birth2 : <%=birthTimestamp == null ? "" : birthTimestamp %></h2>
	<h2>hobby : <%if(hobby!=null) {
		for(int i=0 ; i<hobby.length ; i++)
			if(i==hobby.length-1)
				out.print(hobby[i]);
			else
				out.print(hobby[i]+", ");
	}else {
		out.print("없음");
	} %></h2>
	<h2>gender : <%=gender %></h2>
	<h2>email : <%=email %></h2>
	<h2>mailSend : <%if(mailSend!=null) {
		out.print(Arrays.toString(mailSend));
	}else {
		out.print("모두 수신 거부");
	} %></h2>
	<h2>가입일 : <%=date %></h2>
	<h2>가입IP : <%=request.getRemoteAddr()%></h2>
	<input type="button" value="로그인"
						class="joinBtn_style" onclick="location.href='login.jsp'">
	</div>
</body>
<jsp:include page="../member/footer.jsp"/>
<%-- <%@ include file="footer.jsp"%> --%>
</html>