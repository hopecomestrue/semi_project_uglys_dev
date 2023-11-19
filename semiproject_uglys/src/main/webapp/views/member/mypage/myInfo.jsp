<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dto.*" %>
<%-- <%@ page import="com.veg.ojy.mypage.dto.Address"%> --%>
<%-- <%@ page import="com.veg.ojy.mypage.dto.*" %> --%>
<%
	Member loginMember=(Member)session.getAttribute("loginMember");
	
%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css" type="text/css"/>
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
									  <a class="navbar-brand" href="index.html">채소랑</a>
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
										  <li class="nav-item"><a href="mypage.html" class="nav-link">마이페이지</a></li>
										  <li class="nav-item cta cta-colored"><a href="cart1.html" class="nav-link"><span href=""></span>[0]</a></li>
							
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
										<h2>내 정보 수정</h2>
									</header>
									<div class="posts">
                                        <form method="post" action="<%=request.getContextPath()%>/myinfo.do" class="text-center">
                                            <div class="row gtr-uniform justify-content-center" >
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-name" class="col-md-4 col-form-label">아이디</label>
                                                        <div class="col-md-8"> 
                                                            <input type="text" name="demo-name" id="demo-name" class="form-control" value="<%=loginMember.getMemberId()%>" readonly placeholder="아이디" style=" width: 40%;"/>
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-password" class="col-md-4 col-form-label">비밀번호</label>
                                                        <div class="col-md-8"> 
                                                            <input type="password" name="demo-password" id="demo-password" class="form-control" value="<%=loginMember.getMemberPw() %>" placeholder="비밀번호" style=" width: 40%;"/>
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-fullname" class="col-md-4 col-form-label">이름</label>
                                                        <div class="col-md-8"> 
                                                            <input type="text" name="demo-fullname" id="demo-fullname" class="form-control" value="<%=loginMember.getMemberName() %>" required placeholder="이름" style=" width: 40%;"/>
                                                        </div>
                                                    </div>
                                                </div><br>
                                                 <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-fullname" class="col-md-4 col-form-label" value="<%=loginMember.getMemberAge() %>">연령</label>
                                                        <div class="col-md-8"> 
                                                           <select>
																<option>선택 안함</option>
																<option>10세 미만</option>
																<option>10~19세</option>
																<option>20~29세 미만</option>
																<option>30~39세 미만</option>
																<option>40대 이상</option>
															</select>
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row">
                                                        <label for="demo-phone" class="col-md-4 col-form-label">휴대폰번호</label>
                                                        <div class="col-md-8"> 
                                                            <input type="text" name="demo-phone" id="demo-phone" class="form-control" value="<%=loginMember.getMemberPhone() %>"  placeholder="휴대폰번호" style=" width: 40%;" />
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-email" class="col-md-4 col-form-label">이메일</label>
                                                        <div class="col-md-8"> 
                                                            <input type="email" name="demo-email" id="demo-email" class="form-control" value="<%=loginMember.getMemberEmail() %>" placeholder="Email"style=" width: 60%;"/>
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-address" class="col-md-4 col-form-label">주소</label>
                                                        <div class="col-md-8"> 
                                                            <input type="text" name="demo-address" id="demo-address" class="form-control" value="" placeholder="주소"style=" width: 80%;" />
                                                           
                                                        </div>
                                                    </div>
                                                </div><br>
                                                 <div class="col-12 col-md-6"> 
                                                    <div class="form-group row"> 
                                                        <label for="demo-address" class="col-md-4 col-form-label"></label>
                                                        <div class="col-md-8"> 
                                                            
                                                        </div>
                                                    </div>
                                                </div><br>
                                                <div class="col-6 col-12-small d-flex justify-content-center">
                                                    <input type="checkbox" id="demo-human" name="demo-human" checked>
                                                    <label for="demo-human">[선택] 할인 등 정보 혜택 수신 동의 </label>
                                                </div>
                                                <div class="col-12 d-flex justify-content-center">
                                                    <ul class="actions">
                                                        <li><input type="button" value="비밀번호 변경하기" class="primary" onclick="fn_changePw();"/></li>
                                                        <li><input type="button" value="새 배송지 등록하기" class="primary" onclick="fn_changeAddr();"/></li>
                                                    </ul>
                                                  </div>
                                                <div class="col-12 d-flex justify-content-center">
                                                    <ul class="actions">
                                                        <li><input type="submit" value="수정완료" class="primary" onclick="confirmModify();"/></li>
                                                        <li><input type="button" value="회원탈퇴"/></li>
                                                     </ul>
                                                </div>
                                            </div>
                                        </form>
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
												<li><a href="#">주문 조회</a></li>
												<li><a href="#">반품 조회</a></li>
												<li><a href="#">장바구니</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">나의 활동</span>
											<ul>
												<li><a href="#">나의 리뷰</a></li>
												<li><a href="#">북마크</a></li>
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
			</script>
			<script>
				function confirmModify() {
					var result2 = confirm("수정하시겠습니까?");
					if (result2) {
						alert("수정이 완료되었습니다."); 
					} else {
						alert("수정이 완료되지 않았습니다.");
					}
				}
			</script>
			<script>
				const fn_changePw=()=>{
					open("<%=request.getContextPath()%>/updateInfo.do?memberId=<%=loginMember.getMemberId()%>","_blank",","width=300, height=180");
				}
			</script>
	</body>
</html>