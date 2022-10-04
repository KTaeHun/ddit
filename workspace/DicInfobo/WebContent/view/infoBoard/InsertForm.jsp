<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>
</head>
<body>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<table>
<!-- 			<tr> -->
<!-- 				<td>글 번호 :</td> -->
<!-- 				<td><input type="text" name="infoboNum" value=""></td> -->
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
				<td><textarea rows="30" cols="50" name="infoboCon"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일1 :</td>
				<td><input type="file" name="atchFile" multiple="multiple"></td>
			</tr>
		</table>
		<input type="submit" value="글등록">
	</form>
</body>
</html>