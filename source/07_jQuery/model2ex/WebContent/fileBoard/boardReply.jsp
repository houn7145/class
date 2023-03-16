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
  	<c:if test="${empty member }"> 
		<script>
			location.href='${conPath}/loginView.do?next=boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }';
		</script>
	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/boardReply.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="mid" value="${member.mid }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="fgroup" value="${replyBoard.fgroup }">
			<input type="hidden" name="fstep" value="${replyBoard.fstep }">
			<input type="hidden" name="findent" value="${replyBoard.findent }">
			<table>
				<caption>${replyBoard.fid }번글 답글쓰기</caption>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="mname" required="required" value="${member.mname }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="ftitle" required="required" value="[답]${replyBoard.ftitle }"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" cols="20" name="fcontent"></textarea></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" name="ffileName"></td> 
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="답글쓰기" class="btn">
						<input type="reset" value="다시쓰기" class="btn">
						<input type="button" value="뒤로가기" class="btn" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>