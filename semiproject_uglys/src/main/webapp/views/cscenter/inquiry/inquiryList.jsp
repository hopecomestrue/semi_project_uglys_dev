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
    /* 여백 조절 스타일 */
    .navbar-nav {
        margin-top: 20px; /* 네비게이션 바 전체의 위쪽 여백 */
    }

    .navbar-nav .nav-item {
        margin-bottom: 10px; /* 각 네비게이션 아이템의 아래쪽 여백 */
    }

    .navbar-nav .cta-colored {
        margin-top: 20px; /* [0] 아이템의 위쪽 여백 */
    }

    .navbar-nav .btn-primary,
    .navbar-nav .btn-outline-secondary {
        margin-top: 10px; /* 버튼 위쪽 여백 */
        margin-bottom: 3px; /* 버튼 아래쪽 여백 */
    }

    .navbar-nav .important-button {
        margin-top: 3px; /* 중요 버튼 위쪽 여백 */
    }

    .navbar-nav span {
        margin-top: 3px; /* 환영 메세지 위쪽 여백 */
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
            /* 추가된 스타일 */
            .navbar-nav {
                margin-top: 20px; /* 위쪽 여백 조정 */
            }
        </style>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="index.html" class="nav-link">정기배송</a></li>
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
                        <style>
                            /* 호버 시에 녹색으로 변경 */
                            .important-button:hover {
                                color: #28a745;
                            !important;
                            }
                        </style>
                        <button type="button" class="btn btn-primary btn-sm important-button"
                                onclick="location.replace('<%=request.getContextPath()%>/myInfo.do')"
                                style="padding: .6rem !important; font-size: .72rem !important; margin: 0 !important; color: white; !important;">
                            마이페이지
                        </button>&nbsp;&nbsp;

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
%>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<%-- <%
	// Oracle에서 Timestamp 값을 가져온다고 가정
	Timestamp oracleTimestamp = (Timestamp) request.getAttribute("oracleTimestamp");

// SimpleDateFormat을 사용하여 날짜 및 시간 형식을 지정
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// 변환된 날짜 문자열을 얻음
	String formattedDate = dateFormat.format(oracleTimestamp);
%> --%>


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
<!-- 큰 div를 만들어서 같은곳에 넣어줌 -->
<div class="container">
    <div class="row">
        <!-- Sidebar -->
        <div id="sidebar">
            <div class="inner">
                <!-- Menu -->
                <nav id="menu">
                    <header class="major">
                        <h2>1:1 문의</h2>
                    </header>
                    <ul>
                        <li>

                        <li class="opner" style="list-style-type: none;"><a
                                href="<%=request.getContextPath() %>/notice/noticeList.do" class="nav-link">공지사항</a>
                        </li>

                        </li>
                        <li>
                            <span class="opener">자주 묻는 질문</span>

                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/inquiry/inquiryList.do" class="nav-link"
                               class="opener">1:1 문의</a>
                        </li>
                        <li>
                            <span class="opener">고객의 소리(x)</span>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

        <section id="board-container" style="margin-top: 130px; margin-bottom: 100px;">
<%--            <button id="kakaoButton">Message 버튼</button>
            <script>
                document.getElementById('kakaoButton').addEventListener('click', function() {

                });
            </script>--%>
<%--     <button id="kakaoButton">Message 버튼</button>
            <script>
                document.getElementById('kakaoButton').addEventListener('click', function() {
                    // jQuery를 사용하는 경우 아래 코드로 대체 가능
                    // $.post('http://localhost:3000/kakao2.do', {}, function(response) {
                    //   console.log(response);
                    // });

                    var xhr = new XMLHttpRequest();

                    xhr.open('POST', 'https://988f6a70deb1.ngrok.app/semiproject_uglys/kakao2.do', true);
                    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
                    xhr.onreadystatechange = function() {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            console.log(xhr.responseText);
                        }
                    };
                    xhr.send(JSON.stringify({}));
                });
            </script>--%>


<%--            <button id="messageButton" onclick="getJSON()">Message 버튼</button>
            <button id="webLinkButton">WebLink 버튼</button>
            <form action="/kakao2.do" method="post">


                <div id="response"></div>

                <script>
                    const fastify = require('fastify')({ logger: true });

                    fastify.post('/kakao2.do', async (request, reply) => {
                        const body = request.body;
                        console.log(JSON.stringify(body, null, 4));

                        const userID = body.userRequest.user.id;

                        return {
                            version: '2.0',
                            template: {
                                outputs: [
                                    {
                                        carousel: {
                                            type: 'basicCard',
                                            items: [
                                                {
                                                    title: '보물상자',
                                                    description: '보물상자 안에는 뭐가 있을까',
                                                    thumbnail: {
                                                        imageUrl: 'https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg',
                                                    },
                                                    buttons: [
                                                        {
                                                            action: 'message',
                                                            label: '열어보기',
                                                            messageText: '짜잔! 우리가 찾던 보물입니다',
                                                        },
                                                        {
                                                            action: 'webLink',
                                                            label: '구경하기',
                                                            webLinkUrl: 'https://e.kakao.com/t/hello-ryan',
                                                        },
                                                    ],
                                                },
                                                {
                                                    title: '보물상자2',
                                                    description: '보물상자2 안에는 뭐가 있을까',
                                                    thumbnail: {
                                                        imageUrl: 'https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg',
                                                    },
                                                    buttons: [
                                                        {
                                                            action: 'message',
                                                            label: '열어보기',
                                                            messageText: '짜잔! 우리가 찾던 보물입니다',
                                                        },
                                                        {
                                                            action: 'webLink',
                                                            label: '구경하기',
                                                            webLinkUrl: 'https://e.kakao.com/t/hello-ryan',
                                                        },
                                                    ],
                                                },
                                                {
                                                    title: '보물상자3',
                                                    description: '보물상자3 안에는 뭐가 있을까',
                                                    thumbnail: {
                                                        imageUrl: 'https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg',
                                                    },
                                                    buttons: [
                                                        {
                                                            action: 'message',
                                                            label: '열어보기',
                                                            messageText: '짜잔! 우리가 찾던 보물입니다',
                                                        },
                                                        {
                                                            action: 'webLink',
                                                            label: '구경하기',
                                                            webLinkUrl: 'https://e.kakao.com/t/hello-ryan',
                                                        },
                                                    ],
                                                },
                                            ],
                                        },
                                    },
                                ],
                            },
                        };
                    });

                    fastify.listen(3000, (err, address) => {
                        if (err) {
                            fastify.log.error(err);
                            process.exit(1);
                        }
                        fastify.log.info(`Server listening on ${address}`);
                    });
function getJSON() {

}
                </script>
            </form>--%>

            <%
                int inquiryCount = inquiryList.size();
            %>
            <h7 style="margin-right: 600px;">전체 글 수      <%=inquiryCount%>

            </h7>

            <table id="tbl-board">
                <tr>
                    <th>번호</th>
                    <th>문의 타입</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>

                    <%-- <th>조회수</th>--%>
                </tr>
                <tr>
                    <%

                        if (!inquiryList.isEmpty()) {
                            /*바꿔야함*/
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
                        <%-- <%=n.getNoticeDate() %> --%>
                        <%=n.getMemberName()%>
                    </td>
                    <td>
                        <%
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String sdfResult = sdf.format(n.getInquiryDate());
                        %>
                        <%=sdfResult%>
                    </td>
         <%--           <td>
                        <%if (n.getInquiryOriginalFilename() != null) { %>
                        <img src="<%=request.getContextPath()%>/images/file.png"
                             width="25">
                        <%} %>
                    </td>--%>
                    <%-- <td><%=n.getNoticeView() %>
                         </td>--%>
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

                <%--	<%} %>--%>
            </div>
        </section>
    </div>
</div>
<%@ include file="/views/common/footer.jsp" %>