<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css" />
		<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/open-iconic-bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/animate.css">
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/owl.carousel.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/owl.theme.default.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/magnific-popup.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/aos.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/ionicons.min.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/bootstrap-datepicker.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/jquery.timepicker.css">
	
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/flaticon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/icomoon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/style.css">
		<style>
			#sidebar {
				padding-top: 70px;
			}
            .contact-box {
                border: 1px solid #ccc; 
                padding: 15px; 
                border-radius: 8px; 
            }
            .modal {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                max-width: 600px; 
                width: 100%;
                max-height: 320px; 
                height: 100%;
                box-sizing: border-box;
                text-align: center;
            }
            .address-input {
                width: calc(100% - 20px); 
                padding: 10px;
                margin-bottom: 10px;
                box-sizing: border-box;
                width: 100%; 
            }
            .close {
                position: absolute;
                top: 10px;
                right: 10px;
                font-size: 20px;
                cursor: pointer;
            }
            h2, p {
                margin-bottom: 20px;
            }
            button {
                padding: 10px;
                background-color: white;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top:0px;
            }
			.form-group.row.justify-content-center { 
    			display: flex;
    			justify-content: center;
			}
			#query.address-input {
    			width: 100%; 
    			padding: 15px; 
    			box-sizing: border-box;
			} 
	
		</style>
			
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
										  <li class="nav-item"><a href="/mypage.html" class="nav-link">마이페이지</a></li>
										  <li class="nav-item cta cta-colored"><a href="/cart1.html" class="nav-link"><span href=""></span>[0]</a></li>
							
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
										<h2>배송지 정보</h2>
									</header>
									<div class="address">
                                        <div class="contact-box">
                                            <ul class="contact">
                                                <li class="icon solid fa-home" style="font-size: 20px;">경기도 안양시 oooooooooooooooooooooooo</li>
                                            </ul>
                                        </div>
                                        <br><br>
                                         <div class="col-12 d-flex justify-content-center">
                                            <ul class="actions">
                                                <li><input type="button" value="새 배송지 등록" class="primary" onclick="openModal()" /></li>
                                            </ul>
                                        </div>
                                        <div id="myModal" class="modal">
											<div class="modal-content">
												<span class="close" onclick="closeModal()">&times;</span>
													<h2>새 배송지 등록</h2>
												<div class="form-group row justify-content-center">
													<section id="search" class="alt">
														<form method="post" action="#">
															<input type="text" name="query" class="address-input" id="query" placeholder="주소검색" />
														</form>
													</section>
												</div>
												<div class="form-group row">
													<label for="demo-address" class="col-md-4 col-form-label">상세 주소</label>
														<div class="col-md-8">
															<input type="text" name="demo-address" class="form-control" id="demo-address" placeholder="건물명, 상세주소" >
														</div>
												</div>
												<div class="col-12 d-flex justify-content-center">
													<ul class="actions">
														<li><input type="button" value="등록하기" class="primary2" onclick="saveNewAddress()" /></li>
													</ul>
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
												<li><a href="/myreview.html">나의 리뷰</a></li>
												<li><a href="/bookmark.html">북마크</a></li>
												<li><a href="#">1:1문의</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">내 정보</span>
											<ul>
												<li><a href="/myinfo.html">내 정보 수정</a></li>
												<li><a href="/myaddress.html">배송지 관리</a></li>
											</ul>
										</li>
										<li><a onclick="confirmLogout()">로그아웃</a></li>
									</ul>
								</nav>

						</div>
					</div>
			</div>
			<script src="/js/jyjs/js/jquery.min.js"></script>
			<script src="/js/jyjs/js/browser.min.js"></script>
			<script src="/js/jyjs/js/breakpoints.min.js"></script>
			<script src="/js/jyjs/js/util.js"></script>
			<script src="/js/jyjs/js/main.js"></script>
            <script>
          
            function openModal() {
                 var modal = document.getElementById('myModal');
                    modal.style.display = 'block';
            }


            function closeModal() {
                var modal = document.getElementById('myModal');
                    modal.style.display = 'none';
            }


            function saveNewAddress() {
   
                alert('새 배송지가 저장되었습니다.');
                closeModal(); 
            }


            window.onclick = function(event) {
                var modal = document.getElementById('myModal');
                if (event.target === modal) {
                    closeModal();
                }
            };
		
			function confirmLogout() {
				var result = confirm("로그아웃 하시겠습니까?");
					if (result) {
						alert("로그아웃 되었습니다."); 
					} else {
						alert("로그아웃 취소되었습니다.");
					}
			}
            </script>
	</body>
</html>