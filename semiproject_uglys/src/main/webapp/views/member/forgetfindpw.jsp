<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.veg.hjj.member.dto.Member" %>
 <%
	Member member = (Member)request.getAttribute("members");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기완료</title>
</head>
<style>
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
}

.wrap {
    max-width: 360px;
    margin: 0 auto;
    margin-top: 50px;
    padding: 80px;
    border: 3px solid #ddd;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0,0,0,.1);
    text-align: center;
}
#userPw {
    margin-bottom: 20px; 
	}
button  {
    width: 100%;
    padding: 10px;
    background-color: #6c757d;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color .3s ease;
}

button:hover {
    background-color: #82ae46;
}
</style>
<body>
		<div class="wrap">
		<div id="userName">[<%=member.getMemberName()%>]님의 아이디</div><br>
		<div id="userPw">[<%=member.getMemberPw() %>] 입니다.</div>
		<button  onclick="location.assign('<%=request.getContextPath()%>/views/member/login.jsp')">로그인 하러가기</button>
		</div>




<!--footer부분  -->
     <hr>
        <p style="justify-content: center; display: flex;">
          상호명 : 주식회사 어글리스 | 대표 : 유병승 | 사업자등록번호 123-45-678901 | 소재지 : 서울특별시 금천구 가산디지털2로 95(가산동, km타워) 2층, 3층<br>
          통신판매업 신고번호 : 2023-가산-1312 | 제휴 및 납품 문의 : biz@uglys.co.kr | 농산물 납품 및 긴급구출 제보 : farm@uglys.co.kr<br>
          
                Copyright ⓒ 2023 주식회사 어글리즈 All rights reserved
        </p>  
</body>
</html>