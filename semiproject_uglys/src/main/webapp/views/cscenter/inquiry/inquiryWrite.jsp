<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page
        import="java.util.List,com.veg.seoj.cscenter.model.dto.Inquiry,java.sql.Timestamp,java.text.SimpleDateFormat" %>
<%
    List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");
%>
<%@ include file="/views/common/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

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

<script>
    내용입력여부
    확인
    후
    전송
</script>
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
        <section id='board-container' style='margin: 0 auto;'>
                    <style>
                #board-container {
                    padding-top: 100px; /* 위쪽 여백 설정 */
                    padding-bottom: 100px; /* 아래쪽 여백 설정 */
                    text-align: center;
                }
            </style>
         <h7 style="margin-right: 600px;">1:1 문의 작성</h7>

            <script>
                $(document).ready(function () {
                    // 이미지가 선택될 때마다 실행되는 이벤트 핸들러
                    $("#upfile2").change(function (e) {
                    	$("#prevImg").empty();
                        // 선택된 파일들을 미리보기에 출력
                        previewImages(e.target.files);
                    });


                    // 이미지 미리보기 함수
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
            <form action='<%=request.getContextPath()%>/inquiry/inquiryWriteEnd.do'
                  enctype="multipart/form-data" method="post" id="uploadForm">
                <table id='tbl-board'>
                    <tr>
                        <th>카테고리</th>
                        <td><select name="category">
                            <option value="배송">배송</option>
                            <option value="주문">주문</option>
                            <option value="상품">상품</option>
                            <option value="기타">기타</option>
                            <option value="미설정">미설정</option>
                        </select></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" name="title" required></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input type="text" name="writer"
                                   value="<%--<%=loginMember.getUserId()%>--%>로그인 한 사람" readonly></td>
                    </tr>
                    <tr>
                        <th>첨부 이미지</th>
                        <td>
                        <style>
                        	#upfile2,
                        	#prevImg{
                        		display: inline-block;
                        	}
                        </style>
                             <div id="prevImg"></div>
                            <input type="file" name="upfile2" id="upfile2" accept="image/*">
                       
                        </td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea cols="47" rows="10" name="content"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="저장">
                            <input type="reset" value="취소">
                        </th>
                    </tr>
                </table>
            </form>
        </section>
    </div>
</div>

<%@ include file="/views/common/footer.jsp" %>