<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/include/top.jsp" %> 
<%@ page import ="board.comment.*" %> 
<%@ page import ="java.util.*" %> 
<%
BoardVO   m =(BoardVO) request.getAttribute("m");
List<CommentVO>   li =(List<CommentVO>) request.getAttribute("li");

System.out.println("===> 주소확인: " + m.getAddress());

%>

<script  src="http://code.jquery.com/jquery-1.10.2.js" ></script>
<script>
jQuery.ajaxSetup({cache:false});
$(document).ready( function(){
	
	  $('#saveK').click( function(){		 		 
		  alert("sw확인:" + $('#cisw').val() );
		  var  dataStr={
				  sw : $('#cisw').val(),
				  comment_idx : $('#comment_idx').val(),
				  commentContent : $('#commentContent').val()	
		  };
		  		 
		  $.ajax({			 
			  type: "GET",
			  url : "<%=path%>/CommentController",
			  data : dataStr,
			  success: function (data){
			  // alert("저장성공!!" + $('#sno').val() );
			  location.replace("<%=path%>/CommentController?sw=E&idx="+$('#comment_idx').val()) ;
			  }	  
		  })		 
	  }) /* saveK 끝  */
	  
	  $('#updateK').click( function(){		 		 
		  alert("usw확인:" + $('#usw').val());
		  var  dataStr={
				  sw : $('#usw').val(),
				  idx : $('#idx').val(),
				  title : $('#title').val(),
				  sname : $('#sname').val(),
				  content : $('#content').val()	
		  };
		  		 
		  $.ajax({			 
			  type: "GET",
			  url : "<%=path%>/CommentController",
			  data : dataStr,
			  success: function (data){
			  alert("data" + data )
			  location.replace("<%=path%>/CommentController?sw=S") ;
			  }	  
		  })		 
	  }) /* updateK 끝  */
	  
	  
	  $('#listK').click( function(){
			  location.replace("<%=path%>/CommentController?sw=S") ;
	  }) /* listK 끝  */
	  
	  
	  
})


 function  deleteK(cidx , comment_Idx){	
	  var  dataStr={
			  sw : "CD",
			  cidx : cidx,
			  comment_Idx : comment_Idx
	  };
	  		 
	  $.ajax({			 
		  type: "GET",
		  url : "<%=path%>/CommentController",
		  data : dataStr,
		  success: function (data){
		  alert("data" + data + ":" + comment_Idx)
		  location.replace("<%=path%>/CommentController?sw=E&idx="+comment_Idx) ;
		  }	  
	  })		
	
 }

</script>

<section>
<br>
<div align="center">
  <h2>코맨트 글 상세보기/수정하기 </h2>
<table  border=1  width=1000  height=300>
<tr><td width=440>
 <div align="center">   
  <div id="map" style="width:100%;height:300px;"></div>
 </div>
</td>
<td width=560>
   <div align="center"> 
   <input type=hidden  name=sw value=U  id=usw>
   <table border=1 width=560>
   <tr><td>번호 </td>
      <td><input type=text  name=idx  id=idx  size=10 value=<%=m.getIdx() %> readonly ></td></tr>
   <tr><td>제목 </td><td><input type=text  name=title id=title  size=30  value="<%=m.getTitle() %>">  </td></tr>
   <tr><td>글쓴이 </td><td><input type=text  name=sname id=sname  value="<%=m.getSname() %>"> </td></tr>
   <tr><td>글내용 </td>
        <td>
          <textarea cols=40  rows=5 name=content id=content><%=m.getContent() %></textarea> 
   		</td>
   </tr>
   <tr><td>주소</td>
       <td><input type=text  name=address id=address size=40 value="<%=m.getAddress() %>"> 
       </td>
   </tr>
   <tr><td colspan=2 align="center">
       <input  type=button value="글수정하기" id="updateK" > &emsp; 
       <input  type=button value="목록보기"  id="listK"  >
       </td></tr>
   </table>   
   </div>
  </table>   
     
</div>   

<div align="center">

  <input  type=hidden  name=sw  value="CI"  id=cisw > 
  <input  type=hidden  name=comment_idx  value=<%=m.getIdx() %> id=comment_idx > 
  <table border=1 width=1000>
    <tr> <td>&nbsp; <input  type=text size=57  name=commentContent id=commentContent>  </td>
         <td align="center"><input  type=button id="saveK"  value="코맨트저장" >  </td> 
    </tr>
  </table>  
 <table  border=1  width=1000>
   <tr><th width=20>번호 </th><th width=340>코맨트 </th><th width=100>날짜 </th><th width=40>삭제 </th></tr>
   <% for(CommentVO m1: li) { %>
   <tr align="center">
      <td><%=m1.getCidx() %> </td>
      <td align="left"><%=m1.getCommentContent() %> </td>
      <td > &nbsp; <%=m1.getCommentDate() %></td>
      <td> <input type=button  value="삭제"
                  onclick="deleteK('<%=m1.getCidx()%>','<%=m.getIdx()%>')" > </td>
   </tr>   
   <% } %>
   </table> 

</div>
 <br>
</section>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4fec5d11848bfcb0e05c9852d7a19704&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
//alert('<%=m.getAddress()%>');
// 주소로 좌표를 검색합니다
geocoder.addressSearch('<%=m.getAddress()%>', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=m.getTitle()%></div>'

        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
   

<%@ include file ="/include/bottom.jsp" %> 