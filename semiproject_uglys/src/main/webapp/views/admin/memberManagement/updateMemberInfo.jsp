<%@page import="com.veg.hjj.member.dto.*"%>
<%@page import="com.veg.hjj.member.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//유효성 검사
	if(session.getAttribute("loginId") == null){
		// null값이 있을 경우 홈으로 이동
		response.sendRedirect(request.getContextPath()+"/views/admin/adminMain.jsp");
		return;
	}
	String id = (String)session.getAttribute("loginMember");
	// EmployeesDao 선언
/* /* 	MemberDao m = new MemberDao(); */
	// param 값 선언
	String cstmId = request.getParameter("cstmId");
	int cstmActive = Integer.parseInt(request.getParameter("cstmActive")); 
%>