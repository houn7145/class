<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>어떤 요청이 들어와도 cnt, list는 model에 add됨</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list }</h3>
	<h2>result1.jsp입니다(member/join결과)</h2>
	<h3>이름 : ${name }</h3>
	<h3>아이디 : ${id }</h3>
	<h3>비밀번호 : ${pw }</h3>
	<h3>나이 : ${age }</h3>
	<h3>이메일 : ${email }</h3>
	<h3>주소 : ${address }</h3>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">다시하기</button>
</body>
</html>