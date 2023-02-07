<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table{
		text-align: center;
		}
		td{
		padding:5px;
		}
	</style>
</head>
<body>
	<%
		int firSu = Integer.parseInt(request.getParameter("firDan"));
		int secSu = Integer.parseInt(request.getParameter("secDan"));
	%>
<table>
	<caption><%=firSu + "단부터 " + secSu + "단까지 구구단 출력"%></caption>
	
	<%for(int i = 1 ; i <= 9 ; i++){%>
		<tr>
		<%for(int j = firSu ; j <= secSu ; j++){%>
			<td><%=j + " * " + i + " = " + (i*j)%></td>
		<%}%>
		</tr>
	<%}%>
</table>	
</body>
</html>