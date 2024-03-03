<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.veg.hjj.member.dto.*"%>
<%@ page import="com.veg.ojy.mypage.dto.Address"%>
<%@ page import="java.util.List,java.util.Arrays"%>
<%-- <%@ page import="com.veg.ojy.mypage.dto.*" %> --%>
<%@ include file="/views/common/header.jsp"%>

<%
	/* Member loginMember=(Member)session.getAttribute("loginMember"); */
	List<Address> a = (List<Address>)request.getAttribute("address");
	List<Order> orders=(List<Order>)request.getAttribute("orders");
%>
<style>
.orderList:hover {
  background-color: #82AE46;
  color: #fff;
  transform: scale(1.1);
}
.info:hover {
  background-color: #82AE46;
  color: #fff;
  transform: scale(1.1);
}
.rv:hover {
  background-color: #82AE46;
  color: #fff;
  transform: scale(1.1);
}
.bookM:hover {
  background-color: #82AE46;
  color: #fff;
  transform: scale(1.1);
}
</style>
<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2">My Page</span></p>
            <h1 class="mb-0 bread">마이페이지</h1>
          </div>
        </div>
      </div>
    </div>
    <section class="ftco-section">
    	<div class="container">
    		<div class="row justify-content-center">
    			<div class="col-md-10 mb-5 text-center">
    				<ul class="product-category">
    					<li><a href="#" class="orderList" onclick="scrollToSection('myOrder')">최근주문내역</a></li>
    					<li><a href="#" class="info"onclick="scrollToSection('myInfo')">내정보수정</a></li>
    					<li><a href="#" class="rv"onclick="scrollToSection('myReview')">나의리뷰</a></li>
    					<li><a href="#" class="bookM" onclick="scrollToSection('myBookMark')">북마크</a></li>
    				</ul>
    			</div>
    		</div>
<!-- 본문시작 -->
<div class="col-md-12 ftco-animate">
    				<div class="cart-list" id="myOrder">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>주문번호</th>
						        <th>주문상품</th>
						        <th>주문날짜</th>
						        <th>주문금액</th>
						        <th>주문상태</th>
						      </tr>
						    </thead>
						    <tbody>
						    <%if(orders !=null){
										for(Order o : orders){%>
							<tr class="text-center">
								<td><a href="<%=request.getContextPath()%>/myinfo/myOrderDetail.do?orderNo=<%=o.getOrderNo() %>"><%=o.getOrderNo() %></a></td>
								<td class="image-prod"><div class="img" style="background-image:url(images/product-1.jpg);"></div></td>
								<td><%=o.getOrderDate() %></td>
								<td><%=o.getTotalPrice() %></td>
								<td><%=o.getOrderStatus() %></td>
							</tr>
							<%}
									}%>
						    </tbody>
						  </table>
					  </div>
					  <!-- 내정보 수정 -->
					  <div class="comment-form-wrap pt-5" id="myInfo">
                <h3 class="mb-5">내 정보 수정</h3>
                <form action="#" class="p-5 bg-light">
                  <div class="form-group">
                    <label for="id">아이디 *</label>
                    <input type="text" class="form-control" id="id"  value="<%=loginMember.getMemberId() %>">
                  </div>
                  <div class="form-group">
                    <label for="password">비밀번호 *</label>
                    <input type="password" class="form-control" id="password" value="<%=loginMember.getMemberPw() %>">
                  </div>
                  <div class="form-group">
                    <label for="name">이름</label>
                    <input type="url" class="form-control" id="name" value="<%=loginMember.getMemberName() %>">
                  </div>
                  <div class="form-group">
                    <label for="age">연령</label>
                    <input type="url" class="form-control" id="age" value="<%=loginMember.getMemberAge() %>">
                  </div>
                  <div class="form-group">
                    <label for="phone">휴대폰 번호</label>
                    <input type="url" class="form-control" id="phone" value="<%=loginMember.getMemberPhone() %>">
                  </div>
                  <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="url" class="form-control" id="email"  value="<%=loginMember.getMemberEmail() %>">
                  </div>
					<div class="form-group">
						<label for="address">주소</label>
						<% if (a != null) {
							for (Address addr : a) {
						%>
						<input type="text" name="address" class="form-control"
							value="<%=addr.getAddress()%>" placeholder="주소" />
						<% } } else {
						%><input type="text" name="address" class="form-control" placeholder="주소" />
						<% } %>
						<input type="text" class="form-control" id="address" name="address">
					</div>
					<div class="form-group" style="text-align: center">
				<input type="checkbox" id="demo-human" name="demo-human" checked>
					<label>[선택] 할인 등 정보 혜택 수신 동의 </label>
					<br>
						<input type="button" value="비밀번호 변경하기" class="btn btn-primary" 
							onclick="fn_changePw();" />
						<input type="button" value="새 배송지 등록하기" class="btn btn-primary" 
							onclick="fn_changeAddr();" />
						<br><br>
				
					 <input type="button" value="회원탈퇴" class="btn btn-primary" onclick="fn_moveinfo();">
				</div>
                </form>
              </div>
              <div id="myBookMark">
</div>
<div id="myReview">
</div>
    			</div>
    		</div>
</section>
<script>
				function confirmLogout() {
					var result = confirm("로그아웃 하시겠습니까?");
					if (result) {
						alert("로그아웃 되었습니다."); 
					} else {
						alert("로그아웃 취소되었습니다.");
					}
				}
			</script>
<script>
				function confirmModify() {
					var result2 = confirm("수정하시겠습니까?");
					if (result2) {
						alert("수정이 완료되었습니다."); 
					} else {
						alert("수정이 완료되지 않았습니다.");
					}
				}
			</script>
<script>
				const fn_changePw=()=>{
					window.location.href='<%=request.getContextPath()%>/updateInfo.do?memberId=<%=loginMember.getMemberId()%>';
				}
			</script>
<script>
				const fn_changeAddr=()=>{
					window.location.href='<%=request.getContextPath()%>/myaddress.do?memberId=<%=loginMember.getMemberId()%>';
				}
			</script>
<script>
				const fn_moveinfo=()=>{
					window.location.href='<%=request.getContextPath()%>/views/member/mypage/memberCancellation.jsp';
				}
			</script>

<script>
        function scrollToSection(myInfo) {
            var section = document.getElementById(myInfo);

            if (section) {
                section.scrollIntoView({ behavior: 'smooth' });
            }
        }
        function scrollToSection(myReview) {
            var section = document.getElementById(myReview);

            if (section) {
                section.scrollIntoView({ behavior: 'smooth' });
            }
        }
        function scrollToSection(myBookMark) {
            var section = document.getElementById(myBookMark);

            if (section) {
                section.scrollIntoView({ behavior: 'smooth' });
            }
        }
        function scrollToSection(myOrder) {
            var section = document.getElementById(myOrder);

            if (section) {
                section.scrollIntoView({ behavior: 'smooth' });
            }
        }
    </script>
<%@ include file="/views/common/footer.jsp"%>