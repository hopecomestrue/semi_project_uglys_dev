<%@page import="com.veg.ojy.cart.dto.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%
	List<Cart> carts=(List<Cart>)request.getSession().getAttribute("carts");
%>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/open-iconic-bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/animate.css">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/owl.theme.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/magnific-popup.css">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/aos.css">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/ionicons.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/jquery.timepicker.css">


<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/icomoon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jycss/css2/style.css">

</head>
<body class="goto-here">
	<div class="py-1 bg-primary">
		<div class="container"></div>
	</div>

<!-- 	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.html">채소랑</a>
			메인화면으로 이동 // 주소바꾸기
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="#" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="#" class="nav-link">채소농장</a></li>
					<li class="nav-item"><a href="#" class="nav-link">커뮤니티</a></li>
					<li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
					<li class="nav-item"><a href="mypage.html" class="nav-link">마이페이지</a></li>
					<li class="nav-item cta cta-colored"><a href="cart1.html"
						class="nav-link"><span href=""></span>[0]</a></li>

				</ul>
			</div>
		</div>
	</nav> -->

	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>상품명</th>
									<th>가격</th>
									<th>수량</th>
									<th>총금액</th>
								</tr>
							</thead>
							<%if(!carts.isEmpty()){
								for(Cart c : carts){%>
							<tbody>
<%-- 							<% int sum =0;
							ArrayList<Cart> cartlist =(ArrayList<Cart>) session.getAttribute("cartList");
							for(int i = 0; i < cartlist.size(); i++){
										Cart cart = cartlist.get(i);
										sum += cart.getTotalPrice();}%> --%>
								<tr class="text-center">
									<td class="product-remove"><a href="#"><span
											class="ion-ios-close"></span></a></td>

									<td class="image-prod"><div class="img"
											style="background-image: url(images2/product-3.jpg);"></div></td>

									<td class="product-name">
										<h3><%-- <%=c.get %> --%></h3>
										<p>Far far away, behind the word mountains, far from the
											countries</p>
									</td>

									<td class="price">39,900원</td>

									<td class="qua-col first-row">
										<div class="pro-qty">
											<span class="dec qtybtn">-</span> <input name="cartCnt"
												class="cartQty" id="cartQty" value="1" type="text"
												style="width: 100px;"> <span class="inc qtybtn">+</span>
										</div>
									</td>
									<td class="total">39,900원</td>
								</tr>

								<tr class="text-center">
									<td class="product-remove"><a href="#"><span
											class="ion-ios-close"></span></a></td>

									<td class="image-prod"><div class="img"
											style="background-image: url(images2/product-4.jpg);"></div></td>

									<td class="product-name">
										<h3>고구마 3kg</h3>
										<p>Far far away, behind the word mountains, far from the
											countries</p>
									</td>

									<td class="price">29,900원</td>

									<td class="qua-col first-row">
										<div class="pro-qty">
											<span class="dec qtybtn">-</span> <input name="cartCnt"
												class="cartQty" id="cartQty" value="1" type="text"
												style="width: 100px;"> <span class="inc qtybtn">+</span>
										</div>
									</td>

									<td class="total">29,900원</td>
								</tr>
							</tbody>
							<%}
								}%>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-end" align="right">
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>장바구니 총 결제 금액</h3>
						<p class="d-flex total-price">
							<span>상품금액</span> <span>0원</span>
						</p>
						<!-- <p class="d-flex">
							<span>배송비</span> <span>0원</span>
						</p> -->
						<p class="d-flex">
							<span>할인금액</span> <span>0원</span>
						</p>
						<hr>
						<p class="d-flex total-price">
							<span>총 금액</span> <span>0원</span>
						</p>
					</div>
					<p>
						<a href="#" class="btn btn-primary py-3 px-4">주문하기</a>
					</p>
				</div>
			</div>
		</div>
	</section>


	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery-migrate-3.0.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/popper.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.easing.1.3.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.waypoints.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.stellar.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/owl.carousel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.magnific-popup.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/aos.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/jquery.animateNumber.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/bootstrap-datepicker.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/scrollax.min.js"></script>
	<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/google-map.js"></script>
	<script src="<%=request.getContextPath() %>/js/jyjs/js2/main.js"></script>
	<script>
    $(document).ready(function(){
        $('.qtybtn').click(function(e){
            e.preventDefault();
            var inputField = $(this).siblings('.cartQty');
            var quantity = parseInt(inputField.val());
            var priceField = $(this).closest('tr').find('.price');
            var price = parseInt(priceField.text().replace('원', '').replace(',', ''));
            var totalField = $(this).closest('tr').find('.total');

            if ($(this).hasClass('inc')) {
                // 수량 증가 버튼이 클릭된 경우
                inputField.val(quantity + 1);
            } else if ($(this).hasClass('dec') && quantity > 1) {
                // 수량 감소 버튼이 클릭된 경우 (수량은 1 미만으로 떨어지지 않도록)
                inputField.val(quantity - 1);
            }

            // 상품 총 금액 계산 및 업데이트
            var totalPrice = price * parseInt(inputField.val());
            totalField.text(addCommas(totalPrice) + '원');

            // 전체 총 합계 금액 업데이트
            updateTotalAmount();
        });

        function updateTotalAmount() {
            var totalAmount = 0;

            // 각 행의 총 금액을 가져와서 합산
            $('.total').each(function() {
                totalAmount += parseInt($(this).text().replace('원', '').replace(',', ''));
            });

            // 합산된 금액을 총 합계 영역에 업데이트
            $('.total-price span:last-child').text(addCommas(totalAmount) + '원');
        }

        // 숫자에 천 단위로 콤마 추가하는 함수
        function addCommas(num) {
            return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }
    });
</script>
