<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#logoutForm_wrap{
			height:600px; line-height: 600px; font-size: 32px;
			text-align: center;
			width:1000px;            	
			margin:0px auto; 
		}
	</style>
	<script>
		setTimeout(function() {
			location.href = '<%=conPath%>/main/main.jsp';
		}, 3000);
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<%
		if(session.getAttribute("customer") != null){
			session.invalidate();
	%>
		<div id="logoutForm_wrap">
			로그아웃 되었습니다. 잠시 후 메인 페이지로 이동합니다.
		</div>
	<%		
		}else{
	%>
		<div id="logoutForm_wrap">
			로그인 상태가 아닙니다. 잠시 후 메인 페이지로 이동합니다.
		</div>
	<%  }%>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>