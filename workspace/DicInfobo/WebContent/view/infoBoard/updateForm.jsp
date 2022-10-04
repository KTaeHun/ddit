<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.infoboard.vo.InfoBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	InfoBoardVO ibv = (InfoBoardVO) request.getAttribute("ibv");

	List<AtchFileVO> atchFileList = 
			(List<AtchFileVO>) request.getAttribute("atchFileList");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 회원 등록</title>
</head>
<body>
	<form action="update.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="infoboNum" value="<%=ibv.getInfoboNum() %>">
	<input type="hidden" name="fileId" value="<%=ibv.getAtchFileId() %>">	
		<table>
<!-- 			<tr> -->
<!-- 				<td>글 번호 :</td> -->
<%-- 				<td><%=ibv.getInfoboNum() %></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="infoboTitle" value=""></td>
			</tr>
			<tr>
				<td>작성자 :</td>
				<td><input type="text" name="infoboLike" value=""></td>
			</tr>
			<tr>
				<td>내용 :</td>
				<td><textarea rows="30" cols="50" name="infoboCon">
				<%=ibv.getInfoboCon() %>
				</textarea></td>
			</tr>
			<tr>
				<td>기존 첨부파일 :</td>
				<td>
					<%
						if (atchFileList != null) {
							for (AtchFileVO fileVO : atchFileList) {
					%>
						<div><a href="<%=request.getContextPath() %>/filedown.do?fileId=<%=fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn() %>"><%=fileVO.getOrignlFileNm() %></a></div>
					<%			
							}
						}
					%>
				</td>
			</tr>
			<tr>
				<td>첨부파일1 :</td>
				<td><input type="file" name="atchFile" multiple="multiple"></td>
			</tr>	
		</table>
		<input type="submit" value="글수정">
	</form>
</body>
</html>