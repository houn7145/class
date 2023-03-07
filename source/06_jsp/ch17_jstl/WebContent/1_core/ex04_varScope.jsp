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
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<c:set var="code" value="80012" scope="request"/>
	<c:set var="price" value="10000" scope="request"/>
	<c:set var="name" value="온도계" scope="request"/>
	<h2>물품정보(ex04_varScope.jsp)</h2>
	<h4>code : ${code }</h4>
	<h4>price : ${price }</h4>
	<h4>name : ${name }</h4>
	<jsp:forward page="ex05_varScope.jsp"/>
	<%-- <c:redirect url="ex05_varScope.jsp"/> --%> <!-- redirect를 하면 scope이 날라감 -->
</body>
</html>