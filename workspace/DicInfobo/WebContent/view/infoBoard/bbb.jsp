<%@ page import="kr.or.ddit.infoboard.vo.InfoBoardVO" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%
 	List<InfoBoardVO> infoBoardList = 
			(List<InfoBoardVO>)request.getAttribute("infoBoardList");

	String msg = session.getAttribute("msg") == null?
			""	: (String) session.getAttribute("msg");
	session.removeAttribute("msg");  // 꺼내온 메세지 속성값 삭제하기
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>

	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">추천수</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						<th style="background-color: #eeeeee; text-align: center;">첨부파일</th>
					</tr>
				</thead>
				<tbody>
				<%
				 int infoBoardSize = infoBoardList.size(); 
				 if(infoBoardSize > 0) {
					 for (int i = 0; i < infoBoardSize; i++) { 
				%>
					<tr>
						<td><%= infoBoardList.get(i).getInfoboNum() %></td>
						<td><a href="detail.do?infoboNum=<%= infoBoardList.get(i).getInfoboNum() %>"><%= infoBoardList.get(i).getInfoboTitle() %></a></td>
						<td><%= infoBoardList.get(i).getInfoboLike() %></td>
						<td><%= infoBoardList.get(i).getInfoboCon() %></td>
						<td><%= infoBoardList.get(i).getInfoboDate() %></td>
						<td><%= infoBoardList.get(i).getAtchFileId() %></td>
					</tr>
				<%
					 }
					 
				 } else {
				%>		
					<tr>
						<th colspan="6">게시글이 없습니다.</th>
					</tr>
				<%
				}
				%>
					<tr>
						<td colspan="6"><a href="insert.do">[글 등록]</a>
					</tr>
				</table>
				<%
					if(msg.equals("성공")) {
				%>
					<script>
						alert("정상적으로 처리되었습니다.");
					</script>
					
				<%
					}
				%>
				</tbody>
			</table>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>