<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="Test05_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>include 디렉티브 태그</title>
</head>
<body>
	<%java.util.Calendar cal = java.util.Calendar.getInstance();%>
	<P>현재시간 :
	<%=cal.get(java.util.Calendar.YEAR) %>년
	<%=cal.get(java.util.Calendar.MONTH)+1%>월
	<%=cal.get(java.util.Calendar.DATE)%>일
	</P>
	현재시간: <%=Calendar.getInstance().getTime() %>
</body>
</html>