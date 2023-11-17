<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
}

.login-container {
    max-width: 360px;
    margin: 0 auto;
    margin-top: 50px;
    padding: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0,0,0,.1);
}

h2 {
    text-align: center;
    font-size: 24px;
    color: #333;
    margin-bottom: 30px;
}

table {
    width: 100%;
}

table th {
    text-align: left;
    padding: 10px;
    color: #555;
}

table td {
    padding: 10px;
}

input[type="text"],
input[type="email"] {
    width: 100%;
    padding: 15px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

input[type="submit"] {
    width: 100%;
    padding: 15px;
    background-color: #6c757d;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color .3s ease;
}

input[type="submit"]:hover {
    background-color: #82ae46;
}
</style>
</head>
<body>
    <div class="login-container">
        <h2>아이디 찾기</h2>
        <form action="" method="post">
            <table>
                <tr>
                    <th>이름</th>
                    <td>
                        <input type="text" name="userName" required>
                    </td>
                </tr>
                
                <tr>
                    <th>이메일</th>
                    <td>
                        <input type="email" name="email" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button >아이디 찾기</button>
                    </td>
                </tr>
            </table>
        </form>
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