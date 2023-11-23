<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% ArrayList<Member> memberList = new ArrayList<>();
   memberList = m.selectMember();
%>  --%>
<%@ page import="com.veg.hjj.member.dto.*" %>
 <%@ page import="com.veg.ojy.mypage.dto.Address"%>
<%@ page import= "java.util.List,java.util.Arrays" %>
<%@ include file="/views/admin/common/header.jsp" %>


<%
    List<Member> members = (List<Member>)request.getAttribute("member");

   /*  Member loginMember = (Member)session.getAttribute("loginMember"); */
    List<Address> addresses = (List<Address>)request.getAttribute("address");
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
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
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
/* 			#sidebar {
				padding-top: 70px;
			} */
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
        .delivery-tb{
        width: 80%;
        margin: 0 auto;
      }

/*         .sort-btn:after {
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
        } */
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
							<!-- Section -->
								<section>
									  <header class="major">
										<h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">회원 관리</h1>
									<div class="card-body">
									<div class="datatable-wraooer datatable-loading no-footer sortable searchable fixed-colums"> 
									<div class="datable-top">
									<div class="datatable-dropdown">
									</div>
									</div>
									 </div>
									<div class="delivery-tb">
 									 <div class="col-2">
 									<form action='<%=request.getContextPath() %>/searchMember.do' method="post">
									 </div> 
									<div class="datatable-search col-12">
										<select name="searchKey" id="searchKey">
											<option value="test">- 선택 -</option>
											<option value="id">아이디</option>
											<option value="memberName">이름</option>
										</select><br>
									<input class="datatable-input" placeholder="회원조회" name="searchKeyword" title="search within table" 
									aria-controls="datatableSimple">
									<input type="submit" value="검색" class="primary" id="searchKey"/><br>
									</div><br><br>
									<div>
									</form>
									</div>
                                        <div class="table-wrapper">
                                            <table id="datatablesSimple">
                                                <thead>
                                                 <tr>
        											<th>아이디</th>
        											<th>이름</th>
       												<th>연령대</th>
        											<th>휴대폰번호</th>
        											<th>이메일</th>
        											<th>상세보기</th>
    											</tr>
                                                </thead>
                                                <tbody>                                               
                                                 <% 
                                        for (Member member : members) {
                                    %>
                                        <tr>
                                            <td><%= member.getMemberId() %></td>
                                            <td><%= member.getMemberName() %></td>
                                            <td><%= member.getMemberAge() %></td>
                                            <td><%= member.getMemberPhone() %></td>
                                            <td><%= member.getMemberEmail() %></td>
                                            <td>
                                                <a class="subBtn" href="<%=request.getContextPath()%>/memberUpdate.do?memberNo=<%=member.getMemberNo()%>">상세보기</a>
                                                <!-- <a class="subBtn" href="#">삭제</a> -->
                                            </td>
                                        </tr>
                                    <% } %>
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
			</div>
			</main>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/browser.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/breakpoints.min.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/util.js"></script>
			<script src="<%=request.getContextPath() %>/js/jyjs/js/main.js"></script>

			
			
 

	</body>
</html>  