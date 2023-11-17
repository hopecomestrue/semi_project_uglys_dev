<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>에러페이지</title>
</head>
<body>
<h1 style="color:red"><%=exception.getMessage() %>
</h1>
<img src="<%=request.getContextPath() %>/images/access.jpeg" alt="에러화면" width="500" height="500">
<h3>3초 후에 메인화면으로 이동합니다.</h3>
<script>
    setTimeout(() => {
        location.replace("<%=request.getContextPath()%>");
    }, 3000)
</script>
</body>
</html>