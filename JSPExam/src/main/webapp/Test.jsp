<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8"> <title>DB 연동</title>
</head>
<body>

<h3> Data base 연동 샘플</h3>
<hr>
<% /* 자바 DB 연동 프로그램 */
Connection con = null  ;
Statement stmt = null ;
ResultSet rs = null ;
try{
     Class.forName("oracle.jdbc.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
 
	 out.println("Database Connect : [ " + " <b>접속성공</b> ]<br>");
	 stmt = con.createStatement();
	 rs = stmt.executeQuery("select sysdate from dual");
	 if(rs.next()){
	   out.println("Today date : " + rs.getString(1) + "<hr>");
	 }   
 }catch(Exception e){
    //e.printStackTrace();
    out.println("Database Connect : [ " + " <b>접속 실패</b> ]<br>");
 } finally{
	 try{
	    if (rs != null){
	    	rs.close();
	    }
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 try{
	    if (stmt != null){
	    	stmt.close();
	    }
	 }catch(Exception e){
		 e.printStackTrace();	 
	 }
	 
	 try{
	    if (con != null){
	    	con.close();
	    }
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 System.out.println("프로그램 종료");
 }

%>

<footer>
	<address>
	<center>
		2023년 프로그래밍 언어 활용 시험입니다.<br>
		<2023-11-02> <br>
	</center>
	</address>
</footer>

</body>
</html>