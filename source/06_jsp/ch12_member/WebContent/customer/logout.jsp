<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#logout_wrap{
			height: 600px; 
			line-height: 600px;
			font-size: 15px;
			text-align: center;
			width: 400px;
			margin: 0 auto;
			color:#A47160;
		}	
	</style>
	<script>
		setTimeout(function() {
			location.href = 'main.jsp';
		}, 3000);
	</script>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<%
		if(session.getAttribute("customer") != null){
			session.invalidate();
	%>
		<div id="logout_wrap">
			로그아웃 되었습니다. 잠시후 페이지 이동이 있겠습니다.
		</div>
	<%		
		}else{
	%>
		<div id="logout_wrap">
			로그인 상태가 아닙니다. 잠시 후 메인 페이지로 이동합니다.
		</div>
	  <%} %>
		
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>