<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<meta name="viewport" content="width=device-width" initial-scale="1"> 

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f5f5f5;
    }

    .login-container {
        width: 320px;
        padding: 16px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }

    .login-container h2 {
        text-align: center;
        color: #82ae46;
        margin-bottom: 30px;
        font-weight: 500;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #82ae46;
        margin-bottom: 20px;
        box-sizing:border-box;
        border-radius: 4px;
    }

    .login-container button {
        width: 100%;
        padding: 12px;
        background-color: #82ae46;
        border: 0;
        box-sizing: border-box;
        cursor: pointer;
        font-weight: bold;
        color: #fff;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .login-container button:hover {
        background-color: #5a8e2c;
    }

    .login-links {
        text-align: center;
        margin-top: 12px;
        font-size: 12px;
    }

    .login-links a {
        margin: 0 10px;
        color: #82ae46;
        text-decoration: none;
    }
    
    .login-links a:hover {
        text-decoration: underline;
    }
     .checkId {
        font-size: 12px;
        color: #555;
    }

    .checkId input[type="checkbox"] {
        width: 13px;
        height: 13px;
        vertical-align: bottom;
    }
    .kakao-login-btn {
    display: inline-block;
    width: 40px;
    height: 40px;
    line-height: 40px;
    border-radius: 50%;
    background-color: #FEE500;
    text-align: center;
    color: #3C1E1E;
    font-weight: bold;
    cursor: pointer;
    margin-left: 10px; /* 필요한 경우 마진 조정 */
}
</style>
</head>
<body>
    <div class="login-container">
        <h2>채소랑 로그인</h2>
        <form action="" method="post">
            <div id="naverIdLogin"></div>
            <div id="kakaoIdLogin"  class="kakao-login-btn"></div>
            <input type="text" id="username" name="username" placeholder="아이디" required><br>
            <input type="password" id="password" name="password" placeholder="비밀번호" required><br>
            <label class="checkId">
                <input type="checkbox" name="remember">아이디 저장
            </label>
            <button type="submit">로그인</button>
        </form>
        <div class="login-links">
            <a href="<%=request.getContextPath()%>/member/forgetid.do">아이디 찾기</a>
            <a href="<%=request.getContextPath()%>/member/forgetpw.do">비밀번호 찾기</a>
            <a href="<%=request.getContextPath()%>/member/enrollmember.do">회원가입</a>
        </div>
    </div>
    <script type="text/javascript">
        const naverLogin = new naver.LoginWithNaverId(
            {
                clientId: "Y3ckks1s8Vmu5zOdIZ5R",
                callbackUrl: "http://localhost:8080/logintest/member/idduplicate.do",
                isPopup: false,
                loginButton: {color: "green", type: 2, height: 40}
            }
        );
        naverLogin.init();
    </script>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
    Kakao.init('88511cd73e5b8324cd21c703d8870f46');
    document.getElementById('kakaoIdLogin').onclick = function() {
        Kakao.Auth.login({
            success: function(authObj) {
                Kakao.API.request({
                    url: '/v2/user/me',
                    success: function(res) {
                        console.log(res);
                    },
                    fail: function(error) {
                        console.log(error);
                    }
                });
            },
            fail: function(err) {
                console.log(err);
            }
        });
    };
</script>
</body>
</html>
