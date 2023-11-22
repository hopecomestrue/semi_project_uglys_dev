<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dao.*" %>
<%@ page import="com.veg.hjj.member.dto.*" %>
<%@ page import="com.veg.ojy.mypage.dao.*" %>
<%
 Member member =(Member)request.getAttribute("member");
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
											<input type="hidden" value="" name="">
											<%=member.getMemberId()%>
										</td>
									</tr>
									<tr>
										<th>이름</th>
										<td>
											<input type="text" value="<%=member.getMemberName() %>" name="name">
										</td>
									</tr>
									<tr>
										<th>연령</th>
										<td>
											<input type="text" value="<%=member.getMemberAge()%>" name="age">
										</td>
									</tr>
									<tr>
										<th>휴대폰번호</th>
										<td>
											<input type="text" value="<%=member.getMemberPhone()%>" name="phone">
										</td>
									</tr>
									<tr>
										<th>이메일</th>
										<td>
										<input type="text" value="<%=member.getMemberEmail()%>" name="email">
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td>
										<input type="text" value="<%=member.getAddress()%>" name="address">
										</td>
									</tr>
									<tr>
										<th>서비스 동의</th>
										<td>
										<select>
										<opiton value="Y" name="agree" <%=member.getServiceAgree().equals("Y")? "checked":""%>></opiton>
										<option value="N" name="agree" <%=member.getServiceAgree().equals("N")? "checked":""%>></option>
										</select>
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
</html> 