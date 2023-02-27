<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%!
		String id, name, tel, address, email, gender;
		Date birth;
	%>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer == null){
			response.sendRedirect(conPath + "/customer/loginForm.jsp?method=modifyForm");
		}else{
			id = customer.getCid();
			name = customer.getCname();
			tel = customer.getCtel();
			address = customer.getCaddress();
			email = customer.getCemail();
			gender = customer.getCgender();
			birth = customer.getCbirth();
		}
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">정보수정</div>
		<form action="<%=conPath %>/customer/modifyPro.jsp" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="cid" id="cid" value="<%=id %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>현비밀번호</th>
					<td><input type="password" name="oldPw" id="cpw" required="required"></td>
				</tr>
				<tr>
					<th>새비밀번호확인</th>
					<td><input type="password" name="cpw" id="cpw"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="cname" id="cname" value="<%=name %>"></td>
				</tr>
				<tr>
					<th>전화</th>
					<td><input type="text" name="ctel" id="ctel" value="<%=tel == null ? "" : tel%>"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="cemail" id="cemail" value="<%=email == null ? "" : email %>"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="caddress" id="caddress" value="<%=address == null ? "" : address%>"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="tempBirth" id="cbirth" value="<%=birth %>"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<%if("m".equals(gender)){ %>
							<input type="radio" name="cgender" id="cgender" value="m" checked="checked">남
							<input type="radio" name="cgender" id="cgender" value="f">여
						<%}else if("f".equals(gender)) {%>
							<input type="radio" name="cgender" id="cgender" value="m">남
							<input type="radio" name="cgender" id="cgender" value="f" checked="checked">여
						<%}else{ %>
							<input type="radio" name="cgender" id="cgender" value="m">남
							<input type="radio" name="cgender" id="cgender" value="f">여
						<%} %>
					</td>
				</tr>
				<tr><th></th></tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="이전으로" onclick="history.back()" class="joinBtn_style">
					</td>
				</tr>
		</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>