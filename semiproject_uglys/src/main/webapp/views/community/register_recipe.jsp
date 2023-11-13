<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

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

</style>

<section>
	<div class="container_recipe">
	<h4>레시피 작성</h4>
	<form action='<%=request.getContextPath()%>/asd' method="post" enctype="multipart/form-data">
		<input type="submit" value="완료">
		<p>
			반복적이거나 성의 없는 콘텐츠는 관리자에 의해<br>
			콘텐츠 삭제 후 적립금이 반환될 수 있습니다.
		</p>
		<input type="file" name="recipe_main_file"><br>
		<input type="text" name="recipe_title" maxlength="20" placeholder="레시피의 이름이 무엇인가요?"><br>
		<input type="text" name="recipe_explain" maxlength="240" placeholder="레시피에 대한 간단한 설명을 덧붙여 주세요.">
		<h4>소요시간</h4>
		<input type="radio" name="leadtime" value="15">15분 컷
		<input type="radio" name="leadtime" value="30">30분 컷
		<input type="radio" name="leadtime" value="45">45분 컷
		<input type="radio" name="leadtime" value="60+">60분 이상
		<h4>카테고리</h4>
		<select name="category_dept1" id="category_dept1">
			<option value="한식">한식</option>
			<option value="중식">중식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>
			<option value="분식">분식</option>
			<option value="퓨전">퓨전</option>
			<option value="베이킹">베이킹</option>
			
		</select>
		<select name="category_dept1" id="category_dept1">
			<option value="덮밥+볶음밥">덮밥,볶음밥</option>
			<option value="면요리">면요리</option>
			<option value="샐러드">샐러드</option>
			<option value="밑반찬">밑반찬</option>
			<option value="볶음요리">볶음요리</option>
			<option value="찌개+국">찌개,국</option>
			<option value="조림">조림</option>
			<option value="찜">찜</option>
			<option value="전골">전골</option>
			<option value="스프">스프</option>
		</select>
		<h4>해시태그</h4>
		
		<p>해시태그 직접 입력</p>
		
		<h4>기준량</h4>
		<div>
		<input type="button" value="-"><p>1</p><input type="button" value="+">
		<p>인분</p>
		</div>
		
		<h4>재료</h4>
		<select name="material_type" id="material_type">
			<option value="필수재료">필수재료</option>
			<option value="부재료">부재료</option>
			<option value="양념">양념</option>
		</select>
		<input type="text" name="material_name" maxlength="20" placeholder="ex)감자">
		<input type="text" name="material_capa" maxlength="10" placeholder="ex)1개">
		<input type="button" value="추가">
		
		<h4>만드는 방법</h4>
		<p>1번</p>
		<input type="text" name="procedure_comment" maxlength="150" placeholder="만드는 방법을 입력하세요.">
		<input type="file" name="procedure_file"><br>
		<input type="button" value="추가">
	</form>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>