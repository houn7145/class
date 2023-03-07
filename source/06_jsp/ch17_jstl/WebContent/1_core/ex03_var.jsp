<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>변수 선언과 출력</h2>
	<c:set var="varName" value="varValue"/> <!-- 변수 선언 -->
	varName : ${varName } <br>
	<c:set var="varName" value="varValue   <varValue>"/> <!-- 변수의 재선언 -->
	varName : ${varName } <br> <!-- 특수문자 인식 x -->
	<!-- 변수 출력시 escapeXml="true" : 특수문자 인식 o -->
	varName : <c:out value="${varName}" escapeXml="true"/> <br>
	<c:remove var="varName"/> <!-- varName 변수 삭제 -->
	varName : ${varName } <br>
	varName : ${empty varName ? "삭제됨" : "남아있음"} <br>
	varName : <c:out value="${varName }" default="없어진 변수"/> <br>  
</body>
</html>