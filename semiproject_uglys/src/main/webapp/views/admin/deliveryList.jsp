<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>

<%
	//주문내역 리스트를 getAttribute로 받기
	List<Order> orderList=(List<Order>)request.getAttribute("orderList");
%>

<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
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
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
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
      
      .admin-title{
        color: black;
        text-decoration: none;
      }

      .search_3{
        align-items: center;
        display: flex;
        justify-content: right;
        margin-right: 2%;
        margin-bottom: 1%;
      }

      .delivery-check{
      
      }

      .delivery-tb{
        width: 80%;
        margin: 0 auto;
      }

      .delivery-paging{
        margin: 5%;
      }
      

      
    </style>
<body>
	<div>
		<h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">배송 현황</h1>
	</div>
<div class="delivery-check">
  <select class="form-select form-select-lg" aria-label=".form-select-lg example" id="delivery-check">
    <option selected>결제완료</option>
    <option value="1">배송준비중</option>
  </select>
</div>
<div class="delivery-tb">
<form action="<%=request.getContextPath()%>/admin/searchDelCheck" method="post">
<div class="search_3">
  <div class="del-Search">
<select class="form-select form-select-lm" aria-label="Small select example" name="searchType">
    <option value="ORDER_NAME" >이름으로 조회하기</option>
    <option value="ORDER_NO" >주문번호로 조회하기</option>
    <option value="ORDER_ADDRESS" >주소로 조회하기</option>
  </select>
</div>
<div>
  <input type="text" class="form-control" name="searchKeyword" placeholder="내용을 적어주세요.">
</div>
<div>
  <button type="submit" class="btn btn-primary">검색</button>
</div>
</div>
</form>
<table class="table table-bordered">
    <tr>
      <th><input class="form-check-input" type="checkbox" id="checkboxAll" value="" aria-label="..." ></th>
      <th>주문 상세 번호</th>
      <th>주문자 이름</th>
      <th>전화번호</th>
      <th>주소</th>
      <th>주문 날짜</th>
      <th>주문현황</th>
  </tr>
  <%if(!orderList.isEmpty()){
	  for(Order o : orderList){%>
  <tr>
      <td><input class="form-check-input" type="checkbox" id="checkboxNo" 
      				name="<%=o.getOrderNo() %>" aria-label="..."></td>
      <td><a href="<%=request.getContextPath()%>/admin/deliveryDetail.do?orderNo=<%=o.getOrderNo() %>"><%=o.getOrderNo() %></a></td>
      <td><%=o.getOrderName() %></td>
      <td><%=o.getOrderPhone() %></td>
      <td><%=o.getOrderAddress() %></td>
      <td><%=o.getOrderDate() %></td>
      <td><%=o.getOrderStatus() %></td>
  </tr>
  <%}
	  }%>
  </table>
</div>
	<div id="pageBar" class="container">
		<%=request.getAttribute("pageBar") %>
	</div>

<script>
	//체크박스 All 체크
	document.getElementById('checkboxAll').addEventListener('click', function() {
	  var checkboxes = document.querySelectorAll('#checkboxNo');
	  for (var checkbox of checkboxes) {
	    checkbox.checked = this.checked;
	  }
	});
	
	document.getElementById('checkboxNo').addEventListener('click',function(){
		var checkAll=document.getElementById('checkboxAll');
		checkAll.checked=false;
	});
	

	
	
</script>

<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="/views/admin/common/footer.jsp" %>