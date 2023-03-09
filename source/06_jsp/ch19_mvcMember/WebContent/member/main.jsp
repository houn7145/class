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
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${logoutResult eq SUCCESS }">
		<script>
			alert('로그아웃 성공');
		</script>
	</c:if>
	<c:if test="${logoutResult eq FAIL }">
		<script>
			alert('로그아웃 실패');
		</script>
	</c:if>
	<c:if test="${loginResult eq SUCCESS }">
		<script>
			alert('로그인 성공');
		</script>
	</c:if>
	<c:if test="${loginResult eq FAIL }">
		<script>
			alert('아이디와 비밀번호를 확인하세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty member }">
		<p>${member.mname }(${member.mid })님 어서오세요</p>
		<p>------------------------------------</p>
		<p><button onclick="location.href='${conPath}/logout.do'">로그아웃</button></p>
	</c:if>
	<c:if test="${empty member }">
		<p>로그인 상태가 아닙니다</p>
		<p>------------------------------------</p>
		<p>
			<button onclick="location.href='${conPath}/loginView.do'">로그인</button>
			<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
		</p>
	</c:if>
</body>
</html>