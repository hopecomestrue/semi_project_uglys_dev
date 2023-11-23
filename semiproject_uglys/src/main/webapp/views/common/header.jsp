<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.ksj.admin.controller.AdminLogout"%>
<%@ page import="com.veg.hjj.member.dto.Member" %>
<%
	Member loginMember=(Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
 <head>
    <title>채소랑</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/animate.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/magnific-popup.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/aos.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/ionicons.min.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/icomoon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
    <script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
  </head>
  <body class="goto-here">
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="<%=request.getContextPath()%>/main.do">
	      <img src="<%=request.getContextPath() %>/images/brand_image (4).png" alt="브랜드 로고" style="max-width:70%" >
	      </a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

			<div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"></li>
	          <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/productionList/vegfarm.do">채소농장</a></li>

	          <li class="nav-item" style="list-style-type: none;"><a href="<%=request.getContextPath() %>/community/communitymain.do" class="nav-link">커뮤니티</a></li>
	          
	          <li class="nav-item" style="list-style-type: none;"><a href="<%=request.getContextPath() %>/inquiry/inquiryList.do"" class="nav-link">고객센터</a></li>
	          
	          <%if(loginMember==null){ %>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/member/login.do" class="nav-link">로그인</a></li>
	         <%} else{%>
	         	<table>
	         		<tr>
	         			<td colspan="2">
	         				<span style="font-weight: bolder; margin-left: 10%;"><%=loginMember.getMemberName() %></span>님 환영합니다.
	         			</td>
	         		</tr>
	         		<tr>
	         			<td><button type="button" class="btn btn-primary" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;"
	         				onclick="location.replace('<%=request.getContextPath()%>/myInfo.do')">마이페이지</button></td>
	         			<td><button type="button" class="btn btn-outline-dark" onclick="location.replace('<%=request.getContextPath()%>/loginout.do');">로그아웃</button></td>
	         		</tr>
	         	</table>
	         		<%if(loginMember.getAdminCheck().equals("Y")){%>
	         		<div style="margin-top:4%;">
	         		<button type="button" class="btn btn-info" 
	         		onclick="location.replace('<%=request.getContextPath()%>/admin/login.do')">관리자페이지</button>
	         		</div>
	         		<%} %>
	         <%} %>
	        </ul>
	    	</div>
	    </div>
	  </nav>
