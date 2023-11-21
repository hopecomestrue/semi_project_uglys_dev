<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>
<%@ page import="com.veg.kth.community.model.dto.Recipe, java.util.List" %>

<%

	List<Recipe> recipes = (List<Recipe>)request.getAttribute("recipe");  

%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	p{
/* 	display:inline-block; */
	
	}
	.container_recipe_search{
	display: flex;
	flex-direction: column;
  	align-items: center;
    justify-content: center;
    height: 100vh;
	}
	
        
    button{
    display:inline-block;
    }
    
    label{
    
    width:120px;
    display:flex; 
    justify-content: flex-start; 
    align-items: center;
    margin-bottom: 5px;
    }
    
    li{
    
    margin-top: 10px;
    }
    
    button{
    margin-top: 10px;
    
    }
	
	
</style>

<section>
	<div class="container_recipe_search">
	<h1>레시피 관리</h1>
		<form>
		<ul class="list-group">
		<li>
		<label for="search_date">등록일</label>
		<input type="date" name="search_date">~<input type="date" name="search_date">
		</li>
		<li>
		<label for="search_date">작성자 구분</label>
		<select name="sort">
			<option>전체</option>
			<option>채소랑</option>
			<option>고객</option>
		</select>
		</li>
		<li>
		<label for="recipeTitle">레시피 이름</label>
		<input type="text" name="recipeTitle">
		</li>
		<li>
		<label for="category">카테고리</label>
		<input type="text" name="category">
		</li>
		<li>
		<label for="hashtag">해시태그</label>
		<input type="text" name="hashtag">
		</li>
		<li>
		<label for="hashtag">작성자 아이디</label>
		<input type="text" name="userId">
		</li>
		<li>
		<label for="hashtag">필수 재료</label>
		<input type="text" name="material_main">
		</li>
		</ul>
		<button>검색</button>	
		</form>
		
		
		<div>
		<br><br><br>
		<button type="button" class="btn btn-primary">등록</button>
		<button type="button" class="btn btn-primary">선택 삭제</button>
		<button type="button" class="btn btn-primary">일괄 삭제</button>
		<table class="table">
		<thead>
			<tr>
				<th>선택 버튼</th>
				<th>번호</th>
				<th>아이디</th>
				<th>구분</th>
				<th>레시피이름</th>
				<th>카테고리</th>
				<th>해시태그</th>
				<th>필수재료</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		<%if(!recipes.isEmpty()){ 
		for(Recipe r : recipes){
		%>
			<tr>
				<td><input type="checkbox" name="delete_check"></td>
				<td><%=r.getRecipeNo() %></td>
				<td>아이디 없음</td>
				<td>구분자도 없음</td>
				<td><%=r.getRecipeTitle() %></td>
				<td><%=r.getCategory() %></td>
				<td><%=r.getHashtag() %></td>
				<td><%=r.getMaterial() %></td>
				<td><%=r.getRecipeDate() %></td>
			</tr>
		<%}
		}%>
		</tbody>
		</table>
	</div>
	<p>페이징 처리</p>
	</div>
</section>
<%@ include file="/views/admin/common/footer.jsp" %>