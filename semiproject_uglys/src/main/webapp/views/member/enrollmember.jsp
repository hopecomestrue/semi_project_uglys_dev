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
        <form action="" method="post" onsubmit="" >
        <table>
       		<tr>
       			<td>
       			<div style="display: flex; flex-direction: column; align-items: center; justify-content: center;">
					<img id="preview" src="https://mblogthumb-phinf.pstatic.net/MjAyMDExMDFfMTgy/MDAxNjA0MjI4ODc1NDMw.Ex906Mv9nnPEZGCh4SREknadZvzMO8LyDzGOHMKPdwAg.ZAmE6pU5lhEdeOUsPdxg8-gOuZrq_ipJ5VhqaViubI4g.JPEG.gambasg/%EC%9C%A0%ED%8A%9C%EB%B8%8C_%EA%B8%B0%EB%B3%B8%ED%94%84%EB%A1%9C%ED%95%84_%ED%95%98%EB%8A%98%EC%83%89.jpg?type=w800" width="100px" height="100px">
					<label for="profilePic"></label>
					<input type="file" id="profilePic" name="profilePic" style="display: none;">
					<input type="button" value="이미지 수정" onclick="document.getElementById('profilePic').click();" />
					<br><br>
				</div>
       			</td>
       		</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" placeholder="4글자이상" name="userId" id="userId_" >
					<input type="button" value="중복 확인" onclick="fn_idduplicate();">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="password" id="password_" ><br>
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" id="password_2" ><br>
				</td>
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="userName" id="userName" ><br>
				</td>
			</tr>
			<tr>
				<th>연령대</th>
				<td>
					<select>
						<option>선택 안함</option>
						<option>10세 미만</option>
						<option>10~19세</option>
						<option>20~29세 미만</option>
						<option>30~39세 미만</option>
						<option>40대 이상</option>
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
					<label for="id_a"><input type="checkbox" name="all" id="id_a"> 전체동의</label><br>
		        	<label for="id_b"><input type="checkbox" name="ckbox" id="id_b"> [필수]개인정보 사용 동의</label><br>
		       		<label for="id_c"><input type="checkbox" name="ckbox" id="id_c"> [필수]개인정보 수집 및 이용에 동의</label><br>
		        	<label for="id_d"><input type="checkbox" name="ckbox" id="id_d"> [선택]정보·혜택 수신 동의</label><br>
		       		</div>
	       		</td>
			</tr>
		</table>
		<div class="button-group">
			<input type="submit" value="가입">
			<input type="reset" value="취소">
		</div>
        </form>
    </section>
    <body>
    
</body>
<script>
 //개인정보 전체선택
   
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
        evtBtnTag1.addEventListener('click', (event) => {
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

 //아이디 중복확인
	const fn_idduplicate=()=>{
		const userId=$("#userId_").val().trim();
		if(userId.length>=4){
			const child=open("<%=request.getContextPath()%>/member/idduplicate.do?userId="+userId,
				"_blank","width=300,height=200");
		}else{
			alert("아이디는 4글자이상 입력하세요");
			$("#userId_").focus();
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
// 프로필 사진 미리보기 기능
document.getElementById("profilePic").addEventListener("change", function(e){
    let reader = new FileReader();
    reader.onload = function(e){
        document.getElementById("preview").setAttribute('src', e.target.result);
    }
    reader.readAsDataURL(e.target.files[0]);
});

</script>
</body>
</html>