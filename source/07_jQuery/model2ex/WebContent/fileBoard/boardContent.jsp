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
  		
  		</script>
  	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<caption>${contentBoard.fid }번글 상세보기</caption>
		<tr>
			<th>작성자</th><td>${contentBoard.mname }(${contentBoard.mid })님</td>
		</tr>
		<tr>
			<th>제목</th><td>${contentBoard.ftitle }</td>
		</tr>
		<tr>
			<th>본문</th><td>${contentBoard.fcontent }</td>
		</tr>
		<tr>
			<th>첨부파일</th><td>${contentBoard.ffileName }</td>
		</tr>
		<tr>
			<c:if test="${empty admin && member.mid eq contentBoard.mid}">
			<td colspan="2">
				<button onclick="location.href='${conPath}/boardModifyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='${conPath}/boardDelete.do?fid=${param.fid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location.href='${conPath}/boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location.href='${conPath}/boardList.do?pageNum=${param.pageNum }'">목록</button>
			</td>
			</c:if>
			<c:if test="${empty admin && member.mid != contentBoard.mid}">
			<td colspan="2">
				<button onclick="location.href='${conPath}/boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location.href='${conPath}/boardList.do?pageNum=${param.pageNum }'">목록</button>
			</td>
			</c:if>
			<c:if test="${not empty admin}">
			<td colspan="2">
				<button onclick="location.href='${conPath}/boardDelete.do?fid=${param.fid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location.href='${conPath}/boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location.href='${conPath}/boardList.do?pageNum=${param.pageNum }'">목록</button>
			</td>
			</c:if>
		</tr>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>