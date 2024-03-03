<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <% ArrayList<Member> memberList = new ArrayList<>();
   memberList = m.selectMember();
%>  --%>
<%@ page import="com.veg.hjj.member.dto.*"%>
<%@ page import="com.veg.ojy.mypage.dto.Address"%>
<%@ page import="java.util.List,java.util.Arrays"%>
<%@ include file="/views/admin/common/header.jsp"%>
<%
    List<Member> members = (List<Member>)request.getAttribute("member");
   /*  Member loginMember = (Member)session.getAttribute("loginMember"); */
    List<Address> addresses = (List<Address>)request.getAttribute("address");
%>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important;
}

.admin-title {
	color: black;
	text-decoration: none;
}

.search_3 {
	align-items: center;
	display: flex;
	justify-content: right;
	margin-right: 2%;
	margin-bottom: 1%;
}

.delivery-check {
	
}

.delivery-tb {
	width: 80%;
	margin: 0 auto;
}

.delivery-paging {
	margin: 5%;
}
</style>
<%-- 									
									<div class="card-body">
									<div class="datatable-wraooer datatable-loading no-footer sortable searchable fixed-colums"> 
									<div class="datable-top">
									<div class="datatable-dropdown">
									</div>
									</div>
									 </div>
									<div class="features">
 									<div class="col-2">
 									<form action='<%=request.getContextPath() %>/searchMember.do' method="post">
										<select name="searchKey" id="searchKey" >
											<option value="test">- 선택 -</option>
											<option value="id">아이디</option>
											<option value="memberName">이름</option>
										</select>									
									</div>
									<br><br><br>
									<div class="datatable-search col-8">
									<input class="datatable-input" placeholder="회원조회" name="searchKeyword" title="search within table" 
									aria-controls="datatableSimple">
									</div><br><br>
									<div>
									<input type="submit" value="검색" class="primary" id="searchKey"/>
									</form>
									</div> --%>
<div class="pcoded-main-container">
	<div class="pcoded-content">
		<div class="card">
			<div class="card-header">
				<h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">회원조회</h1>
			</div>
			<br>
			<div>
				<form action='<%=request.getContextPath() %>/searchMember.do'
					method="post">
					<div class="search_3">
						<div class="del-Search">
							<select class="form-control" aria-label="Small select example"
								name="searchKey">
								<option value="test">-선택-</option>
								<option value="MEMBER_ID">아이디</option>
								<option value="MEMBER_NAME">이름</option>
							</select>
						</div>
						<div>
							<input type="text" class="form-control" name="searchKeyword"
								placeholder="내용을 적어주세요.">
						</div>
						<div>
							<input type="submit" class="btn btn-primary"
								value="검색" />
						</div>
					</div>
				</form>
			</div>
			<div class="card-body table-border-style">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th><a href="#" class="sort-btn" data-sort="id">아이디</a></th>
								<th><a href="#" class="sort-btn" data-sort="name">이름</a></th>
								<th><a href="#" class="sort-btn" data-sort="age">연령대</a></th>
								<th><a href="#" class="sort-btn" data-sort="phone">휴대폰번호</a></th>
								<th><a href="#" class="sort-btn" data-sort="email">이메일</a></th>
								<th>수정/삭제</th>
							</tr>
						</thead>
						<tbody>
							<% 
                                        for (Member member : members) {
                                    %>
							<tr>
								<td><%= member.getMemberId() %></td>
								<td><%= member.getMemberName() %></td>
								<td><%= member.getMemberAge() %></td>
								<td><%= member.getMemberPhone() %></td>
								<td><%= member.getMemberEmail() %></td>
								<td><a class="subBtn"
									href="<%=request.getContextPath()%>/memberUpdate.do?memberNo=<%=member.getMemberNo()%>">수정</a>
									<a class="subBtn" href="#">삭제</a></td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div id="pageBar" class="container">
		<%=request.getAttribute("pageBar") %>
	</div>
</div>

<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="/views/admin/common/footer.jsp"%>