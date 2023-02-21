<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="fri_wrap">
		<form action="<%=conPath%>/exam_friend/friendInputListPro.jsp">
			<p>
				친구이름 <input type="text" name="name" required="required" size="10">
				전화 <input type="text" name="tel" size="10">
				<input type="submit" value="추가">
			</p>
		</form>
		<table>
			<caption>DB에 입력된 친구들 리스트</caption>
			<tr><td>순번</td><td>이름</td><td>전화</td></tr>
			<%
				FriendDao fDao = FriendDao.getInstance();
				ArrayList<FriendDto> friendList = fDao.friendList();
				for(FriendDto Friend : friendList){
					int no = Friend.getNo();
					String name = Friend.getName();
					String tel = Friend.getTel();
					out.println("<tr><td>" + no + "</td>");
					out.println("	 <td>" + name + "</td>");
					out.println("	 <td>" + (tel == null ? "-" : tel) + "</td></tr>");
				}
			%>
		</table>
	</div>
</body>
</html>