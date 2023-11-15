<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String msg=(String)request.getAttribute("msg");
    	String loc=(String)request.getAttribute("loc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>메세지</title>
</head>
<body>
	<script>
		alert("<%=msg%>");
		location.replace("<%=request.getContextPath()%><%=loc%>");
	</script>
</body>
</html>