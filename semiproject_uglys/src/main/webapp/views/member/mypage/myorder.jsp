<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
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
            .table-wrapper table {
                width: 100%;
                margin: 0 auto;
                table-layout: fixed;
            }

            .table-wrapper table td {
                word-break: break-all;
                padding: 15px; 
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
										<h2>주문 조회</h2>
									</header>
									<div class="features">
                                        <div class="table-wrapper">
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th>상품명</th>
                                                        <th>상세 설명</th>
                                                        <th>수량</th>
                                                        <th>가격</th>
														<th>배송상태</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
                                                        <td>친환경 절임배추</td>
                                                        <td>1개</td>
                                                        <td>29,900원</td>
														<td>
															<tr>
																<td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
																<td>친환경 절임배추</td>
																<td>1개</td>
																<td>29,900원</td>
<%-- 																<td class="p-price first-row">
																<%switch((Integer)m.get("orderStatus")){
																	case 0:
																		out.print("결제 미완료");
																		break;
		
																	case 1:
																		out.print("결제 완료");
																		break;
																	case 2:
																		out.print("배송 중");
																		break;
																	case 3:
																		out.print("배송 완료");
																		break;
																	case 4:
																		out.print("구매 확정");
																		break;
																	case 5:
																		out.print("주문 취소");
																		break;
																	}
																%></td>  --%>
																
															</tr>
														</td>
                                                    </tr>
                                                    <tr>
                                                        <td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
                                                        <td>친환경 절임배추</td>
                                                        <td>1개</td>
                                                        <td>29,900원</td>
                                                    </tr>
                                                    <tr>
                                                        <td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
                                                        <td>친환경 절임배추</td>
                                                        <td>1개</td>
                                                        <td>29,900원</td>
                                                    </tr>
                                                    <tr>
                                                        <td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
                                                        <td>친환경 절임배추</td>
                                                        <td>1개</td>
                                                        <td>29,900원</td>
                                                    </tr>
                                                    <tr>
                                                        <td><img src="/images2/product-5.jpg" style="width: 200px; height: 200px;"></td>
                                                        <td>친환경 절임배추입니다아아아아앙ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ아아아앙아아앙ㅇ</td>
                                                        <td>1개</td>
                                                        <td>29,900원</td>
                                                    </tr>
                                                </tbody>
                                                <!-- <tfoot>
                                                    <tr>
                                                        <td colspan="2"></td>
                                                        <td>100.00</td>
                                                    </tr>
                                                </tfoot> -->
                                            </table>
                                        </div>
									</div>
                                    <ul class="pagination justify-content-center" >
                                        <li><span class="button disabled">Prev</span></li>
                                        <li><a href="#" class="page active">1</a></li>
                                        <li><a href="#" class="page">2</a></li>
                                        <li><a href="#" class="page">3</a></li>
                                        <li><span>&hellip;</span></li>
                                        <li><a href="#" class="page">8</a></li>
                                        <li><a href="#" class="page">9</a></li>
                                        <li><a href="#" class="page">10</a></li>
                                        <li><a href="#" class="button">Next</a></li>
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
											</ul>
										</li>
										<li>
											<span class="opener">내 정보</span>
											<ul>
												<li><a href="/myinfo.html">내 정보 수정</a></li>
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
	</body>
</html>