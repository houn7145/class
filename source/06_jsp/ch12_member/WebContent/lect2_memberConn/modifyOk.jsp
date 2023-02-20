<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- modify.jsp에서 전달받은 파라미터 : 
		id, pw(바꾸고 싶은 비번), name, phone1, phone2, phone3, gender, email, address (MemberDto)
		tempBirth, oldPw(현 비번) (dto에 없는 파라미터변수)
	-->
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(! tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			//dto.setBirth(Timestamp.valueOf(tempBirth + " 00:00:00"));
		}
		MemberDto member = (MemberDto)session.getAttribute("member"); // 세션의 pw가 필요
		String sessionPw = null;
		if(member != null){
			sessionPw = member.getPw(); // 세션의 member의 pw
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			// 현 비밀번호를 맞게 입력한 경우 정보수정 진행
			if(dto.getPw() == null){
				// 새 비밀번호를 현 비밀번호로
				dto.setPw(oldPw);
			}
			MemberDaoConn mDao = new MemberDaoConn();
			int result = mDao.modifyMember(dto);
			if(result == MemberDaoConn.SUCCESS){
				// 정보 수정성공
				session.setAttribute("member", dto); // 수정된 정보를 세션 속성으로 수정
	%>			
				<script>
					alert('정보수정이 완료되었습니다.');
					location.href = 'main.jsp'
				</script>
	<%		}else {
				// 정보 수정실패
	%>			
				<script>
					alert('정보수정을 실패하였습니다. 길이 제한이 있습니다');
					location.href = 'modify.jsp';
				</script>
		  <%} %>
	<%	}else{
			// 현 비밀번호를 틀리게 입력한 경우 modify.jsp 페이지로
	%>		
			<script>
				alert('현 비밀번호가 올바르지 않습니다. 확인하세요.');
				history.back();
			</script>
	  <%} %>
</body>
</html>