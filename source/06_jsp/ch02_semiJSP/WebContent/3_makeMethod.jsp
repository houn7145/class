<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // 자바 소스
		long result = power(2,3);
	%>
	<p>2의 3승은 <%=result %>입니다</p>
	<p>9의 10승은 <%=power(9,10) %>입니다</p>
	<%-- 선언부 : 변수나 메소드를 선언  --%>
	<%! // 선언부는 스크립트릿 부분 전에 해석
		private long power(int a, int b){ // a의 b승을 return
			long result = 1;
			for(int i = 1 ; i <= b ; i++){
				result *= a;//result = result * a;
			}
			return result;
		}
	%>
</body>
</html>