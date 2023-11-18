<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.veg.pdw.production.model.dto.Production" %>

<%
	List<Production>productions=(List<Production>)request.getAttribute("productions");
	
%>
<!DOCTYPE html>

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
            
            
			.datatable-input {
			    display: inline-block;
			    width: 80%;
			    padding: 10px;
			    margin-bottom: 10px;
			    font-size: 16px;
			    border: 1px solid #ccc;
			    border-radius: 4px;
			}
			
			button {
			    display: block;	    
			    padding: 10px;
			    font-size: 16px;
			    color: white;
			    background-color: #C8f498;
			    border: none;
			    border-radius: 4px;
			    cursor: pointer;
			    width: 100%;
			}
			
			button:hover {
			    background-color: #45a000;
			}
			
			table {
			    width: 100%;
			}
			
			td {
			    padding: 10px;
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
										  <li class="nav-item"><a href="/mypage.html" class="nav-link">관리자페이지</a></li>
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
											<h2>관리자페이지<br />
											</h2>
										</header>
									</div>
								</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>상품관리</h2>
				</header>
				<div class="card-body">

				    <div class="datatable-wraooer datatable-loading no-footer sortable searchable fixed-colums">
				        <div class="datable-top">
				            <div class="datatable-dropdown">
				                <div class="datatable-search">
				                   <!-- 새로운 입력 필드 -->
				                   <table>
                        <tr>
                            <td>등록일</td>
                            <td><input class="datatable-input" type="date"></td>
                            <td>~</td>
                            <td><input class="datatable-input" type="date"></td>
                        </tr>
                        <tr>
                            <td>상품번호:</td>
                            <td><input class="datatable-input" type="text"></td>
                            <td>상품명:</td>
                            <td><input class="datatable-input" type="text"></td>
                        </tr>
                        <tr>
                            <td>가격:</td>
                            <td><input class="datatable-input" type="number"></td>
                            <td>~</td>
                            <td><input class="datatable-input" type="number"></td>
                        </tr>
                        <tr>
                            <td>재고:</td>
                            <td><input class="datatable-input" type="text"></td>
                            <td>~</td>
                            <td><input class="datatable-input" type="number"></td>
                        </tr>
                        <tr>
                            <td>생산지:</td>
                            <td><input class="datatable-input" type="text"></td>
                        </tr>
                        
                    	</table>
				         <div><button type="submit" style="margin-bottom: 30px; margin-top: 30px;">검색</button></div>
    <div style="display: flex; justify-content: flex-end; align-items: center;">
    <a href="<%=request.getContextPath() %>/admin/productregi.do">
    <button style="margin-right: 10px; padding: 5px 10px; margin-bottom: 30px;">상품등록</button>
	</a>

    <button type="submit" style="margin-right: 10px; padding: 5px 10px; margin-bottom: 30px;">상품삭제</button>
    
</div>
				            </div>
				        </div>
				    </div>
				</div>
				<div class="features">
                    <div class="table-wrapper">
                      <table >
                          <thead>
                              <tr>
                                  <th></th>
                                  <th>번호</th>
                                  <th>상품고유번호</th>
                                  <th>상품명</th>
                                  <th>상품종류</th>
                                  <th>가격</th>
                                  <th>재고</th>
                                  <th>생산지</th>
                                  <th>등록일</th>
                              </tr>
                          </thead>
                          <tbody>
                           <tbody>
                           	<%if(productions!=null&&!productions.isEmpty()){ %>
					        	<%for(Production p : productions){%>      
					        		<tr>
							            <td><input type="checkbox" style="opacity: 1; -webkit-appearance: checkbox; -moz-appearance: checkbox; appearance: checkbox;"></td>
							            <td><%=p.getProduction_no()%></td>
							            <td><%=p.getProduction_name()%></td>
							            <td><%=p.getEnvironment()%></td>
							            <td><%=p.getPrice()%></td>
							            <td><%=p.getStock()%></td>
							            <td><%=p.getPrice()%></td>
							            <td><%=p.getProduction_date()%></td>
							        </tr>
					       			<% }
					       			 }
					        
					       			 %>
					        
					        
					    </tbody>        
                        
                                                
                        </table>
                                        </div>
									</div>
									<ul style="display: flex; justify-content: center;">
                                    <%=request.getAttribute("pageBar") %>
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
										<h2>상품관리</h2>
									</header>
									<ul>
										<li>
											<span class="opener">상품관리</span>
											<ul>
												<li><a href="<%=request.getContextPath() %>/admin/productregi.do">상품등록</a></li>
												<li><a href="#">상품삭제</a></li>
												
											</ul>
										</li>
										<li>
											<span class="opener">회원관리</span>
											<ul>
												<li><a href="#">나의 리뷰</a></li>
												<li><a href="#">북마크</a></li>
												<li><a href="#">1:1문의</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">커뮤니티</span>
											<ul>
												<li><a href="#">내 정보 수정</a></li>
												<li><a href="#">배송지 관리</a></li>
											</ul>
										</li>
										
										<li>
											<span class="opener">고객센터</span>
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
		window.onload = function() {
   	 		let checkboxes = document.querySelectorAll("input[type=checkbox]");
    		for (let i = 0; i < checkboxes.length; i++) {
        	checkboxes[i].addEventListener('change', function() {
            if (this.checked) {
                console.log('체크박스 ' + (i + 1) + '번이 선택되었습니다.');
            } else {
                console.log('체크박스 ' + (i + 1) + '번 선택이 해제되었습니다.');
            }
        });
    }
}
</script>
	</body>
</html>