<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글상세</h1>
<a href="logout.do">Log Out</a><hr>
<form action="insertBoard.do" method="post">
<table border="1">
<tr>
	<td>제목</td>
	<td><input name="title" type="text" /></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input name="writer" type="text" /></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="content"></textarea></td>
</tr>

<tr>
	<td colsapn="2"><input type="submit" value="새글등록"/></td>
</tr>
</table>


</form><hr>

<a href="getBoardList.do">글목록으로 가기</a>

</body>
</html>