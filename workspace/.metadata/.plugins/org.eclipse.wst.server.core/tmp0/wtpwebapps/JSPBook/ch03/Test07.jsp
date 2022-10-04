<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Book Market Mall</title>
</head>
<body>
	<%@ include file="Test07_menu.jsp" %>	
	<%!	// 선언문
		String greeting = "도서 웹 쇼핑몰";
	%>
	<!-- 표현문  -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><%=greeting%></h1>
		</div>	
	</div>
	
	<%@ include file="Test07_footer.jsp" %>
</body>
</html>