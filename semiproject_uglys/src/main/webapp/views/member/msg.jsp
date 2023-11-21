<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String msg=(String)request.getAttribute("msg");
		String loc=(String)request.getAttribute("loc");
		String script=(String)request.getAttribute("script");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지</title>
</head>
<body>

<script>
	alert("<%=msg%>");
	<%=script!=null?script:""%>
	location.assign("<%=request.getContextPath()%><%=loc%>");
</script>



</body>
</html>