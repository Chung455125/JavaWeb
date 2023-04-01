<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!String str = new String("Hello JSP"); %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
	<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
	<title>BMI Result Page </title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="GET" action="/JavaWeb/html/bmi.html">
		<fieldset>
			<legend>BMI 結果顯示</legend>
				<!-- 顯示結果 -->
				${ str }
				<p></p>
				<%out.print(str); %>
				<p></p>
				<%out.print(request.getAttribute("output")); %>
				<p></p>
				<%=request.getAttribute("output") %>
				<p></p>
				${ output }
				<p></p>
				<!-- 返回鍵 -->
				<button type="submit" class="pure-button pure-button-primary">返回</button>			
		</fieldset>
	</form>

</body>
</html>