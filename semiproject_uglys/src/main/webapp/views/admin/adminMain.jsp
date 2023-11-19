 <%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Member loginAdmin=(Member)session.getAttribute("loginAdmin");
    %>
    <%if(loginAdmin!=null&&loginAdmin.getAdminCheck().equals("Y")){ %>
<%@ include file="/views/admin/common/header.jsp" %>
<body>

<h1 align="center" style="margin-top:100px">메인페이지</h1>

</body>

<%@ include file="/views/admin/common/footer.jsp" %>
<%}%>