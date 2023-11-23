<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.net.*" %>
<%@ page import = "com.veg.hjj.member.*" %>
<%@ page import = "com.veg.ojy.mypage.*"%>
<%
	if(session.getAttribute("loginId") == null ){
		response.sendRedirect(request.getContextPath()+"/views/index.jsp");
		return;
	}
	String msg = null;
	//요청값 유효성 검사
	if(request.getParameter("memberId") == null || request.getParameter("memberId").equals("")){
		msg = "";
	} else if (request.getParameter("lastPw") == null || request.getParameter("lastPw").equals("")){
		
		msg = URLEncoder.encode("아이디 또는 비밀번호가 다릅니다","utf-8");
		response.sendRedirect(request.getContextPath()+"/views/member/mypage/memberCancleeation.jsp?msg="+msg);
		return;
	}
	
	String memberId = request.getParameter("memberId");
	String pw = request.getParameter("lastPw");
	
	int result = 0;
	if(result > 0){
		msg = URLEncoder.encode("탈퇴되었습니다","utf-8");
		response.sendRedirect(request.getContextPath()+"/views/index.jsp?msg="+msg);
		return;
	}
%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "com.veg.ojy.mypage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		boolean result =(boolean)request.getAttribute("result");
		String memberPw = (String)request.getAttribute("memberPw");
	%>
	
	<script>
	
	<%if(result){ %>
		alert('[<%=memberPw%>] 회원 탈퇴 성공');
	<%}else{ %>
		alert('회원 탈퇴를 실패였습니다.');
	<%} %>
	
	</script> 

	
</body>
</html>