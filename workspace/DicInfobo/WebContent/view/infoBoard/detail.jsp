<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.infoboard.vo.InfoBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	InfoBoardVO ibv = (InfoBoardVO) request.getAttribute("ibv");

	List<AtchFileVO> atchFileList = 
			(List<AtchFileVO>)request.getAttribute("atchFileList");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 게시판</title>
</head>
<body>
	   <table border="1px">
			<tr>
				<td width=80px>제목 </td>
				<td width=400px><%=ibv.getInfoboTitle() %></td>
			</tr>
			<tr>
				<td width=80px>작성일 </td>
				<td width=400px><%=ibv.getInfoboDate() %></td>
			</tr>
			<tr>
				<td width=80px>작성자 </td>
				<td width=400px><%=ibv.getInfoboLike() %></td>
			</tr>
			<tr height=150px>
				<td width=80px rowspan=2>내용 </td>
				<td width=400px><%=ibv.getInfoboCon() %></td>
			</tr>
			<tr height=250px>
				<td width=400px><%=ibv.getInfoboCon() %></td>
			</tr>
			<tr>
				<td>첨부파일 </td>
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
				<td colspan="2">
					<a href="list.do">[목록]</a>
					<a href="update.do?infoboNum=<%=ibv.getInfoboNum() %>">[글 수정]</a>
					<a href="delete.do?infoboNum=<%=ibv.getInfoboNum() %>">[글 삭제]</a>				
				</td>
			</tr>
		</table>
</body>
</html>