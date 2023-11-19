<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<style>
    div#updatePassword-container{
        background:lightpink;
    }
    div#updatePassword-container table {
        margin:0 auto;
        border-spacing: 20px;
    }
    div#updatePassword-container table tr:last-of-type td {
        text-align:center;
    }
</style>
</head>
<body>
    <div id="updatePassword-container">
      <form name="updatePwdFrm" action="<%=request.getContextPath() %>/updateInfoend.do"
       method="post" >
       <input type="hidden" name="memberId" value="<%=request.getParameter("memberId") %>" >
         <table>
            <tr>
               <th>현재 비밀번호</th>
               <td><input type="password" name="memberPw" id="memberPw" required></td>
            </tr>
            <tr>
               <th>변경할 비밀번호</th>
               <td>
                  <input type="password" name="password_new" id="password_new" required>
               </td>
            </tr>
            <tr>
               <th>비밀번호 확인</th>
               <td>   
                  <input type="password" id="password_chk" required><br>
                  <span id="result"></span>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="submit" value="수정하기" class="primary" onclick="return fn_passwordvalidate();" 
                  disabled/>&nbsp;
                  <input type="button" value="닫기" />                  
               </td>
            </tr>
         </table>
         
      </form>
   </div>
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
               color="lime";
               result=false;
               /* $submit.disabled=false; */
            }else{
               msg="일치하지않습니다.";
               color="yellow";
               result=true;
            }
            const $result=document.getElementById("result");
            $result.innerText=msg;
            $result.style.color=color;
            $submit.disabled=result;
         }else{
            $result.innerText="";
            $submit.disabled=true;
         }
      });
    const fn_passwordvalidate=()=>{
       
       
    }
   </script>
</body>
</html>