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
                                    onclick="location.replace('<%=request.getContextPath()%>/admin/login.do')" style="font-size: 12px;">관리자페이지</button>

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
<%@ page import="com.veg.seoj.cscenter.model.dto.InquiryComment" %>
<%@ page import="com.veg.hjj.member.dto.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.veg.ksj.order.model.dto.Order" %>
<%
    Inquiry inquiry = (Inquiry)request.getAttribute("inquiry");

    List<InquiryComment> inquiryComments = (List<InquiryComment>)request.getAttribute("inquryComments");
    if (inquiryComments == null || inquiryComments.get(0).getInquiryCommentNo() == 0) {

        inquiryComments = new ArrayList<>();
    }
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
        flex: 1;
        margin-right: 20px;
    }

    #container-wrapper {
        display: flex;
    }

    #sidebar {
        padding-top: 70px;
        flex: 1;
    }

    #board-container {
        margin: 0 auto;
        margin-top: 50px;
        padding: 50px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        flex: 1.5;
    }
</style>

<div class="container">
    <div class="row">
        <div id="container-wrapper">

            <div id="sidebar">
                <div class="inner">

                    <nav id="menu">
                        <header class="major">
                            <h2>1:1 문의</h2>
                        </header>
                        <ul>
                            <li>

                                <a href="<%=request.getContextPath() %>/inquiry/inquiryList.do" class="nav-link"
                                   class="opener">1:1 문의</a>

                            </li>

                        </ul>
                    </nav>

                </div>
            </div>

            <style>
                #board-container {
                    margin: 0 auto;
                    margin-top: 50px;
                    padding: 50px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    border-radius: 10px;
                }

                .board-header h2 {
                    font-size: 24px;
                    margin-bottom: 20px;
                }

                .board-content {
                    border: none;
                    border-radius: 5px;
                }

                .board-detail-row {
                    display: flex;

                    margin-bottom: 10px;

                }

                .board-top-padding {
                    margin-top: 30px;
                }

                .board-detail-label {
                    flex: 0 0 120px;
                    font-weight: bold;
                    margin-left: 20px;
                    align-items: center;
                    justify-content: center;
                }

                .board-detail-label-title {
                    flex: 0 0 120px;
                    font-weight: bold;
                    margin-left: 20px;
                    align-items: center;
                    justify-content: center;
                    margin-top: 50px;
                }

                .board-detail-value {
                    flex: 1;
                }

                .board-file img {
                    margin-right: 5px;
                }

                .board-content-text {
                    margin-top: 50px;
                    margin-top: 50px;
                    white-space: pre-wrap;

                    display: flex;
                }

                .board-actions {
                    margin-top: 20px;
                    display: flex;
                    justify-content: center;
                }

                .comment-actions {
                    margin-top: 20px;
                    display: flex;
                    justify-content: flex-end;
                }

                .comment-container {
                    margin-top: 20px;
                }

                .comment-editor {
                    margin-bottom: 20px;
                }

                .comment-list {
                    padding-top: 20px;
                }


                #comment-container {
                    margin-top: 20px;

                    padding: 20px;
                    border-radius: 10px;
                }

                .comment-editor {
                    margin-bottom: 20px;
                }

                #tbl-comment {
                    width: 80%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                #tbl-comment th,
                #tbl-comment td {

                    padding: 10px;
                    text-align: left;
                }

                #tbl-comment .level1 td {

                }

                .comment-writer,
                .comment-date {
                    display: inline-block;
                    font-size: 12px;
                    margin-bottom: 5px;
                }

                .comment-content {
                    white-space: pre-wrap;
                }

                .btn-reply,
                .btn-delete,
                .btn-insert,
                .btn-insert2 {

                    border: none;
                    padding: 5px 10px;
                    cursor: pointer;
                    border-radius: 5px;
                    margin-right: 5px;
                }

            </style>

            <section id="board-container">
                <div class="board-top-padding">
                </div>
                <form action='<%=request.getContextPath()%>/inquiry/inquiryWriteEnd.do'
                      enctype="multipart/form-data" method="post">

                    <input type="hidden" name="memberNo"
                           value="<%= (loginMember != null) ? loginMember.getMemberNo() : -1 %>">
                    <input type="hidden" name="orderNo">
                    <input type="hidden" name="productNo">
                    <input type="hidden" name="memberName"
                           value="<%= (loginMember != null) ? loginMember.getMemberName() : "" %>">
                    <input type="hidden" name="totalPrice">
                    <input type="hidden" name="orderStatus">
                    <input type="hidden" name="productionName">
                    <input type="hidden" name="productImg">
                    <input type="hidden" name="refundNo">
                    <input type="date" name="refundDate" style="display: none;">
                    <div class="board-detail-row">
                        <span class="board-detail-label">문의 분류</span>
                        <span class="board-detail-value" name="category"><%=inquiry.getInquiryType() %></span>
                    </div>
                    <hr style="border-top: 1px solid rgba(0, 0, 0, 0.1) !important;">
                    <div class="board-detail-row">
                        <span class="board-detail-label" name="title">제목</span>
                        <span class="board-detail-value"><%=inquiry.getInquiryTitle() %></span>
                    </div>
                    <div class="board-content">
                        <div class="board-details">
                            <div class="board-detail-row">
                                <span class="board-detail-label" name="writer">작성자</span>
                                <span class="board-detail-value"
                                      style="font-weight: bolder"><%=inquiry.getMemberName() %></span>
                            </div>
                            <div class="board-detail-row">
                                <%
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    String sdfResult = sdf.format(inquiry.getInquiryDate());
                                %>
                                <span class="board-detail-label">작성일</span>
                                <span class="board-detail-value"><%=sdfResult %></span>
                            </div>
                            <hr style="border-top: 1px solid rgba(0, 0, 0, 0.1) !important;">
                            <div class="board-detail-row">
                                <span class="board-detail-label" name="orderNo">주문 번호</span>
                                <span class="board-detail-value"><%=inquiry.getFkOrderNo() %></span>
                            </div>
                            <div class="board-detail-row">
                                <span class="board-detail-label" name="productNo">상품명 </span>
                                <span class="board-detail-value"><%=inquiry.getProductionName() %></span>
                            </div>
                            <hr style="border-top: 1px solid rgba(0, 0, 0, 0.1) !important;">
                            <div class="board-detail-row">
                                <span class="board-detail-label" name="refundNo">환불신청 번호 </span>
                                <span class="board-detail-value"><%=inquiry.getRefundNo() %></span>
                            </div>
                            <div class="board-detail-row">
                                <span class="board-detail-label">환불신청 일자 </span>
                                <span class="board-detail-value"><%=inquiry.getRefundDate() %></span>
                            </div>
                            <hr style="border-top: 1px solid rgba(0, 0, 0, 0.1) !important;">
                            <div class="board-detail-row">
                                <span class="board-detail-label" name="upfile2">첨부파일</span>
                                <div class="board-file">
                                    <% if (inquiry.getInquiryOriginalFilename() != null) { %>
                                    <a href="<%=request.getContextPath()%>/upload/inquiry/<%= inquiry.getInquiryRenameFilename() %>"
                                       target="_blank"
                                       onclick="window.open(this.href, 'Image', 'resizable=yes,width=800,height=600'); return false;">
                                        <img style="margin-left: 50px;" src="<%=request.getContextPath()%>/upload/inquiry/<%= inquiry.getInquiryRenameFilename() %>" width="100">
                                        <div class="col-12">원본 보기 : 이미지 클릭<%=inquiry.getInquiryOriginalFilename() %>
                                        </div>
                                    </a>
                                    <span></span>
                                    <% } %>
                                </div>
                            </div>
                            <hr style="border-top: 1px solid rgba(0, 0, 0, 0.1) !important;">
                            <div class="board-detail-row">
                                <span class="board-detail-label-title">내용</span>
                                <div class="board-content-text"><%=inquiry.getInquiryContent() %>
                                </div>
                            </div>
                        </div>

                        <div class="board-actions">
                            <button type="button" class="btn btn-primary btn-sm">수정하기</button>
                            &nbsp;&nbsp;
                            <button type="button" class="btn btn-primary btn-sm">삭제하기</button>
                        </div>

                </form>

                <form action="<%=request.getContextPath() %>/board/insertComment.do" method="post">
                    <div id="comment-container" style="margin-top: 50px;">
                            <%if (!inquiryComments.isEmpty()) { %>
                        <div class="comment-wrapper">
                            <%
                                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                String sdfResult2 = "";
                            %>
                            <% for (InquiryComment inquiryComment : inquiryComments) {
                                if (inquiryComment.getFkInquiryNo() != 0) {%>


                            <div class="comment" style="margin: 0 30px;">
                                <div class="comment-writer"
                                     style="font-weight: bolder"><%=inquiryComment.getInquiryCommentWriter() %>
                                </div>
                                <%
                                    sdfResult2 = sdf2.format(inquiryComment.getInquiryCommentDate());
                                %>
                                <div class="comment-date">
                                    <span class="comment-date-value"><%=sdfResult2 %></span>
                                </div>
                                <div class="comment-content"><%=inquiryComment.getInquiryCommentContent() %>
                                </div>
                                <div class="comment-actions">

                                    <%
                                        if (loginMember != null && loginMember
                                                .getMemberId()
                                                .equals("admin")) {
                                    %>

                                    <button type="submit" class="btn btn-primary btn-sm"
                                    >삭제
                                    </button>

                                    <% } %>
                                </div>
                            </div>
                            <% }%>
                            <% } %>
                        </div>

                            <%} %>
                </form>
                <div class="comment-editor">


                    <form action="<%=request.getContextPath() %>/board/insertComment.do" method="post">
                        <input type="hidden" name="boardRef" value="<%=inquiry.getInquiryNo()%>">
                        <input type="hidden" name="level" value="1">
                        <input type="hidden" name="writer"
                               value="<%=loginMember!=null?loginMember.getMemberName():"" %>">
                        <input type="hidden" name="boardCommentRef" value="0">
                        <textarea name="content" cols="55" rows="3"
                                  style="margin-top: 30px; border: 1px;!important; border: 1px solid #E0EDA2 !important;">

                                </textarea>
                        <div class="comment-actions">
                            <button type="submit" id="btn-insert" class="btn btn-primary btn-sm"
                            >등록
                            </button>
                            &nbsp;
                            <button type="button" id="btn-insert2" class="btn btn-primary btn-sm"
                                    style="margin-right: 20px;"
                            >삭제
                            </button>
                        </div>
                    </form>
                </div>
            </section>
        </div>
    </div>


</div>
<script>
    $(".comment-editor>form>textarea[name=content]").focus(e => {
        if (<%=loginMember==null%>) {
            alert("로그인 후 이용할 수 있는 서비스입니다.");
            e.target.blur(); // 포커스 해제
        }
    });
    $(".btn-reply").click(e => {

        const $tr = $("<tr>");
        const $td = $("<td>").attr("colspan", "2");
        const $form = $(".comment-editor>form").clone();

        $form.find("input[name=level]").val("2");
        $form.find("textarea").attr("rows", "1");
        $form.find("button").removeAttr("id").addClass("btn-insert2");
        $form.find("input[name=boardCommentRef]").val($(e.target).val());

        $td.append($form);
        $tr.append($td);

        $(e.target).parents("tr")
            .after($tr);
    });
</script>


</div>
</body>
<%@ include file="/views/common/footer.jsp" %>
