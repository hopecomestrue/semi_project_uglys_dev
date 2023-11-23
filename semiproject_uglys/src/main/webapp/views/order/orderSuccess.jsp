<%@page import="com.veg.ksj.order.model.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%
	Order order=(Order)request.getSession().getAttribute("order");
%>


<style>
      .delivery-detail-user{
        width: 60%;
        margin : 0 auto;
      }
      
      .buy-confirm-btn{
      	text-align: center;
      }
	
    </style>

<body>
	<%-- <form action="<%request.getContextPath()%>/admin/delchange.do" method="post"> --%>
<h1 style="text-align: center; margin-top: 5%;">주문 완료</h1>
<div class="delivery-detail-user">
<form action="<%=request.getContextPath()%>/myInfo.do" method="post">
<%if(order!=null){ %>
<table class="table table-bordered">
    <tr>
       <th>주문 번호</th>
       <td id="orderNo"><%=order.getOrderNo()%></td>
    </tr>
    <tr>
      <th>주문자</th>
      <td><%=order.getOrderName()%></td>
    </tr>
    <tr>
      <th>전화번호</th>
      <td><%=order.getOrderPhone() %></td>
    </tr>
    <tr>
        <th>주소</th>
        <td><%=order.getOrderAddress() %></td>
    </tr>
    <tr>
      <th>상품 내용</th>
      <td>상품명, 수량</td>
    </tr>
    <tr>
      <th>총 금액</th>
      <td><%=order.getTotalPrice() %></td>
    </tr>    
  </table>
  <%} %>
  <div class="buy-confirm-btn">
  <button type="submit" class="btn btn-primary btn-lg" id="buy-confirm">구매내역 보기</button>
  </div>
</div>
</form>


<%@ include file="/views/common/footer.jsp" %>