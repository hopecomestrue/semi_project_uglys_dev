<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Order o=(Order)request.getAttribute("order");
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
				/* top: 80px; */
			}
			
			.order-detail{
				text-align: center;
			}
		/* 	  table {
		        margin-left: auto;
		        margin-right: auto;
    		} */
    		
    		.features1{
    		margin-left: auto;
		        margin-right: auto;
    			text-align:center;
    			width : 70%;
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
						<a class="navbar-brand" href="index.html"></a>
						<!-- 메인화면으로 이동 // 주소바꾸기 -->
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
				  </button>
					 <div class="collapse navbar-collapse" id="ftco-nav">
						<ul class="navbar-nav ml-auto">
		  <li class="nav-item"><a href="<%=request.getContextPath()%>/main.do" class="nav-link">Home</a></li>
		<li class="nav-item"><a href="<%=request.getContextPath()%>/productionList/vegfarm.do" class="nav-link">채소농장</a></li>
	  <li class="nav-item"><a href="<%=request.getContextPath() %>/community/communitymain.do" class="nav-link">커뮤니티</a></li>
			<li class="nav-item"><a href="<%=request.getContextPath() %>/notice/noticeList.do"" class="nav-link">고객센터</a></li>
			 <li class="nav-item"><a href="<%=request.getContextPath() %>/myInfo.do" class="nav-link">마이페이지</a></li>
				<!--  <li class="nav-item cta cta-colored"><a href="cart1.html" class="nav-link"><span href=""></span>[0]</a></li> -->
	</ul>
	</div>
	</div>
	</nav>
	</header>  
		<!-- Banner -->
	<section id="banner">
	<div class="content">
	<header>
		<h2>마이페이지</h2>
	</header>
	</div>
		</section>
	<!-- Section -->
	<div class="order-detail">
		<section>
			<header class="major">
				<h2>상세 주문 내역</h2>
			</header>
				<!-- <form action="" method="post"> -->
					<input type="hidden" id="orderNo" value="<%=o.getOrderNo()%>">
					<div class="features1">
						<article>
							<div class="content">
								<table>
									<tr>
										<td>주문날짜</td>
										<td><%=o.getOrderDate() %></td>
									</tr>
									<tr>
										<td>주문번호</td>
										<td><%=o.getOrderNo() %></td>
									</tr>
									<tr>
										<td>주문금액</td>
										<td><%=o.getTotalPrice() %></td>
									</tr>
									<tr>
										<td>이미지</td>
										<td><img src="/images2/product-5.jpg" style="width: 100px; height: 100px;"></td>
									</tr>
									<tr>
										<td>주문상태</td>
										<td><%=o.getOrderStatus() %></td>
									</tr>
									<tr>
										<td>환불신청</td>
										<td><button type="submit" onclick="refund_btn()">환불요청</button></td>
									</tr>
								</table>
								</div>
							</article>
						</div>
					<!-- </form> -->
				</section>
			</div>
			</div>
		</div>
	</div>
</body>
	<script>
		function refund_btn(){
			var result = confirm("환불 하시겠습니까?");
			if (result == false) {
			    return;
			  }
			
			var orderNo=document.getElementById('orderNo').value;
			
			console.log(orderNo);
			
			$.ajax({
				url : '<%=request.getContextPath()%>/myinfo/refund.do',
				type : 'post',
				dataType : 'json',
				data : {
					orderNo : orderNo
				},
				success:function(res){
					alert('환불 요청성공');
				},
				error:function(err){
					alert('환불 요청실패');
				}
			});
		}
	</script>


<script src="<%=request.getContextPath() %>/js/jyjs/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/browser.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/breakpoints.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/util.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/main.js"></script>

<%@ include file="/views/common/footer.jsp" %>