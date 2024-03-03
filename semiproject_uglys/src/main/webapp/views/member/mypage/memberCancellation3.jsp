<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "com.veg.ojy.mypage.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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