<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.do" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" value="${userVO.id}" name="id"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" value="${userVO.password}" name="password"/></td>
	</tr>
	<tr><td colspans="2"><input type="submit"  value="로그인"/></td></tr>
</table>
</form>
</body>
</html>