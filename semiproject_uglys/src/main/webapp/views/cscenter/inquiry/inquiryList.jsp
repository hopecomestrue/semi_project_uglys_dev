<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List,com.veg.seoj.cscenter.model.dto.Inquiry,java.sql.Timestamp,java.text.SimpleDateFormat" %>

<%
    List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");
%>
<%@ include file="/views/common/header.jsp" %>
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css"/>
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
                            <span class="opener">공지사항</span>
                            <!-- 											<ul>
                                                                            <li><a href="myorders.html">주문 조회</a></li>
                                                                            <li><a href="myreturn.html">반품 조회</a></li>
                                                                            <li><a href="cart1.html">장바구니</a></li>
                                                                        </ul> -->
                        </li>
                        <li>
                            <span class="opener">자주 묻는 질문</span>
                            <!-- 											<ul>
                                                                            <li><a href="myreview.html">나의 리뷰</a></li>
                                                                            <li><a href="bookmark.html">북마크</a></li>
                                                                            <li><a href="#">1:1문의</a></li>
                                                                        </ul> -->
                        </li>
                        <li>

                            <a href="<%=request.getContextPath() %>/inquiry/inquiryList.do" class="nav-link"
                               class="opener">1:1 문의</a>
                            <!-- 											<ul>
                                                                            <li><a href="myinfo.html">내 정보 수정</a></li>
                                                                            <li><a href="myaddress.html">배송지 관리</a></li>
                                                                        </ul> -->
                        </li>
                        <!-- 										<li><a onclick="confirmLogout()">로그아웃</a></li> -->
                        <li>
                            <span class="opener">고객의 소리(x)</span>
                            <!-- 											<ul>
                                                                            <li><a href="myinfo.html">내 정보 수정</a></li>
                                                                            <li><a href="myaddress.html">배송지 관리</a></li>
                                                                        </ul> -->
                        </li>
                    </ul>
                </nav>

            </div>
        </div>
        <section id="board-container">
            <style>
                #board-container {
                    padding-top: 100px; /* 위쪽 여백 설정 */
                    padding-bottom: 100px; /* 아래쪽 여백 설정 */
                    text-align: center;
                }
            </style>
            <%
                int inquiryCount = inquiryList.size();
            %>
            <h7 style="margin-right: 600px;">전체 글 수      <%=inquiryCount%>

                <%--			<% int noticeCount=
                        <%=int noticeCount=notices.size()%>

                        <%}%>--%>
            </h7>

            <table id="tbl-board">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>첨부파일</th>
                    <%--                 <th>조회수</th>--%>
                </tr>
                <tr>
                    <%
                        if (!inquiryList.isEmpty()) {
                            /*바꿔야함*/
                            for (Inquiry n : inquiryList) {
                    %>
                    <td><%=n.getInquiryNo() %>
                    </td>
                    <td>
                        <a href="<%=request.getContextPath()%>/inquiry/inquiryView.do?no=<%=n.getInquiryNo()%>">
                            <%=n.getInquiryTitle() %>
                        </a>
                    </td>
                    <td>
                        <%-- <%=n.getNoticeDate() %> --%>
                        관리자
                    </td>
                    <td>
                        <%
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String sdfResult = sdf.format(n.getInquiryDate());
                        %>
                        <%=sdfResult%>
                    </td>
                    <td>
                        <%if (n.getInquiryOriginalFilename() != null) { %>
                        <img src="<%=request.getContextPath()%>/images/file.png"
                             width="25">
                        <%} %>
                    </td>
                    <%--                    <td><%=n.getNoticeView() %>
                                        </td>--%>
                </tr>
                <%
                        }
                    }
                %>
            </table>

            <div id="pageBar"><a>

                    <%=request.getAttribute("pageBar") %>

            </div>
            <div class="col-md-4">

                <%--
<%if(loginMember!=null){ %>
--%>
                <span class="">
							<button onclick="location.assign('<%=request.getContextPath() %>/inquiry/inquiryWrite.do')"
                                    style="margin-left: 600px;">
				글쓰기
			</button>
					</span>

                <%--	<%} %>--%>
            </div>

        </section>
    </div>
</div>
<%@ include file="/views/common/footer.jsp" %>