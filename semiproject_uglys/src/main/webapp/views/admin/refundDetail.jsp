<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Member loginAdmin=(Member)session.getAttribute("loginMember");
    	Member mem=(Member)request.getAttribute("mem");
		Order refund=(Order)request.getAttribute("refund");
    %>
    <%if(loginAdmin!=null&&loginAdmin.getAdminCheck().equals("Y")){ %>
<%@ include file="/views/admin/common/header.jsp" %>
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
        margin-left: 80%;
      }
      
      .refund-detail-user{
        width: 70%;
        margin : 0 auto;
      }
      
    </style>

<body>
<!-- <form> -->

<div class="pcoded-main-container">
	<div class="pcoded-content">
		<div class="card">
                    <div class="card-header">
                        <h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">주문 환불 상세 현황</h1>
                    </div>
                    <div class="card-body table-border-style">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tr>
        <th>주문 상세 번호</th>
        <td id="refundNo"><%=refund.getOrderNo() %></td>
    </tr>
    <tr>
      <th>주문 아이디</th>
      <td><%=mem.getMemberId() %></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><%=refund.getOrderName() %></td>
    </tr>
    <tr>
      <th>전화번호</th>
      <td><%=refund.getOrderPhone() %></td>
    </tr>
    <tr>
      <th>상품 내용</th>
      <td>배추 3 포기,상추 300장</td>
    </tr>
    <tr>
        <th>주소</th>
        <td><%=refund.getOrderAddress() %></td>
    </tr>
    <tr>
      <th>주문 날짜</th>
      <td><%=refund.getOrderDate() %></td>
    </tr>
    <tr>
        <th>결제 수단</th>
        <td><%=refund.getPayment() %></td>
    </tr>    
    <tr>
        <th>총 금액</th>
        <td><%=refund.getTotalPrice() %></td>
    </tr>    
    <tr>
        <th>환불 사유</th>
        <td id="refund-reason">(테이블 컬럼 추가시 변경)</td>
    </tr>    
    <tr>
      <th>환불 응답</th>
      <td>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" id="refund-check">
            <option value="환불승인대기" <%=refund.getOrderStatus().equals("환불승인대기")?"selected":"" %>>환불승인대기</option>
            <option value="환불승인완료" <%=refund.getOrderStatus().equals("환불승인완료")?"selected":"" %>>환불승인완료</option>
            <option value="환불승인반려" <%=refund.getOrderStatus().equals("환불승인반려")?"selected":"" %>>환불승인반려</option>
          </select>
      </td>
    </tr>
                            </table>
                        </div>
  <button type="submit" class="btn btn-primary" id="btn_submit">수정완료</button>
                    </div>
                </div>
	</div>
	</div>
  <button type="submit" class="btn btn-primary" id="btn_submit">등록</button>
<!-- </form> -->
<script>
	//등록완료 하면 ajax로 환불상태 DB변경
	document.getElementById('btn_submit').addEventListener('click',function(){
		/* console.log('버튼은 눌림'); */
		var refundNo=document.getElementById('refundNo').innerText;
		var refundCheck=document.getElementById('refund-check').value;
		var refundReason=document.getElementById('refund-reason').innerText;
		
		/* console.log(refundNo);
		console.log(refundCheck);
		console.log(refundReason); */
		
		$.ajax({
			url : '<%=request.getContextPath()%>/admin/refundDetailEnd.do',
			type : 'post',
			dataType : 'json',
			data : {
				refundNo : refundNo, //환불주문번호
				refundCheck : refundCheck, //환불상태 : 환불승인대기,환불승인완료,환불승인반려
				refundReason : refundReason //환불사유
			},
			success:function(res){
				alert('환불완료');
			},
			error:function(err){
				alert('환불 수정실패');
				alert(err)
			}
		});
	});
	
	//토큰값 가져오는 메소드
	<%-- document.getElementById('getToken-btn').addEventListener('click',function(){
		var apiKey="1351426225816408";
		var secretKey="cfHurcVtJYllMUeKbWmEhhvu9CQmFEAutcrNomOiB0xv3OFhJnONYdPPjHSmLKiorN4fDHTIAyEuNReb";
		/* var token=document.getElementById('tokenValue').innerText; */
		
		/* console.log(apiKey);
		console.log(secretKey); */
		
		$.ajax({
			url : '<%=request.getContextPath()%>/admin/tokenget.do',
			type : 'post',
			dataType : 'json',
			data : {
				apiKey : apiKey, //api 키
				secretKey : secretKey //시크릿 키
			},
			success:function(data){
				console.log(data);
				alert('토큰 불러오기 성공');
				document.getElementById('tokenValue').innerText=data;
			},
			error:function(){
				alert('토큰 불러오기 실패');
			}
		});
	}); --%>
	
</script>


<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="/views/admin/common/footer.jsp" %>
<%}%>