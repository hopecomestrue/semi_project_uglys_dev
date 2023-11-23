<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
<style>
	body{
		text-align: center;
	}
</style>
</head>
<body>
	<%-- <h1 style="color:red"><%=exception.getMessage() %></h1> --%>
	<img src="<%=request.getContextPath() %>/images/funny-error-404-background-design_1167-219.avif" alt="에러화면" width="770" height="770">
	<script>
		setTimeout(()=>{
			location.replace("<%=request.getContextPath()%>");
		},2000)
	</script>
</body>
</html>