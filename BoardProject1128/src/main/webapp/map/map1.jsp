<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/include/top.jsp" %> 
<%
   String latitude =(String) request.getAttribute("latitude");
   String longitude =(String) request.getAttribute("longitude");
%>

<section>
 <br>
   <div align="center">
   <h2>지도 만들기1 프로젝트 </h2>
   </div>
   
 <br>
	<div id="map" style="width:1600px;height:450px;"></div>
	<div align=center>
		<input type=button name=home value="집" onclick="homeK()"> &emsp;
		<input type=button name=ezen value="이젠" onclick="ezenK()">
	</div>
 <br>
</section>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4fec5d11848bfcb0e05c9852d7a19704"></script>
<script>
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(<%=latitude %>, <%=longitude %>),
		level: 3
	};

	var map = new kakao.maps.Map(container, options);		
</script>

<script>
	function homeK() {
		location.href="<%=path%>/MapController?sw=K1";
	}
	
	function ezenK() {
		location.href="<%=path%>/MapController?sw=K2";
	}
</script>
<%@ include file ="/include/bottom.jsp" %> 