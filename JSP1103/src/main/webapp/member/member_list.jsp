<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="pkg.Service.*" %>
<%@ page import="pkg.model.*" %>
<%
	String path = request.getContextPath();
%>	
<%
    @SuppressWarnings("unchecked")
	List<MemberVO> li = (List<MemberVO>)request.getAttribute("li");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div align="center">
		<h2>회원 목록 보기</h2>
	</div>
	<table border=1>
		<tr>
			<th>아이디</th><th>이름</th><th>암호</th><th>이메일</th>
		</tr>
		<% for(MemberVO m:li) { %>
		<tr>
			<td><%=m.getId()%></td>
			<td><a href="<%=path%>/EditController?id=<%=m.getId()%>"><%=m.getName() %></a>
			</td>
			<td><%=m.getPwd() %></td>
			<td><%=m.getEmail() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>