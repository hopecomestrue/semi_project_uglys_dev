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
                
                <li class="nav-item"><a class="nav-link" href="index.html">채소농장</a></li>

                <li class="nav-item" style="list-style-type: none;"><a
                        href="<%=request.getContextPath() %>/community/communitymain.do" class="nav-link">커뮤니티</a></li>

                <li class="nav-item" style="list-style-type: none;"><a
                        href="<%=request.getContextPath() %>/notice/noticeList.do" class="nav-link">고객센터</a></li>

                <li class="nav-item" style="list-style-type: none;"><a href="cart.html"
                                                                       class="nav-link"><span
                        class="icon-shopping_cart"></span>[0]</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <%if (loginMember == null) { %>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/member/login.do" class="nav-link">로그인</a>
                </li>
                <%} else {%>


                <div style="display: flex; flex-direction: column; margin-bottom: 10px; padding-bottom: 10px;">
                    <div style="display: flex; align-items: center; justify-content: space-between;">

                        <button type="button" class="btn btn-primary btn-sm important-button"
                                onclick="location.replace('<%=request.getContextPath()%>/myInfo.do')"
                                style="padding: .6rem !important; font-size: .72rem !important; margin: 0 !important; color: white; !important;">
                            마이페이지
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;

                        <button type="button" class="btn btn-outline-secondary btn-sm important-button"
                                style="margin-left: 10px !important; padding: .6rem !important; font-size: .72rem !important; margin: 0 !important;">
                            로그아웃
                        </button>
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
    <%
    List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");
%>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css/main.css"/>
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/animate.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/magnific-popup.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/aos.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/ionicons.min.css">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/jquery.timepicker.css">


<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/css/icomoon.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sjcss/css2/style.css">

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
                            <span class="opener">공지사항</span>
                        </li>
                        <li>
                            <span class="opener">자주 묻는 질문</span>

                        </li>
                        <li>

                            <a href="<%=request.getContextPath() %>/inquiry/inquiryList.do" class="nav-link"
                               class="opener">1:1 문의</a>

                        </li>

                        <li>
                            <span class="opener">고객의 소리(x)</span>
                        </li>
                    </ul>
                </nav>

            </div>
        </div>
        <section id='board-container'
                 style='margin: 0 auto; max-width: 80%; margin: 0 auto; text-align: center;'>
            <style>
                #board-container {
                    padding-top: 100px;
                    padding-bottom: 100px;
                    text-align: center;
                }
            </style>
            <h7 style="margin-right: 600px;">1:1 문의 작성</h7>

            <script>
                $(document).ready(function () {

                    $("#upfile2").change(function (e) {
                        $("#prevImg").empty();

                        previewImages(e.target.files);
                    });


                    function previewImages(files) {
                        $.each(files, function (i, file) {
                            const filereader = new FileReader();
                            filereader.readAsDataURL(file);
                            filereader.onload = (e) => {
                                const path = e.target.result;
                                const img = $("<img>").attr({
                                    "src": path,
                                    "width": "100",
                                    "height": "100"
                                });
                                $("#prevImg").append(img);
                            }
                        });
                    }
                });

            </script>
            <style>
                #tbl-board {
                    width: 100%;
                }

                #tbl-board th,
                #tbl-board td {
                    padding: 8px;
                }

                #tbl-board td[name="category_value"] {
                    width: 100%;
                }

                #tbl-board th:first-child,
                #tbl-board td:first-child {
                    text-align: right;
                    width: 20%;
                }

                #tbl-board th:last-child,
                #tbl-board td:last-child {
                    text-align: left;
                }

                #tbl-board th[colspan="2"] {
                    text-align: center;
                }

                button,
                input[type="submit"] {
                    color: white;
                !important;
                    background-color: #28a745;
                    border-color: #28a745;

                    transition: color 0.3s, background-color 0.3s;
                }

                button:hover,
                input[type="submit"]:hover {
                    color: #28a745;
                    background-color: transparent;
                    border-color: transparent;
                }
            </style>
            <form action='<%=request.getContextPath()%>/inquiry/inquiryWriteEnd.do'
                  enctype="multipart/form-data" method="post" id="uploadForm">
                <%
                    System.out.println("loginMember : " + loginMember.getMemberNo());
                %>
                <input type="hidden" name="memberNo" value="<%=loginMember.getMemberNo()%>">
                <input type="hidden" name="orderNo">
                <input type="hidden" name="productNo">
                <input type="hidden" name="memberName" value="<%=loginMember.getMemberName()%>">
                <input type="hidden" name="totalPrice">
                <input type="hidden" name="orderStatus">
                <input type="hidden" name="productionName">
                <input type="hidden" name="productImg">
                <input type="hidden" name="refundNo">
                <input type="date" name="refundDate" style="display: none;">
                <table id='tbl-board'>
                    <th>카테고리</th>

                    <td>
                        <select name="category" onchange="getCategoryValue(this)"
                                style="border: 1px solid #E0EDA2 !important;">
                            <option value="미설정">미설정</option>
                            <option value="배송">배송</option>
                            <option value="주문">주문</option>
                            <option value="상품">상품</option>
                            <option value="환불">환불</option>
                            <option value="기타">기타</option>
                        </select>
                    </td>

                    <tr>
                        <th></th>

                        <td name="category_value">미설정</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" name="title" required style="border: 1px solid #E0EDA2 !important;"></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input type="text" name="writer" value="<%=loginMember.getMemberName()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>첨부 이미지</th>
                        <td>
                            <style>
                                #upfile2,
                                #prevImg {
                                    display: inline-block;
                                }
                            </style>
                            <div id="prevImg">
                            </div>
                            <input type="file" name="upfile2" id="upfile2" accept="image/*">

                        </td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea cols="47" rows="10" name="content" style="resize: none;" required
                                      style="border: 1px solid #E0EDA2"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="저장" class="btn btn-sm btn-primary" justify-content: flex-end;>
                            <input type="reset" value="취소" class="btn btn-sm btn-primary" justify-content: flex-end;>
                        </th>
                    </tr>
                </table>
                <script>
                    function getCategoryValue(selectElement) {
                        var selectedCategory = selectElement.value;
                        var categoryValueTd = document.querySelector('td[name="category_value"]');


                        if (selectedCategory == '배송' || selectedCategory == '주문') {
                            categoryValueTd.innerHTML = '주문/배송목록 db';
                        } else if (selectedCategory == '상품') {
                            categoryValueTd.innerHTML = '상품목록 db';
                        } else if (selectedCategory == '환불') {
                            categoryValueTd.innerHTML = '환불목록 db';
                        } else {
                            categoryValueTd.innerHTML = '미설정';
                        }
                    }
                </script>
            </form>


        </section>
    </div>
</div>

<%@ include file="/views/common/footer.jsp" %>