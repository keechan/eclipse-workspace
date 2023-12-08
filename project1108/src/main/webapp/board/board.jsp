<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>

<section>
<br>
<div align="center"> 
  <h2> 글 쓰기 </h2> 
</div>

<div align="center">
	<form action="<%=path %>/BoardController">
		<input type=hidden name=sw value="I">
		<table border=1 width=350>
			<tr><td>제목</td><td><input type=text name=title></td></tr>
			<tr><td>내용</td><td><textarea cols=30 rows=6 name=content></textarea></td></tr>
			<tr>
				<td colspan=2 align=center><input type=submit value="글저장">
				</td>
			</tr>
		</table>
	</form>
</div>
</section>

<%@ include file="/include/bottom.jsp" %>