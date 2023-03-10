<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${confirmResult eq FAIL }">
		<script>
			alert('중복된 아이디 입니다');
			history.back();
		</script>
	</c:if>
	<c:if test="${joinResult eq SUCCESS }">
		<script>
			alert('회원가입 성공');
		</script>
	</c:if>
	<c:if test="${joinResult eq FAIL }">
		<script>
			alert('회원가입 실패');
			history.back();
		</script>
	</c:if>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/login.do" method="post">
		<table>
			<tr>
				<th>ID</th><td><input type="text" name="mid" value="${member.mid }" required="required"></td> 
			</tr>
			<tr>
				<th>PW</th><td><input type="password" name="mpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" class="btn">
					<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath}/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>