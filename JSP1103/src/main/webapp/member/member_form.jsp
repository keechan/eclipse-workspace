<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="<%=path%>/insertController">
		이름 : <input type=text name="name"> <br>
		암호 : <input type=text name="pwd"> <br>		
		메일 : <input type=text name="email"> <br>
		<input value="저장하기" type=submit>
	</form>
</body>
</html>