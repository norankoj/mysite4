<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
	<title>회원가입</title>
</head>
<body>

	<div id="container">
		
       <c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
         <c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="get" action="${pageContext.request.contextPath}/user/join">
						<input type="hidden" name="a" value="join"> <!--쿼리스트링으로도 할 수 있지만! 그땐,post-->
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="">
						<div id="msgname" ></div>
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="">
						<input id="btnEmailCheck" type="button" value="id 중복체크">
						<div id="msg" ></div>
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="">
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="submit" value="가입하기">
						
					</form>
					
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>		
	</div> <!-- /container -->

</body>
<script type="text/javascript">
  $("#btnEmailCheck").on("click", function(){
	 console.log("이메일체크버튼");
	 
	 var email = $("#email").val();
	 console.log(email);
	 
		 
         $.ajax({
           
        	 //요청할때
             url : "${pageContext.request.contextPath }/user/emailcheck", 
             type : "post",
             // contentType : "application/json",
            data : {email:email},        
           
             //응답받을때
             dataType : "json",
             success : function(isExists){
            	 console.log(isExists);
            	 if(isExists==true){
            		 $("#msg").html("사용중인 아이디 입니다.")
            	 }else{
            		 $("#msg").html("사용할 수 있는 아이디 입니다.")
            	 }
        
         
             },
         
             error : function(XHR, status, error) {
         
            	 console.error(status + " : " + error);
         
             }
         
         });
         
  });

</script>

<script type="text/javascript">
$("#name").on("click", function(){
	 
	 var name = $("#name").val();
	// console.log(name);
	 
	 if(name!=null){
   		 /* $("#msgname").html("아이디를 입력해주세요.") */
   	 }else{
   		$("#msgname").html("아이디를 입력해주세요.")
   	 }

});


</script>
</html>