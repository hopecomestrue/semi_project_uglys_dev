<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>
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
	
    table td{
    border: 1px solid forestgreen;
    text-align : center;
    /* text-align : left, center, right */
    vertical-align: top;
    /* vertical-align : top, middle ,bottom */
        }
        
    button{
    display:inline-block;
    
    }
	
</style>

<section>
	<div class="container_recipe_search">
	<h1>레시피 관리</h1>
		<form>
		<p>등록일</p>
		<input type="date" name="search_date">~<input type="date" name="search_date">
		<p>작성자 구분</p>
		<select>
			<option>채소랑</option>
			<option>고객</option>
		</select>
		<p>레시피 이름</p>
		<input type="text" name="recipeTitle">
		<p>카테고리</p>
		<input type="text" name="category">
		<p>해시태그</p>
		<input type="text" name="hashtag">
		<p>작성자 아이디</p>
		<input type="text" name="userId">
		<p>필수 재료</p>
		<input type="text" name="material_main">
		<button>검색</button>	
		</form>
		
		<button>등록</button>
		<button>선택 삭제</button>
		<button>일괄 삭제</button>
		
		<div>
		<table border="1">
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
			<tr>
				<td><input type="checkbox" name="delete_check"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	<p>페이징 처리</p>
	</div>
</section>
<%@ include file="/views/admin/common/footer.jsp" %>