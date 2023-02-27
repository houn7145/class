<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
	if (session.getAttribute("customer") != null) {
	response.sendRedirect(conPath + "/main/main.jsp");
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/join.css" rel="stylesheet">
<script>
	window.onload = function() {
		document.querySelector('form').onsubmit = function() {
			var cpw = document.getElementById('cpw');
			var cpwChk = document.getElementById('cpwChk');
			var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/; // macth함수 사용
			var cemail = document.getElementById('cemail');
			if (cpw.value != cpwChk.value) {
				alert('비밀번호를 확인하세요');
				cpw.value = '';
				cpwChk.value = '';
				cpw.focus();
				return false;
			} else if (cemail.value && !cemail.value.match(patternMail)) {
				alert('메일 형식을 확인하세요');
				cemail.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>
		<form action="joinPro.jsp" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="cid" id="cid" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="cpw" id="cpw"
						required="required"></td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td><input type="password" name="cpwChk" id="cpwChk"
						required="required"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="cname" id="cname"
						required="required"></td>
				</tr>
				<tr>
					<th>전화</th>
					<td><input type="text" name="ctel" id="ctel"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="cemail" id="cemail"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="caddress" id="caddress"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="tempBirth" id="cbirth"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="cgender" value="m"
						checked="checked">남자 <input type="radio" name="cgender"
						value="f">여자</td>
				</tr>
				<tr></tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입하기"
						class="joinBtn_style"> <input type="reset" value="다시하기"
						class="joinBtn_style"> <input type="button" value="로그인"
						onclick="location.href='<%=conPath%>/customer/loginForm.jsp'"
						class="joinBtn_style"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>