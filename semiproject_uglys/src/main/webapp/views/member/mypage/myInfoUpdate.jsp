<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css" />
		<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/open-iconic-bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/animate.css">
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/owl.carousel.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/owl.theme.default.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/magnific-popup.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/aos.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/ionicons.min.css">
	
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/bootstrap-datepicker.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/jquery.timepicker.css">
	
		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/flaticon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/icomoon.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/style.css">
		<style>
		</style>
</head>
<body>
    <div class="updatePassword-container">
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
                    <div class="login-form">
                        <h2>비밀번호 수정</h2>
                        <form name="updatePwdFrm" action="<%=request.getContextPath() %>/updateInfoend.do" method="post" >
                            <div class="group-input">
                                <input type="hidden" name="memberId"value="<%=request.getParameter("memberId") %>"><!-- 세션값아이디 히든으로 넘기기 -->
                            </div>
                            <div class="group-input">
                                <label for="username">기존 비밀번호</label>
                                <input type="password" name="memberPw" placeholder="비밀번호" required>
                            </div>
                            <div class="group-input">
                                <label for="pass">변경할 비밀번호</label>
                                <input type="password" name="password_new" placeholder="비밀번호" required>
                            </div>
                            <div class="group-input">
                                <label for="pass">변경할 비밀번호 확인</label>
                                <input type="password" name="password_chk" required placeholder="비밀번호 재확인" required>
                                <span id="result"></span>
                            </div><br>
                            <input type="submit" class="primary" onclick="return fn_passwordvalidate();" value="변경">
                            <input type="button" class="primary" value="닫기">
                        </form>
                    </div>
                </div>
            </div>
    </div>
   			<script src="/js/jyjs/js/jquery.min.js"></script>
			<script src="/js/jyjs/js/browser.min.js"></script>
			<script src="/js/jyjs/js/breakpoints.min.js"></script>
			<script src="/js/jyjs/js/util.js"></script>
			<script src="/js/jyjs/js/main.js"></script>
<script>
const passwordck=document.getElementById("password_chk");
passwordck.addEventListener("keyup",e=>{
   const pw=document.getElementById("password_new").value;
   const pwck=e.target.value;
   let msg,color,result
   const $result=document.getElementById("result");
   const $submit=document.querySelector("input[type=submit]");
   if(pwck.length>=8){
      if(pw==pwck){
         msg="일치합니다.";
         color="lightblue";
         result=false;
      /*   $submit.disabled=false; */
      }else{
         msg="일치하지않습니다.";
         color="yellow";
         result=true;
      }
      $result.innerText=msg;
      $result.style.color=color;
      $submit.disabled=result;
   }else{
      $result.innerText="";
      $submit.disabled=true;
   }
});
    const fn_passwordvalidate=()=>{
    	 window.location.href='<%=request.getContextPath()%>/updateInfo.do';
    }
   </script>
</body>
</html>