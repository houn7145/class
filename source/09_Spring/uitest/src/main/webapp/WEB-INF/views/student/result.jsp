<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<span>"현재 총 ${cnt }명"</span>
	<table>
		<caption>결과는 다음과 같습니다</caption>
		<tr><th>이 름 : </th><td><p>${student.name }</p></td>
		<tr><th>국 어 : </th><td><p>${student.kor }</p></td>
		<tr><th>영 어 : </th><td><p>${student.eng }</p></td>
		<tr><th>수 학 : </th><td><p>${student.mat }</p></td>
		<tr><th>총 점: </th><td><p>${sum }</p></td>
		<tr><th>평 균 : </th><td><p><fmt:formatNumber value="${avg}" pattern="00.##"/></p></td>
		<tr><td colspan="2"><input type="button" value="뒤로가기" onclick="history.back()"><input type="button" value="다시입력" onclick="location.href='${conPath}/input.do'"></td></tr>
	</table>
</body>
</html>