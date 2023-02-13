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
	<%
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c : cs){
				String cookieName = c.getName();
				if(cookieName.equals("id")){
					// id이름의 쿠키 유효 시간을 0초로 수정 
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h1>로그아웃 성공</h1>");
				}else if(cookieName.equals("name")){
					// name이름의 쿠키 유효 시간을 0초로 수정
					c.setMaxAge(0);
					response.addCookie(c);
				}// if
			}// for
		}// if
	%>	
	<p>
		<button onclick ="location.href='login.html'">로그인</button>
		<button onclick ="location.href='cookieList.jsp'">쿠키 확인</button>
		<button onclick ="location.href='welcome.jsp'">메인 페이지</button>
	</p>
</body>
</html>