<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>	

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#logout_wrap{
			height: 600px; 
			line-height: 600px;
			font-size: 16px;
			text-align: center;
			width: 400px;
			margin: 0 auto;
			color:#A47160;
		}	
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>

		<div id="logout_wrap">
			로그아웃 되었습니다 잠시후 페이지 이동이 있겠습니다
		</div>
		<script>
			window.onload = function(){
				  setTimeout('location.href="../member/main.jsp"',3000)
			}
		</script>
	
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>