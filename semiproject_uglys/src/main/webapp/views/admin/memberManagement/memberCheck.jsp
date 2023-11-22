<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Member> memberList = new ArrayList<>();
   memberList = m.selectMember();
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
               .sort-btn {
            cursor: pointer;
            display: flex;
            align-items: center;
        }

        .sort-btn:after {
            content: '';
            width: 0;
            height: 0;
            margin-left: 5px;
            border-left: 5px solid transparent;
            border-right: 5px solid transparent;
        }

        .asc:after {
            border-bottom: 5px solid #000;
        }

        .desc:after {
            border-top: 5px solid #000;
        }
		</style>
		<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
										<h2>회원조회</h2>
									</header>
									<div class="card-body">
									<div class="datatable-wraooer datatable-loading no-footer sortable searchable fixed-colums">
									<div class="datable-top">
									<div class="datatable-dropdown">
									<div class="datatable-search">
									<input class="datatable-input" placeholder="회원조회" type="search" title="search within table" 
									aria-controls="datatableSimple">
									</div>
									</div>
									</div>
									</div>
									</div>
									<div class="features">
                                        <div class="table-wrapper">
                                            <table>
                                                <thead>
                                                 <tr>
        											<th><a href="#" class="sort-btn" data-sort="id">아이디</a></th>
        											<th><a href="#" class="sort-btn" data-sort="name">이름</a></th>
       												<th><a href="#" class="sort-btn" data-sort="age">연령대</a></th>
        											<th><a href="#" class="sort-btn" data-sort="phone">휴대폰번호</a></th>
        											<th><a href="#" class="sort-btn" data-sort="email">이메일</a></th>
        											<th><a href="#" class="sort-btn" data-sort="address">주소</a></th>
        											<th>수정/삭제</th>
    											</tr>
                                                </thead>
                                                <tbody>
                                                    <!-- <tr> -->
                                                <!--         <td>qwer</td>
                                                        <td>김유저</td>
                                                        <td>10</td>
                                                        <td>01012345678</td>
                                                        <td>이메일입니당</td>
                                                        <td>서울시</td>
                                                        <td>
                                                            <a class="subBtn" href="#">
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                    <tr>
                                                        <td>wwer</td>
                                                        <td>이유저</td>
                                                        <td>20</td>
                                                        <td>01012345678</td>
                                                        <td>2이메일입니당</td>
                                                        <td>경기도</td>
                                                        <td>
                                                            <a class="subBtn" href="#">
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                    <tr>
                                                        <td>ewer</td>
                                                        <td>박유저</td>
                                                        <td>40</td>
                                                        <td>01012345678</td>
                                                        <td>5이메일입니당</td>
                                                        <td>경상도</td>
                                                        <td>
                                                            <a class="subBtn" href="#">
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                    <tr>
                                                        <td>yqwer</td>
                                                        <td>최유저</td>
                                                        <td>30</td>
                                                        <td>01012345678</td>
                                                        <td>7이메일입니당</td>
                                                        <td>강원도</td>
                                                        <td>
                                                            <a class="subBtn" href="#">
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                    <tr>
                                                        <td>quuwer</td>
                                                        <td>이유저</td>
                                                        <td>60</td>
                                                        <td>01012345678</td>
                                                        <td>이메일입니당</td>
                                                        <td>전라도</td>
                                                        <td>
                                                            <a class="subBtn" href="#">
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                    <tr>
                                                        <td>oer</td>
                                                        <td>한유저</td>
                                                        <td>50</td>
                                                        <td>01012345678</td>
                                                        <td>9이메일입니당</td>
                                                        <td>서울시</td> -->
                                                     <%
														for(Member m : MemberList){
													%>
											<tr>
												<td>
													<%=m.getMemberId()%>
												</td>
												<td>
													<%=m.getMemberName()%>
												</td>
												<td>
													<%=m.getMemberAge()%>
												</td>
												<td>
													<%=m.getMemberPhone()%>
												</td>
												<td>
													<%=m.getMemberEmail()%>
												</td>
												<td>
													<%=m.getAddress()%>
												</td>
													<td>
                                                            <a class="subBtn" href="<%=request.getContextPath()%>/views/admin/memberManagement/memberModify.jsp?memberId=<%=m.getMemberId()%>'>
                                                                수정
                                                            </a>
                                                            <a class="subBtn" href="#">
                                                                삭제
                                                            </a>
                                                        </td>
                                                       
                                                    </tr>
                                                </tbody>
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
										<h2>회원조회</h2>
									</header>
									<ul>
										<li>
											<span class="opener">회원조회</span>
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
<!-- 			<script>
    $(document).ready(function () {
        $('.sort-btn').on('click', function () {
            var sortBy = $(this).data('sort');
            sortTable(sortBy);
        });

        function sortTable(sortBy) {
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.querySelector('table');
            switching = true;

            while (switching) {
                switching = false;
                rows = table.rows;

                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;

                    x = rows[i].querySelector('td[data-sort="' + sortBy + '"]');
                    y = rows[i + 1].querySelector('td[data-sort="' + sortBy + '"]');

                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                }

                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                }
            }

            toggleArrow(sortBy);
        }

        function toggleArrow(sortBy) {
            var currentArrow = $('th[data-sort="' + sortBy + '"]');

            if (currentArrow.hasClass('asc')) {
                currentArrow.removeClass('asc').addClass('desc');
            } else {
                currentArrow.removeClass('desc').addClass('asc');
            }

            // 다른 열의 화살표를 초기화
            $('th[data-sort]').not(currentArrow).removeClass('asc desc');
        }
    });
</script> -->

	</body>
</html>  --%>