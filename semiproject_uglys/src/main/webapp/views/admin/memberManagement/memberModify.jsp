<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dao.*" %>
<%@ page import="com.veg.hjj.member.dto.*" %>
<$@ page import="com.veg.ojy.mypage.dao.*" %>
<% 
String id = (String)session.getAttribute("loginMember");
MemberDao m = new MemberDao();
String memberId = request.getParameter("memberId");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div id="layoutSidenav_content">
        	<!-- 내용 시작 -->
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">회원 정보 상세 페이지</h1>
                    <br>
                    <div class="card mb-4">
                        <div class="card-body">
                            회원 상세보기 
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            회원 상세보기 관리
                        </div>
                        <div class="card-body">
	                        <form action="<%=request.getContextPath()%>/views/admin/memberManagement/memberModify.jsp" method="post">
	                            <table class="table">
	                                <tr>
										<th>아이디</th>
										<td>
											<input type="hidden" value="<%=m.getMemberId()%>" name="cstmId">
											<%=member.getMemberId()%>
										</td>
									</tr>
									<tr>
										<th>이름</th>
										<td>
											<input type="text" value="<%=m.getMemberName()%>" name="cstmActive">
										</td>
									</tr>
									<tr>
										<th>연령</th>
										<td>
											<%=member.getMemberAge()%>
										</td>
									</tr>
									<tr>
										<th>휴대폰번호</th>
										<td>
											<%=member.getMemberPhone()%>
										</td>
									</tr>
									<tr>
										<th>이메일</th>
										<td>
											<%=member.getMemberEmail()%>()%>
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td>
											<%=member.getAddress()%>
										</td>
									</tr>
									<tr>
										<th>서비스 동의</th>
										<td>
											<%=member.getServiceAgree()%>
										</td>
									</tr>
									<tr>
										<th>마케팅 동의</th>
										<td>
											<%=member.getMarketingAgree()%>
										</td>
									</tr>
									<tr>
										<th>정보동의</th>
										<td>
											<%=member.getAcceptAgree()%>
										</td>
									</tr>
									<tr>
										<th>가입날짜</th>
										<td>
											<%=member.getEnrollDate()%>
										</td>
									</tr>
	                            </table>
                           		<button class="btn btn-outline-secondary" type="submit">수정</button>
							</form>
                        </div>
                    </div>
                </div>
            </main>
</body>
</html>  --%>