<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet">
</head>
<body>
	<%	request.setCharacterEncoding("utf-8");
		String msg = "";
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		String method= request.getParameter("method");
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			CustomerDto customer = cDao.getCustomer(cid);
			session.setAttribute("customer", customer);
			if(method.equals("null")){
				response.sendRedirect(conPath + "/customer/main.jsp");
			}else{
				response.sendRedirect(conPath + "/customer/" + method + ".jsp");
			}
		}else if(result == CustomerDao.LOGIN_FAIL){
	%>
			<script>
				alert("올바르지 않은 아이디와 비밀번호입니다. 확인하세요.");	
			</script>
	<%
			response.sendRedirect(conPath + "/customer/login.jsp?msg=xx");
		}
	%>
	<%-- <jsp:include page="../member/header.jsp"/>
	<br><br><br><br><br><br>
	<div id="loginForm_wrap">
		<div id="login_title">로그인 결과</div>
		<div id="login_join">로그인 성공</div>
	</div>
	<br><br><br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>