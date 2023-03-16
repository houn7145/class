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
  	<style>
  		#content_form {
			height:470px;
			margin: 30px auto 0px;
		}
		#content_form table tr { height: 10px;}
  	</style>
  	<script>
		$(function() {
			$('tr').click(function() {
				var fid = $(this).children().eq(0).text();
				if(!isNaN(fid)){
					location.href = '${conPath }/boardContent.do?fid=' + fid + '&pageNum=${pageNum}';
				}
			});
		});
	</script>
  	<c:if test="${not empty modifyResult }">
  		<script>
  			alert('${modifyResult}');
  		</script>
  	</c:if>
  	<c:if test="${not empty deleteBoardResult }">
  		<script>
  			alert('${deleteBoardResult}');
  			history.pushState(null, null, location.href);

  			window.onpopstate = function(event) {
  				history.go(1);
  			};
  		</script>
  	</c:if>
  	<c:if test="${not empty boardResult }">
  		<script>
  			alert('${boardResult}');
  			history.pushState(null, null, location.href);

  			window.onpopstate = function(event) {
  				history.go(1);
  			};
  		</script>
  	</c:if>
  	<c:if test="${not empty replyResult }">
  		<script>
  			alert('${replyResult}');
  			history.pushState(null, null, location.href);

  			window.onpopstate = function(event) {
  				history.go(1);
  			};
  		</script>
  	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
		<c:if test="${empty member}">
			<tr><td><a href="${conPath }/loginView.do">글쓰기는 사용자 로그인 이후에만 가능합니다</a></td></tr>
		</c:if>
		<c:if test="${not empty member}">
			<tr><td><a href="${conPath }/boardWriteView.do">글쓰기</a></td></tr>
		</c:if>
		</table>
		<table>
			<tr>
				<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>날짜</th><th>ip</th>
			</tr>
			<c:if test="${list.size() eq 0 }">
				<tr><td colspan="6">해당 페이지의 글이 없습니다</td></tr>
			</c:if>
			<c:if test="${list.size() != 0 }">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.fid }</td>
						<td>${dto.mname }</td>
						<td class="left">
						<c:forEach var="i" begin="1" end="${dto.findent }">
							<c:if test="${i != dto.findent }">
								&nbsp; &nbsp;  
							</c:if>
							<c:if test="${i eq dto.findent }">
								└
							</c:if>
						</c:forEach>
						<c:if test="${not empty dto.ffileName }">
								${dto.ftitle } <img src="${conPath }/img/fileup.jpg" style="width:10px;">
						</c:if>
						<c:if test="${empty dto.ffileName }">
								${dto.ftitle }
						</c:if>
						<c:if test="${dto.fhit > 10 }">
							<b> * </b>
						</c:if>
						</td>
						<td>${dto.fhit }</td>
						<td>
							<fmt:formatDate value="${dto.frdate }" pattern="yy.MM.dd"/>
						</td>
						<td>${dto.fip }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div class="paging">
			<c:if test="${startPage > BLOCKSIZE }">
				[ <a href="${conPath }/boardList.do?pageNum=${startPage - 1}">이전 </a> ]
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i eq pageNum }">		
					[ <b>${i }</b> ]
				</c:if>
				<c:if test="${i != pageNum }">
					[ <a href="${conPath}/boardList.do?pageNum=${i}">${i }</a> ]
				</c:if>
			</c:forEach>
			<c:if test="${endPage < pageCnt }">
				[ <a href="${conPath }/boardList.do?pageNum=${endPage + 1 }">다음</a> ]
			</c:if>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>