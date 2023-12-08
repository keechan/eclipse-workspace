<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	System.out.println("path:"+path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<br>
		<br>
		<br>
		<h1>시작페이지</h1>
		<h3>
			<a href="<%=path%>/member/member_form.jsp">회원 가입</a><br>
			<br>
			<a href="<%=path%>/SelectController">회원 목록</a><br>
			<br>
		</h3>
	</div>
</body>
</html>