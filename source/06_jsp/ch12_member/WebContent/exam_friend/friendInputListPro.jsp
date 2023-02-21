<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		FriendDao fDao = FriendDao.getInstance();
		int result = fDao.inputFriend(dto);
		if(result == FriendDao.SUCCESS){
	%>		
			<script>
				alert('친구추가 성공');
				location.href = 'friendInputList.jsp'
			</script>
	<% }else{%>
			<script>
				alert('친구추가 실패');
				history.back();
			</script>	
	<%} %>
</body>
</html>