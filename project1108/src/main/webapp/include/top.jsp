<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=path %>/css/main.css" type="text/css" rel="stylesheet">
</head>
<body>
<header>
  (과정평가형 정보처리산업기사) 성적조회 프로그램 Ver1.0
</header>

<nav>
&emsp;&emsp;<a href="<%=path %>/member/form.jsp">회원가입</a>
&emsp;&emsp;<a href="<%=path %>/MemberController?sw=S">회원보기</a>
&emsp;&emsp;<a href="<%=path %>/board/board.jsp">글쓰기</a> 
&emsp;&emsp;<a href="<%=path %>/BoardController?sw=S">글목록</a>
&emsp;&emsp;<a href="<%=path %>/index.jsp">처음으로</a>
</nav>