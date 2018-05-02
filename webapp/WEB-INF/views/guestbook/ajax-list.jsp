<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
  <title>Insert title here</title>
</head>
<body>

	<div id="container">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<div id="wrapper">
			<div id="content">
				<div id="guestbook">

					
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" name="pw" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input id="btnAdd" type="button" VALUE=" 확인 " /></td>
							</tr>
						</table>
						
						<input id="btnModel" type="button" value="삭제창">


					<!-- 방명록 리스트 -->
					<ul id=Glist>
					</ul>

				</div>
				<!-- /guestbook -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
	<!-- /container -->
	
	<!-- 삭제팝업(모달)창 -->
	<div class="modal fade" id="del-pop">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">방명록삭제</h4>
				</div>
				<div class="modal-body">
					<label>비밀번호</label> <input type="password" name="modalPassword"
						id="modalPassword"><br> <input type="text"
						name="modalPassword" value="" id="modalNo"> <br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-danger" id="btn_del">삭제</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

</body>
<script type="text/javascript">
//처음 리스트 가져올때, 데이터만 요청해서 다 가져오고는 그 데이터로 우리가 그려줘야합니다.
//1. 처음 입력화면만 보이게 한 후 화면이 list를 요청하게 합니다.

	$(document).ready(function() {
		fetchList();

	  });
	  
	  
	  
	  
$("#btnModel").on("click", function(){
	console.log("모달");	  
	$("#del-pop").modal();
	  
});
	  
$("#btnAdd").on("click", function(){
	console.log("add");
	
	var name = $("[name=name]").val();
	var pw = $("[name=pw]").val();
	var content = $("[name=content]").val();
	console.log(name);
	console.log(pw);
	console.log(content);
	
	$.ajax({
		//요청할때
		url : "${pageContext.request.contextPath }/api/gb/add", //controller적는 곳! 
		type : "post",
		data : {name:name, pw:pw, content:content},

		//응답받을때
		dataType : "json",
		success : function(guestvo) {
			console.log(guestvo);
			render(guestvo,"up");
			$("[name=name]").val("");
			$("[name=pw]").val("");
			$("[name=content]").val(""); 
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	  });
});





		
function fetchList(){
	
		//list 요청 -->ajax
		$.ajax({
			//요청할때
			url : "${pageContext.request.contextPath }/api/gb/list", //controller적는 곳! 
			type : "post",
			//data : {name:name, password:password, content:content},

			//응답받을때
			dataType : "json",
			success : function(list) {
				console.log(list);
				//console.log(list[0].name); ==>생각
				//jstl은 시점이 달라서 여기선 자바 스크립트만..
				
				for(var i = 0; i<list.length; i++ ){
					render(list[i],"down");
				}
				
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		  });
       }


function render(guestbookVO, updown){
	var str = "";
	str +="<li>";
	str +="  <table>";
	str +="      <tr>";
	str +="        <td>["+guestbookVO.no+"]</td>";
	str +="        <td>"+guestbookVO.name+"</td>";
	str +="        <td>"+guestbookVO.reg_date+"</td>";
	str +="        <td><a href='${pageContext.request.contextPath}/guest/deleteform?no=${GuestbookVO.no}'>삭제</a></td>";
	str +="      </tr>";
	str +="      <tr>";
	str +="       <td colspan=4>";
	str +=          guestbookVO.content;
	str +="       </td>";
	str +="     </tr>";
	str +="   </table>";
	str +="  <br>";
	str +="</li>";
	
	if(updown =="up"){
		$("#Glist").prepend(str);
	}else if(updown == "down"){
	    $("#Glist").append(str);
	}else{
		console.log("오류")
	}
	
}

		//데이터 수신
		//리스트 그리기 

</script>
</html>