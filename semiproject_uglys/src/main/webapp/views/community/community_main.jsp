<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.veg.kth.community.model.dto.*, java.util.List,com.veg.kth.community.model.dto.Hashtag, com.veg.hjj.member.dto.* " %>
<%

	List<Recipe> recipes = (List<Recipe>)request.getAttribute("recipes");
	List<Member> members = (List<Member>)request.getAttribute("members"); 

%>
<style>
/* Section */
.review-section {
  display: flex;
  justify-content: center;

  width: 100%;
  background: #f5f5f5;
  padding: 80px 0;
}

.review-section .review-items {
  width: 1340px;

  display: flex;
  flex-wrap: wrap;
}
.review-section .review-items li {
  background: white;
  width: 400px;
  height: 500px;
  box-shadow: 3px 3px 15px 0 rgba(211, 211, 211, 0.62);
  /* border: 2px solid crimson; */
  padding: 30px;
  box-sizing: border-box;
  margin: 0 auto;
  margin-bottom: 20px;
}
.review-section .img-area {
  width: 330px;
  height: 220px;
  object-fit: cover;
}
.review-section .img-area img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.review-section .icon-area {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}
.review-section .icon-area .i1 {
  width: 30px;
  height: 30px;
  object-fit: cover;
}
.review-section .review-items li .icon-area .i2 {
  width: 82px;
  height: 14px;
  object-fit: cover;
  margin-top: 5px;
}
.review-section .review-items li .desc-area {
  height: 74px;
  margin-top: 14px;

  /* text 여러 줄, 말 줄임표 기호 넣기 */
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}
.review-section .review-items li .desc-area p {
  font-size: 16px;
  font-weight: 300;
}
.review-section .review-items li .info-area {
  width: 100%;
  text-align: center;
  margin-top: 10px;
}
.review-section .review-items li .info-area h6 {
  font-size: 12px;
  font-weight: 300;
  color: #333;
}
.review-section .review-items li .info-area .line {
  width: 100%;
  height: 1px;
  background-color: #333;
  margin: 5px 0;
}
.review-section .review-items li .info-area h5 {
  font-size: 16px;
  font-weight: 500;
  color: #ff6741;
}

.review-section .article-line {
  width: 100%;
  height: 1px;
  background-color: #d2d2d2;
  margin: 50px 0 20px 0;
}
.review-section .more-review-btn {
  display: block;
  margin: 0 auto;
  width: 200px;
  height: 50px;
  background-color: #ff6741;
  font-size: 20px;
  font-weight: 500;
  color: white;
  cursor: pointer;
  
  .container_recipe_search{
	display: flex;
	flex-direction: column;
  	align-items: center;
    justify-content: center;
	}
	
	
	.float-button-container {
	z-index: 1000;
	position: fixed;
	transform: translate(-50%, 0%);
	left: 50%;
	bottom: 30px;

	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-around;
	padding:0 10px;

	background: white;
	height: 40px;
	box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.2);
	border:1px solid #e9e9e9;
	border-radius: 30px;
	text-decoration: none !important;

}

.float-button {
	display: flex;
	align-items: center;
	padding:0 20px;
	background-color:#82ae46

	cursor: pointer;
	color:#2b2b2b !important;
	font-size: 13px;
	text-decoration: none !important;
	white-space: nowrap;
	font-weight: bold;
	transition: 0.5s;
}

.float-button:hover {
	transform: translate(0%, -20%);
}

.float-button-image {
	height: 20px;
	margin-right:5px;
}


}

</style>
      <div class="container_recipe_search">
        <div class="row">
          <div >
            <div class="sidebar-box" >
            <!-- <h3 style="text-align:center;" >오늘의 레시피는?</h3> -->
              <%-- <form action="#" class="search-form">
                <div class="form-group">
                  <span class="icon ion-ios-search"></span>
                  <input type="search" id="searchtag" list="data" class="form-control" placeholder="ex) 감자">
                	<datalist id="data"></datalist>
                </div>
              </form>
              <div class="sidebar-box ftco-animate">
                <div class="tagcloud">
                <%if(!recipes.isEmpty()){ 
            		for(Recipe r : recipes){%>
                  <% for(Hashtag h : r.getHashtag()){ %>
                  <a href="" class="tag-cloud-link">
                		#<%=h.getHashtagValue()%>
                	</a>
                	<%} %>
                 <%}
            	}%> --%>
                </div>
              </div>
            </div>
        </div>
       <div class="float-button-container" 
       		style="text-align: right; z-index: 1000;
			position: fixed;
			transform: translate(-50%, 0%);
			left: 90%;
			bottom: 70%;
		
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: space-around;
			height: 40px;
			box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.2);
			border:1px solid #e9e9e9;
			border-radius: 30px;
			text-decoration: none !important;">
       		<button type="button" class="btn btn-primary">
			  <a class="float-button" 
			  href="<%=request.getContextPath() %>/community/recipewrite.do" target="_blank">
			    레시피 작성하기
			  </a>
			 </button>
		</div>
        <h3 style="text-align: center; /* 가로 방향 가운데 정렬 */">오늘의 레시피는?</h3>
        <section class="review-section rev1">
        <div>
        </div>
          <div class="section-inner">
            <ul class="review-items">
            <%if(!recipes.isEmpty()){ 
            for(Recipe r : recipes){%>
            <a href="<%=request.getContextPath()%>/community/recipedetail.do?recipeNo=<%=r.getRecipeNo() %>">
              <li class="item">
                <div class="img-area">
                  <img src="<%=request.getContextPath() %>/upload/recipe/<%=r.getRecipeRenamedFileName() %>" alt="" />
                </div>
                <div class="icon-area">
                	<p><% for(Hashtag h : r.getHashtag()){ %>
                		#<%=h.getHashtagValue()%>
                	<%} %>
                	</p>
                  <!-- <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" /> -->
                </div>
                <div class="desc-area">
                	<h6><%=r.getRecipeTitle() %></h6>
                  <p>
                    <%=r.getRecipeComment() %>
                  </p>
                </div>

                <div class="info-area">
                  <div class="line"></div>
                  <%for(Member m : members){ %>
                  <%if(r.getMember_no()==m.getMemberNo()){ %>
                  <h5><%=m.getMemberId() %></h5>
                </div>
              </li>
              </a>
              <%	 }
                  }
            	}
            }
              %>
            </ul>
            </div>
       </section>
 <script>
  $("#searchtag").keyup(e=>{
	const value=e.target.value;
	$.ajax({
		url:"<%=request.getContextPath()%>/community/searchhashtag.do",
		data:{"keyword":value},
		success:data=>{
			const hashtag=data.split(",");
			$("#data").html("");
			hashtag.forEach(e=>{
				const $op=#("<option>").attr("value",e).text(e);
				$("#data").append($op);
			});
		}
		
	})
	  
  });
 
 </script>
<%@ include file="/views/common/footer.jsp" %>