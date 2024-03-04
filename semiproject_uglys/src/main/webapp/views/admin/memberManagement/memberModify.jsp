<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dao.*"%>
<%@ page import="com.veg.hjj.member.dto.*"%>
<%@ page import="com.veg.ojy.mypage.dao.*"%>
<%@ include file="/views/admin/common/header.jsp" %>
<%
Member member = (Member) request.getAttribute("member");
%>

	<div class="pcoded-main-container">
		<div class="pcoded-content">
			<div class="col-12 d-flex justify-content-center">
				<div class="login-form">
					<h2>회원정보 상세보기</h2>
					<form
						action="<%=request.getContextPath()%>/views/admin/memberManagement/memberModify.jsp"
						method="post" onsubmit="return goBack()">
						<div class="form-group col-md-12">
                                    <label for="userId">아이디</label> <br>
                                    <input type="text"
								name="memberId" value="<%=member.getMemberId()%>">
                                </div>
                                <div class="form-group col-md-12">
                                   	<label for="username">이름</label><br> <input type="text" name="name"
								value="<%=member.getMemberName()%>">
                                </div>
                                <div class="form-group col-md-12">
                                   <label for="pass">연령</label><br><input type="text"
								value="<%=member.getMemberAge()%>" name="age">
                                </div>
                                <div class="form-group col-md-12">
                                   <label for="pass">휴대폰번호</label><br><input type="text" name="phone"
								value="<%=member.getMemberPhone()%>">
                                </div>
                                <div class="form-group col-md-12">
                                   <label for="pass">이메일</label><br> <input type="text"
								value="<%=member.getMemberEmail()%>" name="email">
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="pass">주소</label><br> <input type="text"
								value="<%=member.getAddress()%>" name="address">
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="pass">서비스 동의</label><br> <select name="agree">
								<option value="Y"
									<%=member.getServiceAgree().equals("Y") ? "selected" : ""%>>동의</option>
								<option value="N"
									<%=member.getServiceAgree().equals("N") ? "selected" : ""%>>비동의</option>
							</select>
                                </div>
                                 <div class="form-group col-md-12">
                                <button type="submit" class="btn  btn-primary">닫기</button>
                                </div>
<%--                                 
						<div class="group-input">
							<label for="userId">아이디</label> <input type="text"
								name="memberId" value="<%=member.getMemberId()%>">
							<!-- 세션값아이디 히든으로 넘기기 -->
						</div>
						<div class="group-input">
							<label for="username">이름</label> <input type="text" name="name"
								value="<%=member.getMemberName()%>">
						</div>
						<div class="group-input">
							<label for="pass">연령</label> <input type="text"
								value="<%=member.getMemberAge()%>" name="age">
						</div>
						<div class="group-input">
							<label for="pass">휴대폰번호</label> <input type="text" name="phone"
								value="<%=member.getMemberPhone()%>">
						</div>
						<div class="group-input">
							<label for="pass">이메일</label> <input type="text"
								value="<%=member.getMemberEmail()%>" name="email">
						</div>
						<div class="group-input">
							<label for="pass">주소</label> <input type="text"
								value="<%=member.getAddress()%>" name="address">
						</div>
						<div class="group-input">
							<label for="pass">서비스 동의</label> <select name="agree">
								<option value="Y"
									<%=member.getServiceAgree().equals("Y") ? "selected" : ""%>>동의</option>
								<option value="N"
									<%=member.getServiceAgree().equals("N") ? "selected" : ""%>>비동의</option>
							</select>
						</div>
						<br>
						<button type="submit" class="btn  btn-primary">닫기</button>
						<!-- <button type="submit" class="primary">닫기</button> --> --%>
					</form>
				</div>
			</div>
		</div>
	</div> 

	<script>
		function goBack() {
			window.history.back();
			return false; // 폼이 서버로 전송되는 것을 막기 위해 false를 반환합니다.
		}
	</script>
<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/vendor-all.min.js"></script>
    <script src="<%=request.getContextPath() %>/assets/js/plugins/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/assets/js/pcoded.min.js"></script>
<%@ include file="/views/admin/common/footer.jsp" %>