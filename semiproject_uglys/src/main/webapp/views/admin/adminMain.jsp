<%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Member loginMember=(Member)session.getAttribute("loginMember");
    %>
    <%if(loginMember!=null){ %>
<%@ include file="/views/admin/common/header.jsp" %>
<body>

<h1 align="center" style="margin-top:100px">메인페이지</h1>

</body>

<%@ include file="/views/admin/common/footer.jsp" %>
<%}%>