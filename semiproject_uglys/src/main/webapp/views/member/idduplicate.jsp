<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>아이디 중복확인</title>
</head>
<body>
	<div id="checkId-container">
			[<span>000</span>]는 사용가능합니다.	
			<br><br>
			<button type="button" >닫기</button>

			[<span id="duplicated">000</span>]는 사용중입니다.
			<br><br>
			<!-- 아이디 재입력창 구성 -->
			<form action= method=>
				<input type="text" name="userId" id="userId">
				<input type="submit" value="중복검사" >
			</form>
	</div>
</body>
</html>