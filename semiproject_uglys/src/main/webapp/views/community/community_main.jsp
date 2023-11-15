<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.veg.kth.community.model.dto.Recipe, java.util.List,com.veg.kth.community.model.dto.Hashtag" %>

<%

	List<Recipe> recipes = (List<Recipe>)request.getAttribute("recipes");  

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
  
}

</style>
      <div class="container_recipe_search">
        <div class="row">
          <div >
            <div class="sidebar-box" >
            <h3>오늘의 레시피는?</h3>
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="icon ion-ios-search"></span>
                  <input type="text" class="form-control" placeholder="ex) 감자">
                </div>
              </form>
              <div class="sidebar-box ftco-animate">
                <div class="tagcloud">
                <%if(!recipes.isEmpty()){ 
            		for(Recipe r : recipes){%>
                  <% for(Hashtag h : r.getHashtag()){ %>
                  <a href="#" class="tag-cloud-link">
                		#<%=h.getHashtagValue()%>
                	</a>
                	<%} %>
                 <%}
            	}%>
                </div>
              </div>
            </div>
        </div>
      </div>
      </div>

        <section class="review-section rev1">
          <div class="section-inner">
            <ul class="review-items">
            <%if(!recipes.isEmpty()){ 
            for(Recipe r : recipes){%>
              <li class="item">
                <div class="img-area">
                  <img src="<%=request.getContextPath() %>/images/<%=r.getRecipeOriginalFileName() %>" alt="" />
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
                  <h5>아이디 가져오기</h5>
                </div>
              </li>
              <%
            	}
            }
              %>
            </ul>
            </div>
            </section>
<%@ include file="/views/common/footer.jsp" %>