<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
  	<script src="/docs/5.3/assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.118.2">
    <title>Headers · Bootstrap v5.3</title>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    
    

<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }

      .bd-mode-toggle {
        z-index: 1500;
      }

      .bd-mode-toggle .dropdown-menu .active .bi {
        display: block !important;
      }
      
      .admin-title{
        color: black;
        text-decoration: none;
      }

      .search_3{
        align-items: center;
        display: flex;
        justify-content: right;
        margin-right: 10%;
      }

      #delivery-check{
        width: 18%;
        margin-left: 70%;
        margin-bottom: 3%;
      }

      .delivery-tb{
        width: 80%;
        margin: 0 auto;
      }

      .delivery-paging{
        margin: 5%;
      }
      
    </style>
<body>
  <div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-3 mb-2 mb-md-0">
        <a href="<%=request.getContextPath()%>/admin/main.do" class="d-inline-flex link-body-emphasis text-decoration-none">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3YIR4yyeQgs9tgIWXuAH7AmYGRNHCQ8ZJ-Q&usqp=CAU" width="40" height="32">
        </a>
      </div>
      <h1><a href="<%=request.getContextPath()%>/admin/main.do" class="admin-title">채소랑 어드민</a></h1>

      <div class="col-md-3 text-end">
        <span>관리자님, 환영합니다</span>
        <button type="button" class="btn btn-primary" onclick="location.replace('<%=request.getContextPath()%>/admin/logout.do')">로그아웃</button>
      </div>
</header>
  </div>

<!-- 상단 메뉴 -->
	<div class="container text-center">
	    <div class="row align-items-center">
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="#">회원관리</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="#">상품등록</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="<%=request.getContextPath()%>/admin/deliveryList.do">주문현황</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="<%=request.getContextPath()%>/admin/refundList.do">환불관리</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="#">고객센터</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="#">후기관리</a>
	      </div>
	      <div class="col">
	        <a class="dropdown-item rounded-2" href="#">레시피관리</a>
	      </div>
	    </div>
  </div>