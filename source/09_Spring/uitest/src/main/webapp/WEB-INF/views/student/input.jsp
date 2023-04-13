<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script type="text/javascript">
	  var f = document.getElementById("joinform");
	  f.addEventListener("submit" , function(e) {
	    if(f.name.value.length < 2 ) {
	      alert("이름은 한글자 이상 입력하세요");
	      e.preventDefault();
	      f.name.focus();
	      return;
	    }
	  });
    </script>
</head>
<body>
	<span>"현재 총 ${cnt }명"</span>
	<form action="${conPath }/input.do" method="post" id="joinform">
		<table>
			<caption>개인 정보 입력</caption>
			<tr><th>이 름 : </th><td><input type="text" name="name" id="name" placeholder="홍길동" size="10"></td>
			<tr><th>국 어 : </th><td><input type="number" name="kor" placeholder="100" min="0" max="100" size="10"></td>
			<tr><th>영 어 : </th><td><input type="number" name="eng" placeholder="100" min="0" max="100" size="10"></td>
			<tr><th>수 학 : </th><td><input type="number" name="mat" placeholder="99" min="0" max="100" size="10"></td>
			<tr><th colspan="2"><input type="submit"></th></tr>
		</table>
	</form>
</body>
</html>