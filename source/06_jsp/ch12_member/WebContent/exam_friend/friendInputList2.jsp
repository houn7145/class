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
	<script>
		const search = function () {
			var name = frm.name.value;
			var tel = frm.tel.value;
			location.href = 'friendInputList2.jsp?name=' + name + '&tel=' + tel;
			// friendInputList2.jsp?name=홍&tel=9999
		};
	</script>
</head>
<body>
	<div id="fri_wrap">
		<form action="<%=conPath%>/exam_friend/friendInputListPro2.jsp" name="frm">
			<p>
				친구이름 <input type="text" name="name" required="required" size="10" value="<%
														String name = request.getParameter("name");
														if(name != null) out.print(name);
																					%>">
				전화 <input type="text" name="tel" size="10" value="<%
														String tel = request.getParameter("tel");
														if(tel != null) out.print(tel);
																					%>">
				<input type="button" value="검색" onclick = "search()">
				<input type="submit" value="추가">
			</p>
		</form>
		<table>
			<caption>DB에 입력된 친구들 리스트</caption>
			<tr><td>순번</td><td>이름</td><td>전화</td></tr>
			<%
				FriendDao fDao = FriendDao.getInstance();
				ArrayList<FriendDto> friendList = fDao.schFriend(name, tel);
				for(FriendDto Friend : friendList){
					int no = Friend.getNo();
					name = Friend.getName();
					tel = Friend.getTel();
					out.println("<tr><td>" + no + "</td>");
					out.println("	 <td>" + name + "</td>");
					out.println("	 <td>" + (tel == null ? "-" : tel) + "</td></tr>");
				}
			%>
		</table>
	</div>
</body>
</html>