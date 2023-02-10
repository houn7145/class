<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석(소스보기에서 안보임) --%>
<% // 스크립트릿 안에 자바 소스
	int j = 0; // 초기화하지 않으면 쓰레기 데이터가 들어가 있기에 사용불가
	StringBuffer strBuf1 = new StringBuffer("몰라요");
	i++; j++;
	strBuf.append("<span> ♥ </span>");
	strBuf1.append("<span> ＠ </span>");
	out.print("전역변수 i : " + i + "<br>");
	out.print("strBuf = " + strBuf + "<br>");
	out.print("지역변수 j : " + j + "<br>");
	out.print("strBuf1 = " + strBuf1 + "<br>");
	out.print("sum(3,4) = " + sum(3,4));
%>
	<%-- 지역변수 : <%=j %><br>
 	전역변수 : <%=i %><br> --%>
 
<%! // 선언부 (전역변수, 메소드) - 브라우저를 닫아도 값은 초기화 되지 않음(코드를 바꾸면 초기화됨)
	int i; // 초기화하지 않아도 수는 0으로 자동 초기화, 객체는 null
	StringBuffer strBuf = new StringBuffer("Good");
	private int sum(int a, int b){
		return a+b;		
	};
%>

</body>
</html>