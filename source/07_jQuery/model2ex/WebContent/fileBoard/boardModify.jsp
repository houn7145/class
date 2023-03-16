<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  	<script>
		$(function(){
			
		});
  	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/boardModify.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="fid" value="${modifyBoard.fid }">
			<input type="hidden" name="mid" value="${member.mid }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="dbFfileName" value="${modifyBoard.ffileName }">
			<table>
				<caption>글 수정하기</caption>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="mname" required="required" value="${modifyBoard.mname }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="ftitle" required="required" value="${modifyBoard.ftitle }"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" cols="20" name="fcontent" value="${modifyBoard.fcontent }"></textarea></td>
				</tr>
				<tr><th>첨부파일</th>
					<td><input type="file" name="ffileName" class="btn"> 기존 첨부파일:
							<c:if test="${not empty board.ffileName }">
						 		<a href="${conPath }/fileBoardUp/${board.ffileName}" target="_blank">${board.ffileName}</a>
						 	</c:if>
						 	<c:if test="${empty board.ffileName }">
						 		첨부파일없음
						 	</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>