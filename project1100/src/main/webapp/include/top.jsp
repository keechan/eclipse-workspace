<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header{
		background:#0000ff; /* 배경색깔 */
		height:90px;      /* 영역의 높이 */ 
		line-height:70px; /* 라인 높이 */
		color:#ffffff;    /* 흰색 글자 */
		font-size:30px;   /* 글자 사이즈 */
		text-align:center; /*글자 정렬 */
	}
	nav{
		background:#0088ff; /* 배경색깔 */
		height:35px;      /* 영역의 높이 */ 
		line-height:35px; /* 라인 높이 */
		color:#ffffff;    /* 흰색 글자 */
		font-size:14px;   /* 글자 사이즈 */
		text-align:left; /*글자 정렬 */
	}
	section{
		background:#eaeaea; /* 배경색깔 */
		min-height:500px;   /* 영역의 높이 */ 
		line-height:35px;   /* 라인 높이 */
		color:#000000;      /* 흰색 글자 */
	}
	footer{
		background:#00008B; /* 배경색깔 */
		min-height:100px;   /* 영역의 높이 */ 
		line-height:35px;   /* 라인 높이 */
		color:#ffffff;      /* 흰색 글자 */
		text-align:center; /*글자 정렬 */
	}
a{
	text-decoration:none;
	font-color:#ffffff;
}
</style>
</head>

<body>
	<header>
		(과정평가형 정보처리산업기사) 성적조회 프로그램 Ver 1.0
	</header>
	
	<nav>
		&emsp;&emsp;<a href="<%=path%>/TestController">TestController</a>
		&emsp;&emsp;<a href="<%=path%>/member/member.jsp">멤버</a>
		&emsp;&emsp;<a href="<%=path%>/index.jsp">홈으로</a>
	</nav>
