<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<%@ page import="pkg.board.*" %>
<%
	BoardVO m = (BoardVO) request.getAttribute("vo");
%>

<section>	
	<br>
	<div align=center>상세 정보</div>
	<br>
	<div>		
		<br>
			<form action="BoardController?sw=E">
				<table>
					<tr><td>번호</td><td><%=m.getNumid() %></td></tr>
					<tr><td>제목</td><td><%=m.getTitle() %></td></tr>
					<tr><td>글내용</td><td><%=m.getContent() %></td></tr>
					<tr><td colspan=2>
							<input type=button value="수정하기">
						</td>
					</tr>			
				</table>
			</form>
		<br>
	</div>
</section>

<%@ page include="/include/bottom.jsp" %>