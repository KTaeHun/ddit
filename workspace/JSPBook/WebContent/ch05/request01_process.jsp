<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		// 문자 인코딩 유형을 UTF-8로 작성
		request.setCharacterEncoding("UTF-8");
		
		// 입력된 아이디와 비밀번호를 폼 문으로부터 전송받음
		String name = request.getParameter("name");  // 개똥이
		String passwd = request.getParameter("passwd");  // 1234
	%>
	<p>이름 : <%=name%></p>
	<p>비밀번호 : <%=passwd%></p>
	
</body>
</html>