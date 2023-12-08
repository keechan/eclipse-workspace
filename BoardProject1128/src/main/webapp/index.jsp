<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/include/top.jsp" %> 

<section>
 <br>
	<div id="map" style="width:1600px;height:500px;" align=center></div>
 <br> 
</section>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4fec5d11848bfcb0e05c9852d7a19704"></script>
<script>
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(37.48546805, 126.9302654),
		level: 3
	};

	var map = new kakao.maps.Map(container, options);
</script>
<%@ include file ="/include/bottom.jsp" %> 