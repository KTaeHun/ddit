<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Current Time</title>
</head>
<body>
	<p>Current Time : <%=new java.util.Date()%></p>
	<%java.util.Calendar cal = java.util.Calendar.getInstance();%>
	<P>CurrentTime :
	<%=cal.get(java.util.Calendar.YEAR) %>년
	<%=cal.get(java.util.Calendar.MONTH)+1%>월
	<%=cal.get(java.util.Calendar.DATE)%>일
	</P>
</body>
</html>