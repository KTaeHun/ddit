<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>>Form Processing</title>
</head>
<body>
<!-- 
	form01_process.jsp?name=개똥이&address=대전&email=test@test.com
 -->
<% // 스크립틀릿
   request.setCharacterEncoding("UTF-8");
   String name = request.getParameter("name");
   String address = request.getParameter("address");
   String email = request.getParameter("email");
%>
<!-- 아스가르드의 세계에서 현실로 가져오면  -->
<c:set var="name" value="<%=name %>" />
<c:set var="address" value="<%=address%>" />
<c:set var="email" value="<%=email %>" />
	<p>이름 :<%=name%></p>
	<p>주소 :<%=address%></p>
	<p>이메일 :<%=email%></p>
<script type="text/javascript">
let name = "${name}";
let address = "${address}";
let email = "${email}";
alert("name" + name + ", addr : " + addr + ", email : " + email); 

</script>
</body>
</html>