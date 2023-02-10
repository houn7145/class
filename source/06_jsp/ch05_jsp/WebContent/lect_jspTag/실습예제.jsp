<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		window.onload = function(){
			document.querySelector("form").onsubmit = function(){
				var su = document.querySelector('input[name="su"]');
				var suNum = Number(su.value.trim());
				if(isNaN(suNum) || suNum <=0 || suNum%1!=0){
					alert('자연수를 입력하세요');
					su.value = '';
					su.focus();
					return false;
				}
			};
		};
	</script>
</head>
<body>
	<%
		String num = request.getParameter("su"); 
		if(num!=null){
			num = num.trim();
		}
	%>
	<fieldset>
			<legend>숫자입력</legend>
		<form>
			<%-- 숫자 <input type="text" name="su" value="<%=num == null ? "" : num%>"><input type="submit" value="누적"> --%>
			숫자 <input type="text" name="su" value="<%
													if(num!=null){
														out.print(num);
													}
													%>">
				<input type="submit" value="누적">
		</form>	
	</fieldset>
	<%
		if(num!=null){
			int n = Integer.parseInt(num);
			int total = 0;
			for(int i = 1 ; i < n ; i++){
				total += i;
			}
			out.println("<h2>1부터 " + n + "까지 누적합은 " + total + "입니다</h2>");
		}
	%>
</body>
</html>