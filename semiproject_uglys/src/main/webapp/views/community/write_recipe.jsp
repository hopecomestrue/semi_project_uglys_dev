<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.veg.kth.community.model.dto.Hashtag,java.util.List,com.veg.kth.community.model.dto.Category" %>
<%

	
	List<Hashtag> hashtags = (List<Hashtag>)request.getAttribute("hashtags");
	List<Category> category = (List<Category>)request.getAttribute("category"); 

%>
<script src="https://unpkg.com/@yaireo/tagify"></script>
<style>
	.container_recipe{
	display: flex;
	flex-direction: column;
  	align-items: center;
    justify-content: center;
    height: 100vh;
	}
	
	input[type="text"]{
		width:300px;
	}
	
	input[type="submit"]{
		text-align:center;
		width:100px;
		background-color: #82ae46;
		color: white;
	
	}
	h4{
	margin-top: 20px;
	margin-bottom: 5px;
	
	}

/* 화살표 스핀 지우기 */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}


 p{
 margin-top: 10px;
 margin-bottom: 5px;
 
 }
 
 .container_recipe{
 	max-height: calc(150vh - 120px); /* 화면 높이에서 헤더와 푸터의 높이를 뺀 값으로 제한 */
    overflow-y: auto;

 }
 
</style>

<section>
	<div class="container_recipe">
	<h4>레시피 작성</h4>
	<form action="<%=request.getContextPath()%>/community/recipewriteend.do" id="myForm" method="post" enctype="multipart/form-data">
		<p style="text-align: center">
			반복적이거나 성의 없는 콘텐츠는 관리자에 의해<br>
			콘텐츠 삭제 후 적립금이 반환될 수 있습니다.
		</p>
		<input type="file" name="recipe_main_file" ><br>
		<input type="text" name="recipe_title" maxlength="20" placeholder="레시피의 이름이 무엇인가요?"><br>
		<input type="text" name="recipe_explain" maxlength="240" placeholder="레시피에 대한 간단한 설명을 덧붙여 주세요.">
		<h4>소요시간</h4>
		<input type="radio" name="leadtime" value="15">15분 컷
		<input type="radio" name="leadtime" value="30">30분 컷
		<input type="radio" name="leadtime" value="45">45분 컷
		<input type="radio" name="leadtime" value="60">60분 이상
		<h4>카테고리</h4>
		
		<select name="category_dept1" id="category_dept1" onchange="categoryChange(this);">
			<option>카테고리를 선택해 주세요.</option>
		<%if(!category.isEmpty()){ 
            		for(Category c : category){%>
			<option value="<%=c.getCategoryDept1()%>"><%=c.getCategoryDept1()%></option>	
			<%}
           }%>
		</select>
		<select name="category_dept2" id="category_dept2">
			<option>세부 카테고리를 선택해 주세요.</option>
		</select>

           
<script>
function categoryChange(e) {
	
	
	<%if(!category.isEmpty()){
	for(int i=0;i<category.size();i++){
	%>
	
	var good_<%=category.get(i).getCategoryDept1()%> = ["<%=category.get(i).getCategoryDept2()%>"];
	
	var target = document.getElementById("category_dept2");

	if(e.value == "<%=category.get(i).getCategoryDept1()%>") var d = good_<%=category.get(i).getCategoryDept1()%>;
	<%}
	}
	%>

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}
}
</script>
    
		<h4>해시태그</h4>
		<div class="tr_hashTag_area">
		<div class="form-group">
                <input type="hidden" value="" name="tag" id="rdTag" />
            </div>
				<%if(!hashtags.isEmpty()){ 
            		for(int i=0;i<6;i++){%>
                  <button type="button" name="hashtag"  id="hashtag" class="tag-cloud-link" onclick="toggleButton(this);">
                		#<%=hashtags.get(i).getHashtagValue()%>
                	</button>
                	<%} 
                	}%>
                 <div id="tag-list"></div>
                 <div class="form-group">
            	<input type="text" id="tag" size="7" placeholder="엔터로 해시태그를 등록해주세요." style="width: 300px;"/>
           </div>
         </div>
         <script>
         function toggleButton(button) {
				
        	 let $rdTag = $('.rdtag');
        	 
        	 console.log($rdTag.value);
        	 
        	 if($rdTag.value.includes(button.value)){
        	 $rdTag.value = "";
        	 alert("값 지움")
					        		 
        	 }else{
        	alert("값 넣음")
        	 $rdTag.value = button.value;
        		 
        	 }
	    	 
	    	
	    	}
        </script>
         
         
		<h4>기준량</h4>
		<div>
		<input type="button" value="-" onclick="minusbtn();">
		<input type="number" style="width:40px; height:40px;" name="capacity" id="capacity_ab" value='1' min='1' max='10'>
		<input type="button" value="+" onclick="plusbtn();">
		<p style="display:inline-block;">인분</p>
		</div>
		<div class="material_part">
		<h4 id="material">재료</h4>
		<select name="material_type" id="material_type">
			<option value="main">필수재료</option>
			<option value="sub">부재료</option>
			<option value="source">양념</option>
		</select><br>
		<input type="text" id="material_name" name="material_name" maxlength="20" placeholder="ex)감자">
		<input type="text" id="material_capa" name="material_capa" maxlength="10" placeholder="ex)1개">
		<input type="button" value="추가" onclick="addMaterial();">
		</div>
		<div class="procedure_part">
		<h4>만드는 방법</h4>
		<p id="procedure_no" name="procedure_no">1</p>
		<input type="text" id="procedure_comment" name="procedure_comment" maxlength="150" placeholder="만드는 방법을 입력하세요.">
		<input type="file" id="procedure_file" name="procedure_file">
		<input type="button" value="추가" onclick="addProcedure();">
		</div>
		<input type="hidden" name="member_no" value="52<%-- <%=loginMember.getMemberNo()%> --%>"> 
		<div>
		<input type="submit" id="lastBtn" value="완료">
		</div>
	</form>
	</div>
</section>
<script>
    $(document).ready(function () {
        var tag = {};
        var counter = 0;

        // 입력한 값을 태그로 생성한다.
        function addTag (value) {
            tag[counter] = value;
            counter++; // del-btn 의 고유 id 가 된다.
        }

        // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
        function marginTag () {
            return Object.values(tag).filter(function (word) {
                return word !== "";
            });
        }
    
        // 서버에 제공
        $("#tag-form").on("submit", function (e) {
            var value = marginTag(); // return array
            $("#rdTag").val(value); 

            $(this).submit();
        });

        $("#tag").on("keypress", function (e) {
            var self = $(this);

            //엔터나 스페이스바 눌렀을때 실행
            if (e.key === "Enter" || e.keyCode == 32) {

                var tagValue = self.val(); // 값 가져오기

                // 해시태그 값 없으면 실행X
                if (tagValue !== "") {

                    // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                    var result = Object.values(tag).filter(function (word) {
                        return word === tagValue;
                    })
                
                    // 해시태그가 중복되었는지 확인
                    if (result.length == 0) { 
                        $("#tag-list").append("<button class='tag-item' name='hashtag' >#"+tagValue+"<span class='del-btn' idx='"+counter+"'> x </span></button>");
                        addTag(tagValue);
                        self.val("");
                    } else {
                        alert("태그값이 중복됩니다.");
                    }
                }
                e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
            }
        });

        // 삭제 버튼 
        // 인덱스 검사 후 삭제
        $(document).on("click", ".del-btn", function (e) {
            var index = $(this).attr("idx");
            tag[index] = "";
            $(this).parent().remove();
        });
})
</script>
<script>
		function minusbtn(){
			let minus = document.getElementById('capacity_ab');
			if(minus.value>1){
				minus.value--;			
			}
		}
		
		function plusbtn(){
			let plus = document.getElementById('capacity_ab');
			if(plus.value<10){
				plus.value++;		
			}

		}
		
	    let count1 = 1;
	    let count2 = 1;
	    let addMaterial=()=>{

	        if(count1<6){
	        let $select = $(".material_part").append("<div><select name='material_type' id='material_type'> \
	            <option value='main'>필수재료</option> \
				<option value='sub'>부재료</option> \
				<option value='source'>양념</option> \
			</select>"
	         );

	         $select.append("<input type='text' id='material_name' name='material_name' maxlength='20' placeholder='ex)감자'> \
			<input type='text' id='material_capa' name='material_capa' maxlength='10' placeholder='ex)1개'></div>");
	        count1++;
	        }
	    }
	    
	    
	    let addProcedure=()=>{

	        if(count2<6){
	            count2++;
	            $(".procedure_part").append("<p id='procedure_no' name='procedure_no'>"+count2+"</p>\
	            <input type='text' id='procedure_comment' name='procedure_comment' maxlength='150' placeholder='만드는 방법을 입력하세요.'>\
	            <input type='file' id='procedure_file' name='procedure_file'>"
	            );
	        }

	    }
	    

	    
</script>

<%@ include file="/views/common/footer.jsp" %>