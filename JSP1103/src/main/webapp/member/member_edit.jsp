<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="pkg.model.*" %>

<% String path = request.getContextPath(); %>
<%
	MemberVO m = (MemberVO) request.getAttribute("m");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>회원 내역</h2>
	</div>
	<table border="1">
		<tr>
			<th>아이디</th><td><%=m.getId() %></td>
		</tr>
		<tr>
			<th>이름</th><td><%=m.getName() %></td>
		</tr>
		<tr>
			<th>암호</th><td><%=m.getPwd() %></td>
		</tr>
		<tr>
			<th>이메일</th><td><%=m.getEmail() %></td>
		</tr>
	</table>
	<a href="<%=path%>/DeleteController?id=<%=m.getId() %>">삭제하기</a>
</body>
</html>