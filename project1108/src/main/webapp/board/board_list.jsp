<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<%@ page import="pkg.board.*" %>
<%@ page import="java.util.*" %>
<%
	List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");
%>

<section>
	<br>
	<div align="center"> 
	  <h2> 글 목록 </h2> 
	</div>
	<div align=center>
		<table border=1>
			<tr>
				<td align=center>번호</td>
				<td align=center>제목</td>
				<td align=center>글 내용</td>
			</tr>
			<% String strContent = ""; %>
			<%for(BoardVO vo:li) { %>
			<%if(vo.getContent().length() <= 10) { 
				strContent = vo.getContent();
			  } else {
				strContent = vo.getContent().substring(0, 10);
			  }
			  System.out.println(strContent);
			%>
			<tr>
				<td align=center><%=vo.getNumid() %></td>
				<td>
					<a href="BoardController?sw=E&numId=<%=vo.getNumid()%>" ><%=vo.getTitle() %></a>
				</td>
				<td>
					<%=strContent %>
				</td>
			</tr>
			<% } %>			
		</table>
		<!-- 필터 -->
		<form action="<%=path%>/BoardController">
			<input type=hidden name=sw value="S">
			<select name=ch1>
				<option value="title">제 목</option>
				<option value="content">내 용</option>
			</select>
			<input type=text name=ch2>
			<input type=submit value="검색하기">
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp" %>