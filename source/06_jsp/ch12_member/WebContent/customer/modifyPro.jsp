<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(! tempBirth.equals("")){
			dto.setCbirth(Date.valueOf(tempBirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer != null){
			sessionPw = customer.getCpw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			if(dto.getCpw() == null){
				dto.setCpw(oldPw);
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("customer", dto);
		%>
				<script>
					alert('정보수정이 완료되었습니다.');
					location.href = 'main.jsp'
				</script>
		<% 	}else{
		%>
				<script>
					alert('정보수정을 실패하였습니다. 길이 제한이 있습니다');
					location.href = 'modify.jsp';
				</script>
	 	 <%} %>
	<%}else {
			 
		 %>
		 	<script>
				alert('현 비밀번호가 올바르지 않습니다. 확인하세요.');
				history.back();
			</script>
		 
	<%}%>
</body>
</html>