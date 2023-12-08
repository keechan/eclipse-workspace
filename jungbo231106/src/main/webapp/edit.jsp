<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "pkg.*" %>

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
	table {
		border: 2px solid;
		width: 30%;
		border-collapse: collapse;
	}
	tr {
		border: 1px solid;
	}
	th, td {
		padding: 6px;
		border: 1px solid;
	}
</style>
</head>

<body>
	<header>
		(과정평가형 정보처리산업기사) 성적조회 프로그램 Ver. 1.0
	</header>
	
	<nav>
		&emsp;&emsp;<a href=JungboController?sw=F>성적입력</a>
		&emsp;&emsp;<a href=JungboController?sw=S>성적조회</a>
		&emsp;&emsp;<a href=index.jsp>홈으로</a>
	</nav>
	<%
		JungVO vo = (JungVO) request.getAttribute("vo");
		String sno = vo.getSno();
		String sname = vo.getSname();
		int kor = vo.getKor();
		int eng = vo.getEng();
		int math = vo.getMath();
		int hist = vo.getHist();
		String today = vo.getToday();
		System.out.println(today);
	%>
	<section>
		<br>
			<div align="center">
				<h2>학생 상세 보기</h2>
			</div>
			<div align="center">
			<script>
				function ck() {
						if(f1.sno.value == "") {
							alert("확번이 입력되지 않았습니다.");
							f1.sno.focus();
							return false;
						}
						if(f1.sname.value == "") {
							alert("이름이 입력되지 않았습니다.");
							f1.sname.focus();
							return false;
						}
						alert("성적 입력이 완료 되었습니다");
					}
				}
			</script>
			<form name=f1 action="JungboController" onSubmit="return ck()">
				<input type=hidden name=sw value="U">
				<table border=1>

					<tr><th width=60>학번</th><td><input type=text name=sno value=<%=sno %> readonly></td></tr>
					<tr><th width=60>성명</th><td><input type=text name=sname value=<%=sname %>></td></tr>
					<tr><th width=60>국어</th><td><input type=text name=kor value=<%=kor %>></td></tr>
					<tr><th width=60>영어</th><td><input type=text name=eng value=<%=eng %>></td></tr>
					<tr><th width=60>수학</th><td><input type=text name=math value=<%=math %>></td></tr>
					<tr><th width=60>역사</th><td><input type=text name=hist value=<%=hist %>></td></tr>
					<tr><th width=80>날짜</th><td><input type=date name=today value=<%=today %>></td></tr>
					<tr><td colspan=2 align=center><input type=submit value=성적수정></td></tr>
				</table>
			</form>
			</div>
		<br>
	</section>
	
	<footer>
		<br>
		HRD Korea Copyright &copy; 2023 All right reserved
	</footer>
</body>
</html>