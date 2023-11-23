<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="com.veg.ksj.admin.controller.AdminLogout" %>
<%@ page import="com.veg.hjj.member.dto.Member" %>
<%
    Member loginMember = (Member)session.getAttribute("loginMember");
    if (loginMember != null) {
        System.out.println(loginMember.getMemberNo());
    }
%>
<!DOCTYPE html>
<head>
    <title>채소랑</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
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

    <style>

     .navbar-nav {
         margin-top: 20px;
     }

    .navbar-nav .nav-item {
        margin-bottom: 10px;
    }

    .navbar-nav .cta-colored {
        margin-top: 20px;
    }

    .navbar-nav .btn-primary,
    .navbar-nav .btn-outline-secondary {
        margin-top: 10px;
        margin-bottom: 3px;
    }
     .navbar-nav .btn-info,
     .navbar-nav .btn-outline-secondary {
         margin-top: 10px;
         margin-bottom: 3px;
     }

    .navbar-nav .important-button {
        margin-top: 3px;
    }

    .navbar-nav span {
        margin-top: 3px;
    }


</style>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/main.do">
            <img src="<%=request.getContextPath() %>/images/brand_image (4).png" alt="브랜드 로고" style="max-width:70%">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <style>
            .navbar-nav {
                margin-top: 20px;
            }
        </style>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/productionList/vegfarm.do">채소농장</a></li>

                <li class="nav-item" style="list-style-type: none;"><a href="<%=request.getContextPath() %>/community/communitymain.do" class="nav-link">커뮤니티</a></li>

                <li class="nav-item" style="list-style-type: none;"><a href="<%=request.getContextPath() %>/inquiry/inquiryList.do" class="nav-link">고객센터</a></li>

                <li class="nav-item" style="list-style-type: none;"><a href="<%=request.getContextPath()%>/cart/cartList.do" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>

                <%if (loginMember == null) { %>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/member/login.do" class="nav-link">로그인</a></li>
                </li>
                <%} else {%>

                <div style="display: flex; flex-direction: column; margin-bottom: 10px; padding-bottom: 10px;">
                    <div style="display: flex; align-items: center; justify-content: space-between;">
                        <style>

                            .important-button:hover {
                                color: #28a745;
                            !important;
                            }
                        </style>
                        <button type="button" class="btn btn-primary btn-sm important-button"
                                onclick="location.replace('<%=request.getContextPath()%>/myInfo.do')"
                                style="padding: .6rem !important; font-size: .72rem !important; margin: 0 !important; color: white; !important;" onclick="location.replace('<%=request.getContextPath()%>/myInfo.do')">마이페이지</button>

                        <button type="button" class="btn btn-outline-secondary btn-sm important-button"
                                style="margin-left: 10px !important; padding: .6rem !important; font-size: .72rem !important; margin: 0 !important;" onclick="location.replace('<%=request.getContextPath()%>/loginout.do')">로그아웃</button>

                        <%if(loginMember.getAdminCheck().equals("Y")){%>

                            <button type="button" class="btn btn-info btn-sm"
                                    onclick="location.replace('<%=request.getContextPath()%>/admin/login.do')" width="60px;" style="font-size: 12px;">관리자페이지</button>
                        <%} %>

                    </div>
                    <div style="display: flex; align-items: center; justify-content: space-between; margin-top: 3px;">
        <span style="font-weight: bolder; margin-left: 10%; font-size: .88rem !important;">
            <%=loginMember.getMemberName() %>님 환영합니다.
        </span>
                    </div>
                </div>
                <%} %>
            </ul>
        </div>
    </div>
</nav>


<%--===============================================================================================================--%>

<style>


    .chat_on {
        position: fixed;
        z-index: 10;
        width: 45px;
        height: 45px;
        right: 15px;
        bottom: 20px;
        background-color: #fff;
        color: transparent;
        border-radius: 50%;
        text-align: center;
        padding: 9px;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12) !important;
        cursor: pointer;
        display: block;
    }



</style>


<%--===============================================================================================================--%>

<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.5.0/kakao.min.js"
        integrity="sha384-kYPsUbBPlktXsY6/oNHSUDZoTX6+YI51f63jCPEIPFP09ttByAdxd2mEjKuhdqn4" crossorigin="anonymous"></script>

<script>
    var CHANNEL_ID = "_VSnVG";
    Kakao.init('57b2e12ef40d490c62510e21fb88c185');
    console.log(Kakao.isInitialized());
</script>

<div class="container">
    <div class="row">

      <script>
          function addChannel() {
              Kakao.Channel.addChannel({
                  channelPublicId: '_GlIbG',
              });
          }
      </script>
                <a id="kakao-login-btn" href="javascript:addChannel()" >

                        <img src="https://cdn.imweb.me/thumbnail/20220403/a8e484f2dfe39.png"
                             alt="카카오 로그인 버튼"  class="chat_on" style="width:90px; height:90px;"/>


                </a>


        </div>
    </div>



<%--===============================================================================================================--%>

<%@ page
        import="java.util.List,com.veg.seoj.cscenter.model.dto.Inquiry,java.sql.Timestamp,java.text.SimpleDateFormat" %>
<%@ page import="com.veg.hjj.member.dto.Member" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.io.*" %>
<%@ page import="com.veg.seoj.cscenter.model.service.InquiryService" %>



    <%
    List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");
    List<Inquiry> inquiryListAndComments = (List<Inquiry>)request.getAttribute("inquiryListAndComments");
    int inquiryTotalData = (int)request.getAttribute("inquiryTotalData");

%>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>



<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css/main.css"/>
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/animate.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/magnific-popup.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/aos.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/ionicons.min.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/jquery.timepicker.css">


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/css/icomoon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjcss/css2/style.css">


<style>
    #sidebar {
        padding-top: 70px;
    }
</style>
<div class="container">
    <div class="row">
        <div id="sidebar">
            <div class="inner">
                <nav id="menu">
                    <header class="major">
                        <h2>1:1 문의</h2>
                    </header>
                    <ul>
                        <li>
                        <li>
                            <a href="<%=request.getContextPath()%>/inquiry/inquiryList.do" class="nav-link"
                               class="opener">1:1 문의</a>
                        </li>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

        <section id="board-container" style="margin-top: 130px; margin-bottom: 100px;">

            <script>
                $(document).ready(function() {

                    $(".type-button").click(function() {
                        var inquiryType = $(this).data("type");


                        $.ajax({
                            url: "서버에 대한 요청 URL",
                            type: "GET",
                            data: { inquiryType: inquiryType },
                            dataType: "json",
                            success: function(data) {

                                updateTable(data);
                            },
                            error: function(error) {
                                console.error("AJAX 요청 실패:", error);
                            }
                        });
                    });


                    function updateTable(data) {

                    }
                });
            </script>
            <%
                int inquiryCount = inquiryList.size();
            %>

            <h7 style="margin-right: 600px;">전체 글 수      <%=inquiryTotalData%>

            </h7>

            <table id="tbl-board">
                <tr>
<%--                    <button class="type-button" data-type="상품" class="btn btn-primary btn-sm">상품</button>
                    <button class="type-button" data-type="미설정" class="btn btn-primary btn-sm">미설정</button>
                    <button class="type-button" data-type="주문" class="btn btn-primary btn-sm">주문</button>--%>
                    <th>번호</th>
                    <th>문의 타입</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>

                </tr>
                <tr>
                    <%

                        if (!inquiryList.isEmpty()) {

                            for (Inquiry n : inquiryList) {
                    %>
                    <td><%=n.getInquiryNo()%>
                    </td>
                    <td>
                        <%=n.getInquiryType()%>

                    </td>
                    <td>
                        <a href="<%=request.getContextPath()%>/inquiry/inquiryView.do?no=<%=n.getInquiryNo()%>">
                            <%=n.getInquiryTitle()%>
                        </a>
                    </td>
                    <td>

                        <%=n.getMemberName()%>
                    </td>
                    <td>
                        <%
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String sdfResult = sdf.format(n.getInquiryDate());
                        %>
                        <%=sdfResult%>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>

            <div id="pageBar" style="margin-left: 300px;"><a>

                    <%=request.getAttribute("pageBar")%>

            </div>
            <div class="col-md-4">

                <%if (loginMember != null) {%>
                <span>
							<button onclick="location.assign('<%=request.getContextPath()%>/inquiry/inquiryWrite.do')"
                                    style="margin-left: 600px;" class="btn btn-primary">
				글쓰기
			</button>

					</span>
                <%}%>


            </div>
        </section>

    </div>
</div>

<%@ include file="/views/common/footer.jsp" %>