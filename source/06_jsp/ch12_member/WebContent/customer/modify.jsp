<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<%!
		String id, name, tel, address, email, gender;
		Date birth;
	%>
	
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer == null){
			response.sendRedirect(conPath + "/customer/login.jsp?method=modify");
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
	<jsp:include page="../customer/header.jsp"/> 
	<div id='joinForm_wrap'>
		<div id='join_title'>정보수정</div>	
		<form action="modifyPro.jsp" method="post">	
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="cid" id="cId" value="<%=id %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>현비밀번호</td>
				<td><input type="password" name="oldPw" id="oldPw" required="required"></td>
			</tr>
			<tr>
				<td>새비밀번호확인</td>
				<td><input type="password" name="cpw" id="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="cname" id="cName" value="<%=name %>"></td>
			</tr>
			<tr>
				<td>전화</td>
				<td><input type="text" name="ctel" id="cTel" value="<%=tel == null ? "" : tel%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="cemail" id="cEmail" value="<%=email == null ? "" : email %>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="caddress" id="cAddress" value="<%=address == null ? "" : address%>"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="tempBirth" id="cBirth" value="<%=birth %>"></td>
			</tr>
			<tr>
				<td>성별</td>
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
</body>
<jsp:include page="../customer/footer.jsp"/>
<%-- <%@ include file="footer.jsp"%> --%>
</html>