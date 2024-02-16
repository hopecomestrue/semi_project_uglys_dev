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
<!-- 최근 주문내역, 내정보 수정, 나의 리뷰  -->
<!--    <div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');"> -->
<div class="hero-wrap hero-bread">
	<div class="container">
		<div class="row justify-content-center mb-3 pb-3">
			<div class="col-md-12 heading-section text-center ftco-animate">
				<!-- <span class="subheading">마이페이지</span> -->
				<h2 class="mb-4">마이페이지</h2>
				<!-- <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p> -->
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">
					<a href="#" class="img-prod" onclick="scrollToSection('myOrder')"><img
						class="img-fluid"
						src="<%=request.getContextPath()%>/images/free-icon-trolley-14478179.png"
						alt=""> <!-- <span class="status">30%</span> -->
						<div class="overlay"></div> </a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3>
							<a href="#">최근 주문내역</a>
						</h3>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">
					<a href="#" class="img-prod" onclick="scrollToSection('myInfo')"><img
						class="img-fluid"
						src="<%=request.getContextPath()%>/images/free-icon-add-contact-14478119.png"
						alt="Colorlib Template">
						<div class="overlay"></div> </a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3>
							<a href="#">내 정보 수정</a>
						</h3>
						<div class="d-flex">
							<div class="pricing">
								<p class="price">
									<span></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">
					<a href="#" class="img-prod" onclick="scrollToSection('myReview')"><img
						class="img-fluid"
						src="<%=request.getContextPath()%>/images/free-icon-edit-14478123.png"
						alt="Colorlib Template">
						<div class="overlay"></div> </a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3>
							<a href="#">나의 리뷰</a>
						</h3>
						<div class="d-flex">
							<div class="pricing">
								<p class="price">
									<span></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">
					<a href="#" class="img-prod"
						onclick="scrollToSection('myBookMark')"><img class="img-fluid"
						src="<%=request.getContextPath()%>/images/free-icon-bookmark-14478084.png"
						alt="Colorlib Template">
						<div class="overlay"></div> </a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3>
							<a href="#">북마크</a>
						</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
<!-- 본문시작 -->
<h3>최근주문내역</h3>
<!-- <section class="myOrder">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-6 product-details pl-md-5 ftco-animate">
    				<div class="features"> -->
<section class="myOrder" id="myOrder">
	<div class="container">
		<div class="row">
			<div class="col-md-12 ftco-animate">
				<div class="cart-list">
					<table class="table">
						<thead class="thead-primary">
							<tr class="text-center">
								<%if(orders !=null){
										for(Order o : orders){%>
								<article>
									<span class=></span/>
									<div class="content">
										<h3></h3>
										<table>
											<tr>
												<th>주문날짜 :</th>
												<td><%=o.getOrderDate() %></td>
											</tr>
											<tr>
												<th>주문번호 :</th>
												<td><a
													href="<%=request.getContextPath()%>/myinfo/myOrderDetail.do?orderNo=<%=o.getOrderNo() %>"><%=o.getOrderNo() %></a></td>
											</tr>
											<tr>
												<th>주문금액 :</th>
												<td><%=o.getTotalPrice() %></td>
											</tr>
											<tr>
												<td colspan="2"><img src="/images2/product-5.jpg"
													style="width: 100px; height: 100px;"></td>
											</tr>
											<tr>
												<td>주문상태</td>
												<td><%=o.getOrderStatus() %></td>
											</tr>
										</table>
									</div>
								</article>
								<%}
									}%>
							
				</div>
			</div>
</section>
<!-- <section id="myOrder"> -->
<!-- <header class="major"> -->
<!-- <h2>최근 주문 내역</h2>
									</header> -->
<%-- 									<div class="features">
									<%if(orders !=null){
										for(Order o : orders){%>
										<article>
											<span class=></span/>
											<div class="content"> 
												<h3></h3>
												<table>
												<tr>
													<th>주문날짜 : </th>
													<td><%=o.getOrderDate() %></td>
												</tr>
												<tr>
													<th>주문번호 : </th>
													<td><a href="<%=request.getContextPath()%>/myinfo/myOrderDetail.do?orderNo=<%=o.getOrderNo() %>"><%=o.getOrderNo() %></a></td>
												</tr>
												<tr>
													<th>주문금액 : </th>
													<td><%=o.getTotalPrice() %></td>
												</tr>
												<tr>
													<td colspan="2"><img src="/images2/product-5.jpg" style="width: 100px; height: 100px;"></td>
												</tr>
												<tr>
													<td>주문상태</td>
													<td><%=o.getOrderStatus() %></td>
												</tr>
												</table>
											</div>
										</article>
										<%}
									}%>
									</div>
								</section> --%>


<section id="myInfo">
	<header class="major">
		<h2>내 정보 수정</h2>
	</header>
	<div class="posts">
		<form method="post" action="<%=request.getContextPath()%>/myInfo.do"
			class="text-center">
			<div class="row gtr-uniform justify-content-center">
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-name" class="col-md-4 col-form-label">아이디</label>
						<div class="col-md-8">
							<input type="text" name="demo-name" id="demo-name"
								class="form-control" value="<%=loginMember.getMemberId() %>"
								readonly placeholder="아이디" style="width: 40%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-password" class="col-md-4 col-form-label">비밀번호</label>
						<div class="col-md-8">
							<input type="password" name="demo-password" id="demo-password"
								class="form-control" value="<%=loginMember.getMemberPw() %>"
								placeholder="비밀번호" style="width: 40%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-fullname" class="col-md-4 col-form-label">이름</label>
						<div class="col-md-8">
							<input type="text" name="demo-fullname" id="demo-fullname"
								class="form-control" value="<%=loginMember.getMemberName() %>"
								required placeholder="이름" style="width: 40%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-fullname" class="col-md-4 col-form-label">연령</label>
						<div class="col-md-8">
							<input type="text" name="demo-fullname" id="demo-age"
								class="form-control" value="<%=loginMember.getMemberAge() %>"
								required style="width: 40%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-phone" class="col-md-4 col-form-label">휴대폰번호</label>
						<div class="col-md-8">
							<input type="text" name="demo-phone" id="demo-phone"
								class="form-control" value="<%=loginMember.getMemberPhone() %>"
								placeholder="휴대폰번호" style="width: 40%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-email" class="col-md-4 col-form-label">이메일</label>
						<div class="col-md-8">
							<input type="email" name="demo-email" id="demo-email"
								class="form-control" value="<%=loginMember.getMemberEmail() %>"
								placeholder="Email" style="width: 60%;" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-address" class="col-md-4 col-form-label">주소</label>
						<div class="col-md-8">
							<% if (a != null ) {
                                                    	 for (Address addr : a) {%>
							<input type="text" name="demo-address" id="demo-address"
								class="form-control" value="<%=addr.getAddress() %>"
								placeholder="주소" style="width: 80%;" />
							<% } } else {%>
							<input type="text" name="demo-address" id="demo-address"
								class="form-control" placeholder="주소" style="width: 80%;" />
							<% } %>
						</div>
					</div>
				</div>
				<br>
				<div class="col-12 col-md-6">
					<div class="form-group row">
						<label for="demo-address" class="col-md-4 col-form-label"></label>
						<div class="col-md-8"></div>
					</div>
				</div>
				<br>
				<div class="col-6 col-12-small d-flex justify-content-center">
					<input type="checkbox" id="demo-human" name="demo-human" checked>
					<label for="demo-human">[선택] 할인 등 정보 혜택 수신 동의 </label>
				</div>
				<div class="col-12 d-flex justify-content-center">
					<ul class="actions">
						<li><input type="button" value="비밀번호 변경하기" class="primary"
							onclick="fn_changePw();" /></li>
						<li><input type="button" value="새 배송지 등록하기" class="primary"
							onclick="fn_changeAddr();" /></li>
					</ul>
				</div>
				<div class="col-12 d-flex justify-content-center">
					<ul class="actions">
						<!-- <li><input type="submit" value="수정완료" class="primary" onclick="confirmModify();"/></li> -->
						<li><input type="button" value="회원탈퇴" class="primary"
							onclick="fn_moveinfo();"></li>
					</ul>
				</div>
			</div>
		</form>
	</div>

</section>
<section id="myBookMark">
	<header class="major">
		<h2>북마크</h2>
	</header>
	<div class="posts">
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic04.jpg" alt="" /></a>
			<h3>북마크</h3>
			<p>북마크임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic04.jpg" alt="" /></a>
			<h3>북마크</h3>
			<p>북마크임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic04.jpg" alt="" /></a>
			<h3>북마크</h3>
			<p>북마크임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic04.jpg" alt="" /></a>
			<h3>북마크</h3>
			<p>북마크임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
	</div>
</section>
<section id="myReview">
	<header class="major">
		<h2>리뷰</h2>
	</header>
	<div class="posts">
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic06.jpg" alt="" /></a>
			<h3>리뷰</h3>
			<p>리뷰임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic06.jpg" alt="" /></a>
			<h3>나의리뷰</h3>
			<p>리뷰임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic06.jpg" alt="" /></a>
			<h3>리뷰</h3>
			<p>리뷰임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
		<article>
			<a href="#" class="image"><img
				src="<%=request.getContextPath() %>/images/images2/pic06.jpg" alt="" /></a>
			<h3>리뷰</h3>
			<p>리뷰임당</p>
			<ul class="actions">
				<li><a href="#" class="button">더보기</a></li>
			</ul>
		</article>
	</div>
</section>
</div>
</div>
</div>
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