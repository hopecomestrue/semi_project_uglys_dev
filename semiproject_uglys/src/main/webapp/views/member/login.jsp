<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/views/common/header.jsp" %>
    <%
    	String msg=(String)request.getAttribute("msg");
    %>
    <%
    	Cookie[] cookies=request.getCookies();	
    	String saveId=null;
    	if(cookies!=null){
    		for(Cookie c:cookies){
	    		String name=c.getName();
	    		
	    		
	    		if(name.equals("saveId")){
	    			saveId=c.getValue();
	    			break;
	    		}
    			
    		}
    	}
    %>
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
            
            <input type="text" id="memberId" name="memberId" placeholder="아이디" 
            		value="<%=saveId!=null?saveId:"" %>" required><br>
            <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호" required><br>
            
            <label class="saveId">
                <input type="checkbox" name="saveId" id="saveId"
                <%=saveId!=null?"checked":"" %>>아이디 저장
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
   	 <!--카카오 API  -->
   	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.5.0/kakao.min.js"
  integrity="sha384-kYPsUbBPlktXsY6/oNHSUDZoTX6+YI51f63jCPEIPFP09ttByAdxd2mEjKuhdqn4" crossorigin="anonymous"></script>
<script>
  Kakao.init('88511cd73e5b8324cd21c703d8870f46'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>


<script>
Kakao.init('88511cd73e5b8324cd21c703d8870f46');

  function loginWithKakao() {
    Kakao.Auth.authorize({
    	 redirectUri: 'http://localhost:9090/semiproject_uglys/member/enrollmember.do'
    });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(memberName) {
    var parts = document.cookie.split(memberName + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
  window.onload = function() {
	  var token = getCookie('authorize-access-token');

	  if(token) {
	    Kakao.Auth.setAccessToken(token);

	    // 사용자 정보 요청
	    Kakao.API.request({
	      url: '/v2/user/me',
	      success: function(res) {
	        // 회원가입 폼에 사용자 정보 입력
	        document.getElementById('memberId').value = res.id;
	        document.getElementById('email').value = res.kakao_account.email;
	      }
	     
	    });
	  }
	}
</script>
   
    

















    <hr>
    <p style="justify-content: center; display: flex;">
      상호명 : 주식회사 어글리스 | 대표 : 유병승 | 사업자등록번호 123-45-678901 | 소재지 : 서울특별시 금천구 가산디지털2로 95(가산동, km타워) 2층, 3층<br>
      통신판매업 신고번호 : 2023-가산-1312 | 제휴 및 납품 문의 : biz@uglys.co.kr | 농산물 납품 및 긴급구출 제보 : farm@uglys.co.kr<br>
      
            Copyright ⓒ 2023 주식회사 어글리즈 All rights reserved
    </p>
    
    
<script>
	 const msg = '<%= msg!=null? msg:"" %>';
	    if (msg != '') {

	        document.getElementById('error-message').innerText = msg;
	    }
	    
	</script>
</body>

</html>
