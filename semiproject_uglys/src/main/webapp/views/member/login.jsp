<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<meta name="viewport" content="width=device-width" initial-scale="1"> 

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<style>
.login-container {
    max-width: 360px;
    margin: 0 auto;
     margin-top: 50px;
    padding: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0,0,0,.1);
}

.login-container h2 {
    text-align: center;
    font-size: 24px;
    color: #333;
    margin-bottom: 30px;
   
}

.login-container input[type="text"],
.login-container input[type="password"] {
    width: 100%;
    padding: 15px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.login-container button {
    width: 100%;
    padding: 15px;
    background-color: #6c757d;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color .3s ease;
}

.login-container button:hover {
    background-color: #82ae46;
}

.login-links {
    margin-top: 20px;
    text-align: center;
}

.login-links a {
    color: #6c757d;
    text-decoration: none;
    margin: 0 10px;
    
}

.login-links a:hover {
    color: #5a6268;
}
</style>
</head>
<body>
    <div class="login-container">
        <h2>채소랑 로그인</h2>
	
       
        <form action="<%=request.getContextPath()%>/member/loginend.do" id="loginFrm" method="post">
            
            <input type="text" id="memberId" name="memberId" placeholder="아이디" required><br>
            <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호" required><br>
            <!-- <span class="fail" >입력하신 정보가 일치하지 않습니다.<br>다시 확인해 주세요<br> -->
            <label class="remember">
                <input type="checkbox" name="remember" id="remember">아이디 저장
            </label>
             <div id="error-message" style="color: red;" ></div>
            <button type="submit">로그인</button>
        </form>
       
        <div class="login-links">
            <a href="<%=request.getContextPath()%>/member/forgetid.do">아이디 찾기</a>
            <a href="<%=request.getContextPath()%>/member/forgetpw.do">비밀번호 찾기</a>
            <a href="<%=request.getContextPath()%>/member/enrollmember.do">회원가입</a>
            <hr>
        <div id="naverIdLogin" style="justify-content: center; display: flex;"  ></div>
        <hr>
        </div>
    </div>
   	 
   
    

    <hr>
        <p style="justify-content: center; display: flex;">
          상호명 : 주식회사 어글리스 | 대표 : 유병승 | 사업자등록번호 123-45-678901 | 소재지 : 서울특별시 금천구 가산디지털2로 95(가산동, km타워) 2층, 3층<br>
          통신판매업 신고번호 : 2023-가산-1312 | 제휴 및 납품 문의 : biz@uglys.co.kr | 농산물 납품 및 긴급구출 제보 : farm@uglys.co.kr<br>
          
                Copyright ⓒ 2023 주식회사 어글리즈 All rights reserved
              </p>
    
    
    
    
    
    
    
    <script type="text/javascript">
        const naverLogin = new naver.LoginWithNaverId(
            {
                clientId: "Y3ckks1s8Vmu5zOdIZ5R",
                callbackUrl: "http://localhost:8080/logintest/member/idduplicate.do",
                isPopup: false,
                loginButton: {color: "green", type: 1, height: 40}
            }
        );
        naverLogin.init();
</script>

<script>
	 const msg = '<%= request.getAttribute("msg") %>';
	    if (msg != null) {
	        document.getElementById('error-message').innerText = msg;
	    }
	</script>
</body>

</html>
