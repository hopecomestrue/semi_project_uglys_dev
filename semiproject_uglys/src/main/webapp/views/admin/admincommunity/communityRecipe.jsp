<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>
<%@ page import="com.veg.kth.community.model.dto.*, java.util.List, com.veg.hjj.member.dto.Member" %>

<%

	List<Recipe> recipes = (List<Recipe>)request.getAttribute("recipes");  
	List<Member> members = (List<Member>)request.getAttribute("members"); 
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
	
	.bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }

      .bd-mode-toggle {
        z-index: 1500;
      }

      .bd-mode-toggle .dropdown-menu .active .bi {
        display: block !important;
      }
      
      .admin-title{
        color: black;
        text-decoration: none;
      }

      .search_3{
        align-items: center;
        display: flex;
        justify-content: right;
        margin-right: 2%;
        margin-bottom: 1%;
      }

      .delivery-check{
      
      }

      .delivery-tb{
        width: 80%;
        margin: 0 auto;
      }

      .delivery-paging{
        margin: 5%;
      }
</style>

<section>
	<div class="container_recipe_search">
	<h1>레시피 관리</h1>
		<form action="<%=request.getContextPath()%>/admin/recipeSearch.do" id="myForm" method="post">
		<ul class="list-group">
		<li>
		<label for="search_date">등록일</label>
		<input type="date" name="search_date_start">~<input type="date" name="search_date_end">
		</li>
		<li>
		<label for="searchType">검색 구분</label>
		<select name="searchType">
			<option value="recipe_title">레시피 이름</option>
			<option value="category_dept1">카테고리</option>
			<option value="hashtag_value">해시태그</option>
			<option value="member_no">아이디</option>
			<option value="material_type">메인 재료</option>
		</select>
		<label for="searchContent"></label>
		<input type="text" name="searchContent">
		</li>
		</ul>
		<input type="submit" value="검색" >
		</form>
		
		
		<div>
		<br><br><br>
		<button type="button" class="btn btn-primary">등록</button>
		<button type="button" class="btn btn-primary">선택 삭제</button>
		<button type="button" class="btn btn-primary">일괄 삭제</button>
		<table class="table table-bordered">
		<thead>
			<tr>
				<th><input class="form-check-input" type="checkbox" id="checkboxAll" value="" aria-label="..." ></th>
				<th>번호</th>
				<th>아이디</th>
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
				<td><a href="<%=request.getContextPath()%>/admin/recipedetail.do"><%=r.getRecipeNo() %></a></td>
				<td><%for(Member m : members){%>
				<%if(r.getMember_no()== m.getMemberNo()){%>
				<%=m.getMemberId() %>
				<%}
				}%>
				</td>
				<td><%=r.getRecipeTitle() %></td>
				<td><%=r.getCategory().getCategoryDept1() %>/<%=r.getCategory().getCategoryDept2() %></td>
				<%List<Hashtag> hashtag = r.getHashtag(); %>
				<td><%for(Hashtag h : hashtag){ %>
				#<%=h.getHashtagValue() %>
				<%} %></td>
				<td><%List<Material> material = r.getMaterial();
				for(Material m : material){ %>
				<%if(m.getMaterialType().equals("MAIN")){ %>
				#<%=m.getMaterialName() %>
				<%}
				}%></td>
				<td><%=r.getRecipeDate() %></td>
			</tr>
		<%}
		}%>
		</tbody>
		</table>
	</div>
<%-- 	<div id="pageBar" class="container">
		<%=request.getAttribute("pageBar") %> --%>
	</div>
	</div>
</section>
<%@ include file="/views/admin/common/footer.jsp" %>