<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "pkg.JungVO" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
	//String path = request.getContextPath();
	List<JungVO> li = (List<JungVO>) request.getAttribute("li");
	double grandTotal = 0;
	double grandAvg = 0;
	int skor = 0;
	int seng = 0;
	int smath = 0;
	int shist = 0;
	int count = 0;
%>
	
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
		font-color:#00ff00;
	}
	table {
		border: 2px solid;
		width: 80%;
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
		(과정평가형 정보처리산업기사) 성적조회 프로그램 Ver 1.0
	</header>
	
	<nav>
		&emsp;&emsp;<a href=JungboController?sw=F>성적입력</a>
		&emsp;&emsp;<a href=JungboController?sw=S>성적조회</a>
		&emsp;&emsp;<a href=index.jsp>홈으로</a>
	</nav>

	<section>
		<br>
			<div align="center">
				<h2>성적 조회 목록</h2>
			</div>
			<div align="center" style=""overflow-x:auto">
				<table>
					<tr>
						<th>학년</th><th>반</th><th>번호</th><th>이름</th>
						<th>국어</th><th>영어</th><th>수학</th><th>국사</th><th>등록일</th><th>수정일</th>						
						<th>조회수</th><th>합계</th><th>평균</th>					
					</tr>
					<tr>
						<% if(li==null) {
							//System.out.println("########");
							//pageContext.forward("JungboController?sw=S");
							response.sendRedirect("JungboController?sw=S");
						} else {
							for (JungVO m : li) { 
								String sno = m.getSno();
								String sname = m.getSname();
								int kor = m.getKor();
								int eng = m.getEng();
								int math = m.getMath();
								int hist = m.getHist();
								String today = m.getToday();
								if (today!=null) {
									today = today.substring(0, 10);
								} else {
									today = " ";
								}
								Date nowDate = m.getNowDate();
								SimpleDateFormat simpleDateFormat =
									new SimpleDateFormat("yyyy/MM/dd aa hh:mm:ss");
								String strDate = simpleDateFormat.format(nowDate);
								int cnt = m.getCnt();
								int total = kor+eng+math+hist;
								skor += kor;
								seng += eng;
								smath += math;
								shist += hist;
								grandTotal += total;
								count++;
								double totalAvg = (double) total / 4;
						%>
						<td align=center><%=sno.substring(0, 1) %></td>
						<td align=center><%=sno.substring(1, 3) %></td>
						<td align=center><%=sno.substring(3, 5) %></td>
						<td align=center>
							<a href=JungboController?sw=E&sno=<%=sno%>><%=sname %></a>
						</td><td align=right><%=kor %></td>
						<td align=right><%=eng %></td><td align=right><%=math %></td><td align=right><%=hist %></td>
						<td align=center><%=today %></td>
						<td align=center><%=strDate %></td>
						<td align=right><%=cnt %></td>
						<td align=right><%=total %></td>
						<td align=right>
							<a href=JungboController?sw=D&sno=<%=sno%>><%=totalAvg %></a>
						</td>
						<!--  <td>
							<button onclick="myDelete()">Delete</button>
						</td>-->
					</tr>
						<% } 
							
						}%>
						<% grandAvg = (double) grandTotal/count; %>
					<tr>
						<td colspan=4 align=center>과목별 합계</td><td align=right><%=skor %></td><td align=right><%=seng %></td>
						<td align=right><%=smath %></td><td align=right><%=shist %></td><td colspan=3 align=center>합계/평균</td>
						<td align=right><%=String.format("%,.0f", grandTotal) %></td><td align=right><%=String.format("%,.3f", grandAvg) %></td>
					</tr>
				</table>
			</div>
		<br>
	</section>
	
	<footer>
		<br>
		HRD Korea Copyright &copy; 2023 All right reserved
	</footer>
</body>
</html>