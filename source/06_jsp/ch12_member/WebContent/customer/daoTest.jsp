<%@page import="java.sql.Date"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<h1>테스트 페이지</h1>
	<%
		CustomerDao dao = CustomerDao.getInstance() ;
		String id= "zz";
		int result = dao.confirmId("zzz");
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			// 1. 회원가입 id 중복체크
			out.println("<h3>1. confirmId결과 : " + id + "는 있는 아이디입니다. 회원가입 불가합니다</h3>");
		}else{
			out.println("<h3>1. confirmId결과 :" + id + "는 없는 아이디입니다. 회원가입 가능합니다</h3>");
			CustomerDto dto = new CustomerDto(id, "111", "김길동", "010-9999-9999",
					"k@k.com", "서울","f", new Date(System.currentTimeMillis() ), null);
			result = dao.joinCustomer(dto);
			// 2. 회원가입
			if(result == MemberDaoConn.SUCCESS){
				out.println("<h3>2. join 결과 : 회원가입 성공");
			}else{
				out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto);
			}
		}
		out.println("<h3>3. login 결과 :");
		result = dao.loginCheck("aaa", "111");
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.println(": aaa - 111 로그인 성공</h3>");
		}else if(result == CustomerDao.LOGIN_FAIL){
			out.println(": aaa - 111 : 오류로 로그인 실패</h3>");
		}
		// 4. id로 dto가져오기
		out.println("<h3>4. id로 dto가져오기</h3>");
		CustomerDto dto = dao.getCustomer("aaa");
		out.println("aaa 아이디인 member : " + dto + "<br>");
		dto = dao.getCustomer("ttt");
		out.println("ttt 아이디인 member : " + dto + "<br>");
		
		out.println("<h3>5. 정보 수정 </h3>");
		CustomerDto dto2 = new CustomerDto("aaa", "1111","홍길동","010-111-111","h@h.com","서울","f",null ,null);
		result = dao.modifyCustomer(dto2);
		if(result == CustomerDao.SUCCESS){
			out.println("수정완료<br>");
			out.println("db의 수정된 데이터 : " + dao.getCustomer(dto2.getCid()) + "<br>");
		}else {
			out.println(dto2.getCid() + " 아이디가 없어서 수정실패" + "<br>");
		}
	%>
</body>
</html>