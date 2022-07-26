<%@page import="tommy.spring.web.impl.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="tommy.spring.web.impl.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.list.mainTitle" /></title>
</head>
<body>
<h1><spring:message code="message.board.list.mainTitle" /></h1>
<h3>${userName}<spring:message code="message.board.list.welcomeMsg" /> <a href="logout.do">Log-Out</a></h3>
<form action="getBoardList.do" method="post">
<table border="1">
<tr>
	<td>
		<select name="searchCondition">
		<c:forEach items="${conditionMap}" var="option">
	
			<option value="${option.value}">${option.key}</option>
				</c:forEach>
			
		</select>
		<input type="text" name="searchKeyword"/>
		<input type="submit" value="<spring:message code="message.board.list.search.condition.btn" />"/>
	</td>
</tr>

</table>

</form><br/>
<table border="1">
<tr>
	<th><spring:message code="message.board.list.table.head.seq" /></th>
	<th><spring:message code="message.board.list.table.head.title" /></th>
	<th><spring:message code="message.board.list.table.head.writer" /></th>
	<th><spring:message code="message.board.list.table.head.regDate" /></th>
	<th><spring:message code="message.board.list.table.head.cnt" /></th>

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
<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard" /></a>
</body>
</html>