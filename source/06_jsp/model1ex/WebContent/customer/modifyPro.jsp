<%@page import="com.lec.dao.CustomerDao"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer == null){
			response.sendRedirect(conPath + "/customer/loginForm.jsp");
		}else{
			String tempbirth = request.getParameter("tempBirth");
			if(! tempbirth.equals("")){
				dto.setCbirth(Date.valueOf(tempbirth));
			}
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
						location.href = '<%=conPath%>/main/main.jsp';
					</script>
		<% 		}else{%>
					<script>
						alert('정보수정을 실패하였습니다. 수정할 정보가 너무 깁니다.');
						location.href = '<%=conPath%>/customer/modifyForm.jsp';
					</script>
		<%		} %>
		<%  }else { %>
			 	<script>
					alert('현 비밀번호가 올바르지 않습니다. 확인하세요.');
					history.back();
				</script>
		  <%}%>
	 <% }%>
</body>
</html>