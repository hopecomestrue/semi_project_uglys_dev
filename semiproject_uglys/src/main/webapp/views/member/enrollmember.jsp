<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    body {
         display: flex;
        justify-content: center;
        align-items: center;
        height: 120vh;
        background-color: #f5f5f5;
    }

    #enroll-container {
        width: 500px;
        margin: 0 auto;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }

    #enroll-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #82ae46;
    }

    #enroll-container table {
        width: 100%;
    }

    #enroll-container table th {
       
        padding: 10px;
        padding-right: 0;
        color: #555;
    }

    #enroll-container table td {
        padding: 10px;
        padding-left: 1px;
    }

    #enroll-container table td input[type="text"],
    #enroll-container table td input[type="password"],
    #enroll-container table td input[type="email"],
    #enroll-container table td input[type="tel"],
    #enroll-container table td select {
        width: 55%;
        padding: 5px;
        border: 1px solid #82ae46;
        border-radius: 5px;
    }

    #enroll-container table td input[type="button"],
    #enroll-container input[type="submit"],
    #enroll-container input[type="reset"] {
        margin-top: 10px;
        padding: 5px 10px;
        border: 0;
        background: #82ae46;
        color: #fff;
        border-radius: 5px;
        cursor: pointer;
    }

    #enroll-container table td input[type="button"]:hover,
    #enroll-container input[type="submit"]:hover,
    #enroll-container input[type="reset"]:hover {
        background: #5a8e2c;
    }

   #enroll-container form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #enroll-container form .button-group {
        display: flex;
        justify-content: space-evenly;
        width: 100%;
    }
     #enroll-container form div {
        width: 200%;
      
    }
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>


<body>
	<section id=enroll-container>
        <h2>회원 가입</h2>
        <form action="<%=request.getContextPath() %>/member/enrollMemberEnd.do" method="post" onsubmit="" enctype="multipart/form-data">
        <table>
       		<tr>
       			<td>
       			<div style="display: flex; flex-direction: column; align-items: center; justify-content: center;">
					<img id="preview" src="https://mblogthumb-phinf.pstatic.net/MjAyMDExMDFfMTgy/MDAxNjA0MjI4ODc1NDMw.Ex906Mv9nnPEZGCh4SREknadZvzMO8LyDzGOHMKPdwAg.ZAmE6pU5lhEdeOUsPdxg8-gOuZrq_ipJ5VhqaViubI4g.JPEG.gambasg/%EC%9C%A0%ED%8A%9C%EB%B8%8C_%EA%B8%B0%EB%B3%B8%ED%94%84%EB%A1%9C%ED%95%84_%ED%95%98%EB%8A%98%EC%83%89.jpg?type=w800" width="100px" height="100px">
					<label for="photoRegist"></label>
					<input type="file" id="photoRegist" name="photoRegist" style="display: none;">
					<input type="button" value="프로필 선택" onclick="document.getElementById('photoRegist').click();" />
					<br><br>
				</div>
       			</td>
       		</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" placeholder="4글자이상" name="memberId" id="memberId" value="" >
					<input type="button" value="중복 확인" name="memberId" onclick="fn_idduplicate();">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="memberPw" id="memberPw" onchange="check_pw()"><br>
					
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" id="memberPw2" onchange="check_pw()"><span id="check"></span><br>
				</td>
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="memberName" id="memberName" ><br>
				</td>
			</tr>
			<tr>
				<th>연령대</th>
				<td>
					<select name="ageRange">
					
						<option value="10세 이하">10세 이하</option>
						<option value="10~19세">10~19세</option>
						<option value="20~29세">20~29세</option>
						<option value="30~39세">30~39세</option>
						<option value="40대 이상">40대 이상</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email"><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
				</td>
			</tr>
			<tr>
			<th>주소</th>
			    <td>
			        <input type="text" id="address" name="address" readonly />
			        <input type="button" id="address_search" value="검색" >
			    </td>
			</tr>
			<tr>
    			<th></th>
    				<td><input type="text" name="address_detail"  placeholder="상세주소 입력"/></td>
			</tr>  
			<tr>
				<td>
					<div>
					<label for="id_a"><input type="checkbox" name="all" id="id_a" > 전체동의</label><br>
		        	<label for="id_b"><input type="checkbox" name="ckbox1" id="id_b" value="N"> [필수]이용약관 동의</label><br>
		       		<label for="id_c"><input type="checkbox" name="ckbox2" id="id_c" value="N"> [필수]개인정보 제3자 제공 동의</label><br>
		        	<label for="id_d"><input type="checkbox" name="ckbox3" id="id_d" value="N"> [선택]정보·혜택 수신 동의</label><br>
		       		</div>
	       		</td>
			</tr>
		</table>
		<div class="button-group">
			<input type="submit" value="회원가입">
			<input type="reset" value="취소">
		</div>
        </form>
    </section>
  
    

<script>
//개인정보 전체선택
   window.onload = function(){
	    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	    for (var i=0; i<checkboxes.length; i++) {
	        checkboxes[i].addEventListener('change', function() {
	            this.value = this.checked ? 'Y' : 'N';
	        });
	    }
    }
    document.addEventListener('DOMContentLoaded', () => {
        const ckTag = document.getElementById('id_a')
        const evtBtnTag1 = document.getElementById('id_b')
        const evtBtnTag2 = document.getElementById('id_c')
         const evtBtnTag3 = document.getElementById('id_d')
     
       
        
        ckTag.addEventListener('click', (event) => {

            const chckValue = event.currentTarget.checked;

            evtBtnTag1.checked = chckValue
            evtBtnTag2.checked = chckValue
            evtBtnTag3.checked = chckValue
            ckTag.checked = chckValue

        })

        evtBtnTag1.addEventListener('click', (event) => {
            if(event.currentTarget.checked == false){
                ckTag.checked = false;
            }
        })
        evtBtnTag2.addEventListener('click', (event) => {
            if(event.currentTarget.checked == false){
                ckTag.checked = false;
            }
        })
        evtBtnTag3.addEventListener('click', (event) => {
            if(event.currentTarget.checked == false){
                ckTag.checked = false;
            }
        })
       ckTag.addEventListener('click', (event) => {
            if(event.currentTarget.checked == false){
                ckTag.checked = false;
            }
        })
    })
</script>
<script>
 //아이디 중복확인
	const fn_idduplicate=()=>{
		const memberId=$("#memberId").val().trim();
		if(memberId.length>=4){
			const child=open("<%=request.getContextPath()%>/member/idduplicate.do?memberId="+memberId,
				"_blank","width=300,height=200");
		}else{
			alert("아이디는 4글자이상 입력하세요");
			$("#memberId").focus();
		}
	
		
		}
</script>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address_search").addEventListener("click", function(){ 
        new daum.Postcode({
            oncomplete: function(data) { 
                document.getElementById("address").value = data.address; 
                document.querySelector("input[name=address_detail]").focus(); 
            }
        }).open();
    });
}
</script>
<script>
// 프로필 사진 
document.getElementById("photoRegist").addEventListener("change", function(e){
    let reader = new FileReader();
    reader.onload = function(e){
        document.getElementById("preview").setAttribute('src', e.target.result);
    }
    reader.readAsDataURL(e.target.files[0]);
});
</script>

 <script>
 //비밀번호 관련
      function check_pw(){
    	 
          var password = document.getElementById('memberPw').value;
          var SC = ["!","@","#","$","%"];
          var check_SC = 0;
          var reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
  			
          var password =$("#memberPw").val();
  			if( !reg.test(password) ) {
  		    alert("비밀번호 영문자,특수기호,숫자를 반드시 포함해야합니다.!!");
  		    $("#memberPw").val("");
  		    $("#memberPw2").val("");
  		    $("#memberPw").focus();
  		    return false;
          
          }
          if(document.getElementById('memberPw').value !='' && document.getElementById('memberPw2').value!=''){
              if(document.getElementById('memberPw').value==document.getElementById('memberPw2').value){
                  document.getElementById('check').innerHTML='일치.'
                  document.getElementById('check').style.color='blue';
              }
              else{
                  document.getElementById('check').innerHTML='불일치.';
                  document.getElementById('check').style.color='red';
              }
          }
        }
    </script>
</body>
</html>