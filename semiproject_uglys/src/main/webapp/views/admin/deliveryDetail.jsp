<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>
<%
	Member mem=(Member)request.getAttribute("mem");
	Order order=(Order)request.getAttribute("order");
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

      #btn_submit{
        margin-left: 79%;
      }

      .delivery-detail-user{
        width: 70%;
        margin : 0 auto;
      }

    </style>

<body>
	<%-- <form action="<%request.getContextPath()%>/admin/delchange.do" method="post"> --%>
<h1 style="text-align: center; margin-top: 5%;">배송 상세현황</h1>
<div class="delivery-detail-user">
<table class="table table-bordered">
    <tr>
        <th>주문 상세 번호</th>
        <td id="orderNo"><%=order.getOrderNo()%></td>
    </tr>
    <tr>
      <th>송장 번호</th>
      <td><input type="number" id="delNo" name="delivery-no" placeholder="송장번호 입력란" <%=order.getTrackingNumber()>0?"disabled":""%>
      <%if(order.getTrackingNumber()>0){ %>
      value="<%=order.getTrackingNumber()%>"
    <%} %>
      >
    <button type='button' id="del-update">수정하기</button>
    </td>
    </tr>
    <tr>
      <th>주문 아이디</th>
      <td><%=mem.getMemberId() %></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><%=order.getOrderName() %></td>
    </tr>
    <tr>
      <th>전화번호</th>
      <td><%=order.getOrderPhone() %></td>
    </tr>
    <tr>
      <th>상품 내용</th>
      <td>상품명, 수량</td>
    </tr>
    <tr>
        <th>주소</th>
        <td><%=order.getOrderAddress() %></td>
    </tr>
    <tr>
      <th>주문 날짜</th>
      <td><%=order.getOrderDate() %></td>
    </tr>
    <tr>
      <th>배송현황</th>
      <td>
        <select class="form-select form-select-lg mb-3" id="del-check" aria-label=".form-select-lg example">
            <option selected value="배송준비중">배송준비중</option>
            <option value="배송중">배송중</option>
            <option value="배송완료">배송완료</option>
          </select>
      </td>
    </tr>
    <tr>
      <th>결제 수단</th>
      <td><%=order.getPayment() %></td>
    </tr>    
    <tr>
      <th>총 금액</th>
      <td><%=order.getTotalPrice() %>원</td>
    </tr>    
  </table>
</div>
  <button type="submit" class="btn btn-primary" id="btn_submit">수정완료</button>
<!-- </form> -->

<script>
	//수정완료 누르면 table에 있는 값들을 ajax로 값 전송
	 document.getElementById('btn_submit').addEventListener('click',function(){
		var orderNo=document.getElementById('orderNo').innerText;
		var delNo=document.getElementById('delNo').value;
		var delCheck=document.getElementById('del-check').value;
		console.log(orderNo);
		console.log(delNo);
		console.log(delCheck);
		
		$.ajax({
			url : '<%=request.getContextPath()%>/admin/deliveryDetailEnd.do',
			type : 'POST',
			dataType: 'json',
			data : {
				orderNo : orderNo, //주문번호
				delNo : delNo, //송장번호
				delCheck : delCheck //배송상태 : 배송준비중,배송중,배송완료
			},
			success:function(res){
				alert('배송상태 수정완료');
			},
			error:function(){
				/* alert('배송상태 수정실패'); */
			}
		});
	});
	
	
	//송장 번호 수정하기 버튼 활성화
	document.getElementById('del-update').addEventListener('click',function(){
			var delNo=document.getElementById('delNo');
			var btn=document.getElementById('del-update');
			if(delNo.disabled){
				delNo.disabled=false;
				btn.innerHTML="수정하기";
			}else{
				delNo.disabled=true;
				btn.innerHTML="수정완료";
				alert('수정완료');
			}
		});
	
</script>


<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="/views/admin/common/footer.jsp" %>