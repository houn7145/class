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
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"></jsp:useBean>
	<jsp:setProperty name="st" property="*" />
	<jsp:forward page="studentResult.jsp"/>
</body>
</html>