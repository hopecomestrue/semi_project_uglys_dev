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
		<style>
			#sidebar {
				padding-top: 70px;
				position: sticky;
  				top: 0;
			}

		</style>
	  </head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
									<div class="container">
									  <a class="navbar-brand" href="/index.html">채소랑</a>
									  <!-- 메인화면으로 이동 // 주소바꾸기 -->
									  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
										<span class="oi oi-menu"></span> Menu
									  </button>
							
									 <div class="collapse navbar-collapse" id="ftco-nav">
										<ul class="navbar-nav ml-auto">
										  <li class="nav-item"><a href="#" class="nav-link">Home</a></li>
										  <li class="nav-item"><a href="#" class="nav-link">채소농장</a></li>
										  <li class="nav-item"><a href="#" class="nav-link">커뮤니티</a></li>
										  <li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
										  <li class="nav-item"><a href="/mypage.html" class="nav-link">마이페이지</a></li>
										  <li class="nav-item cta cta-colored"><a href="#" class="nav-link"><span href=""></span>[0]</a></li>
							
										</ul>
									  </div>
									</div>
								  </nav>
								</header>
							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h2>마이페이지<br />
											</h2>
										</header>
									</div>
								</section>
							<!-- Section -->
								<section>
									<header class="major">
										<h2>회원탈퇴</h2>
									</header>
									<div class="posts">
									  <div class="register-login-section spad">
        								<div class="container">
           								 <div class="row">
                							<div class="col-lg-6 offset-lg-3">
                    							<div class="register-form">
                        							<!-- <h2>Register</h2> -->
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
    					</div>
									</div>
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">
							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>마이페이지</h2>
									</header>
									<ul>
										<li>
											<span class="opener">나의 주문</span>
											<ul>
												<li><a href="/myorders.html">주문 조회</a></li>
												<li><a href="/myreturn.html">반품 조회</a></li>
												<li><a href="/cart1.html">장바구니</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">나의 활동</span>
											<ul>
												<li><a href="#">나의 리뷰</a></li>
												<li><a href="#">북마크</a></li>
												<li><a href="#">1:1문의</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">내 정보</span>
											<ul>
												<li><a href="#">내 정보 수정</a></li>
												<li><a href="#">배송지 관리</a></li>
											</ul>
										</li>
										<li><a onclick="confirmLogout()">로그아웃</a></li>
									</ul>
								</nav>

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
				function confirmLogout() {
					var result = confirm("로그아웃 하시겠습니까?");
					if (result) {
						alert("로그아웃 되었습니다."); 
					} else {
						alert("로그아웃 취소되었습니다.");
					}
				}
			  <%--   const fn_completedelete=()=>{
			    	window.location.href='<%=request.getContextPath()%>//updateInfoend.do';
			    } --%>
			</script>			
			<script>
				const fn_Deleteinfo=()=>{
					window.location.href='<%=request.getContextPath()%>/deleteEnd.do?memerId=<%=loginMember.getMemberId()%>';
				}
			</script>
			<script>
			document.getElementById('withDraw').onclick=function(){
			
			
			// 1. 탈퇴를 진행하시겠습니까?
			// 2. 탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다.
			
			if(window.confirm("탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다."))
			{	
				window.location.href='<%=request.getContextPath()%>/deleteEnd.do?memerId=<%=loginMember.getMemberId()%>';
			}else
			{
				alert('cancel')
			}	
				return false;
			
			
			
			
		};
	
	</script>
<%@ include file="/views/common/footer.jsp" %>