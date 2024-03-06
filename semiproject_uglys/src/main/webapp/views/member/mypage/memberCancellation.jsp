<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dto.*" %>
<%
/* if(session.getAttribute("loginMember") == null ){
	response.sendRedirect(request.getContextPath()+"/views/index.jsp");
	return;
} */
	
Member loginMember=(Member)session.getAttribute("loginMember");


	
%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css" />
		<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/open-iconic-bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/animate.css">
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/owl.carousel.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/owl.theme.default.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/magnific-popup.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/aos.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/ionicons.min.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/bootstrap-datepicker.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/jquery.timepicker.css">
	
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/flaticon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/icomoon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/style.css">

	  </head>
	<body>

		<!-- Wrapper -->
<!-- 			<div id="wrapper">
									<header class="major">
										<h2>회원탈퇴</h2>
									</header>
									<div class="posts">
									  <div class="register-login-section spad">
        								<div class="container">
           								 <div class="row">
                							<div class="col-lg-6 offset-lg-3">
                    							<div class="register-form">
                        							<h2>Register</h2> -->
                        				<div class="container">			 
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
                    <div class="register-form">
                    <h2>회원탈퇴</h2>
                        								<form action="<%=request.getContextPath()%>/delete.do" method="post">
                           									 <div class="group-input ">
                                								<label for="username">아이디 *</label>
                                								<input type="text" id="id" name="id" value="<%=loginMember.getMemberId()%>" readonly> 
                            								</div>
                            	<div class="group-input">
                                	<label for="pass">비밀번호*</label>
                                		<input type="password" id="lastPw" name="lastPw" >
                            	</div><br>
                           		 <button type="submit" class="site-btn register-btn" id="withDraw" >회원탈퇴</button>
                        		</form>
                        		<div class="switch-login">
					<a href="<%=request.getContextPath()%>/main.do" class="or-login">돌아가기</a>
				</div>
                   			 	</div>
                				</div>
           						 </div>
        					</div>

		<!-- Scripts -->
			<script src="<%=request.getContextPath() %>/js/jyjs/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/browser.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/breakpoints.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/util.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/main.js"></script>
			<script>
				const fn_Deleteinfo=()=>{
					window.location.href='<%=request.getContextPath()%>/deleteEnd.do?memerId=<%=loginMember.getMemberId()%>';
				}
			</script>
			<script>
			document.getElementById('withDraw').onclick=function(){
			
			
			// 1. 탈퇴를 진행하시겠습니까?
			// 2. 탈퇴를 하시게 되면, 데이터는 복구 불가능합니다.
			
			if(window.confirm("탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴를 하시게 되면, 데이터는 복구 불가능합니다."))
			{	
				window.location.href='<%=request.getContextPath()%>/deleteEnd.do?memerId=<%=loginMember.getMemberId()%>';
			}else
			{
				alert("탈퇴를 취소하였습니다.")
			}	
				return false;
			
			
		};
	
	</script>
<%@ include file="/views/common/footer.jsp" %>