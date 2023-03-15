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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  	<c:if test="${not empty member }">
  		<script>
  			alert('사용자는 들어오실 수 없습니다');
  			history.back();
  		</script>
  	</c:if>
  	<c:if test="${not empty admin }">
  		<script>
  			alert('이미 관리자 모드로 들어오셨습니다');
  			history.back();
  		</script>
  	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/adminLogin.do" method="post">
			<table>
				<caption>관리자 로그인</caption>
				<tr>
					<th>ID</th><td><input type="text" name="aid" required="required"></td> 
				</tr>
				<tr>
					<th>PW</th><td><input type="password" name="apw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>