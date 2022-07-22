<%@page import="tommy.spring.web.impl.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="tommy.spring.web.impl.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글목록</h1>
<h3>테스트 회원님 환영합니다. <a href="logout.do">Log-Out</a></h3>
<form action="getBoardList.do" method="post">
<table border="1">
<tr>
	<td>
		<select name="searchCondition">
			<option value="title">제목</option>
			<option value="Content">내용</option>
		</select>
		<input type="text" name="searchKeyword"/>
		<input type="submit" value="검색"/>
	</td>
</tr>

</table>

</form><br/>
<table border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>등록일</th>
	<th>조회수</th>

</tr>

<c:forEach var="board" items="${boardList}">

<tr>
	<td>${board.getSeq()}</td>
	<td><a href="getBoard.do?seq=${board.getSeq()}">${board.getTitle()}</a></td>
	<td>${board.getWriter()}</td>
	<td>${board.getRegDate()}</td>
	<td>${board.getCnt()}</td>



</tr>
</c:forEach>
</table><br/>
<a href="insertBoard.jsp">새글 작성</a>
</body>
</html>