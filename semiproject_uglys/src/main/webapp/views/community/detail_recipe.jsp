<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.veg.kth.community.model.dto.*,java.util.List" %>
<%@ include file="/views/common/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	Recipe recipe = (Recipe)request.getAttribute("recipe");
	Member member = (Member)request.getAttribute("member");
	List<Procedure> procedure = recipe.getProcedure();
	List<Hashtag> hashtag = recipe.getHashtag();
	List<RecipeComment> comments = (List<RecipeComment>)request.getAttribute("comments");
	
	List<Material> mainM = (List<Material>)request.getAttribute("mainM");
	List<Material> subM = (List<Material>)request.getAttribute("subM");
	List<Material> sourceM = (List<Material>)request.getAttribute("sourceM");
	int lengthM = (int)request.getAttribute("lengthM");
	
%>
<c:set var="lengthM" value="${lengthM }"/>

<style>body{margin-top:20px;}
.card-style1 {
    box-shadow: 0px 0px 10px 0px rgb(89 75 128 / 9%);
}
.border-0 {
    border: 0!important;
}
.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: 0.25rem;
}

section {
    padding: 120px 0;
    overflow: hidden;
    background: #fff;
}
.mb-2-3, .my-2-3 {
    margin-bottom: 2.3rem;
}

.section-title {
    font-weight: 600;
    letter-spacing: 2px;
    text-transform: uppercase;
    margin-bottom: 10px;
    position: relative;
    display: inline-block;
}
.text-primary {
    color: #ceaa4d !important;
}
.text-secondary {
    color: #15395A !important;
}
.font-weight-600 {
    font-weight: 600;
}
.display-26 {
    font-size: 1.3rem;
}

@media screen and (min-width: 992px){
    .p-lg-7 {
        padding: 4rem;
    }
}
@media screen and (min-width: 768px){
    .p-md-6 {
        padding: 3.5rem;
    }
}
@media screen and (min-width: 576px){
    .p-sm-2-3 {
        padding: 2.3rem;
    }
}
.p-1-9 {
    padding: 1.9rem;
}

.bg-secondary {
    background: #15395A !important;
}
@media screen and (min-width: 576px){
    .pe-sm-6, .px-sm-6 {
        padding-right: 3.5rem;
    }
}
@media screen and (min-width: 576px){
    .ps-sm-6, .px-sm-6 {
        padding-left: 3.5rem;
    }
}
.pe-1-9, .px-1-9 {
    padding-right: 1.9rem;
}
.ps-1-9, .px-1-9 {
    padding-left: 1.9rem;
}
.pb-1-9, .py-1-9 {
    padding-bottom: 1.9rem;
}
.pt-1-9, .py-1-9 {
    padding-top: 1.9rem;
}
.mb-1-9, .my-1-9 {
    margin-bottom: 1.9rem;
}
@media (min-width: 992px){
    .d-lg-inline-block {
        display: inline-block!important;
    }
}
.rounded {
    border-radius: 0.25rem!important;
}

th {
  background-color: #04AA6D;
  color: white;
}
tr:hover {
  background-color: rgb(250, 236, 197);
}
th, td {
  border-bottom: 1px solid #ddd;
}
th:nth-child(2), th:nth-child(3) {
  border-left: 1px solid #ddd; /* 1px 굵기의 검은색 세로 라인을 적용합니다. */
}

td:nth-child(2), td:nth-child(3),td:nth-child(4),td:nth-child(5), td:nth-child(6) {
  border-left: 1px solid #ddd; /* 1px 굵기의 검은색 세로 라인을 적용합니다. */
}




</style>

<section class="bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 mb-4 mb-sm-5">
                <div class="card card-style1 border-0">
                    <div class="card-body p-1-9 p-sm-2-3 p-md-6 p-lg-7">
                        <div class="row align-items-center">
                            <div class="col-lg-6 mb-4 mb-lg-0">
                                <img src="<%=request.getContextPath() %>/upload/recipe/<%=recipe.getRecipeRenamedFileName() %>" width="500px" height="500px" alt="...">
                            </div>
                            <div class="col-lg-6 px-xl-10">
                                <div class="bg-secondary d-lg-inline-block py-1-9 px-1-9 px-sm-6 mb-1-9 rounded">
                                    <h3 class="h2 text-white mb-0"><%=recipe.getRecipeTitle() %></h3>
                                    
                                    <span class="text-primary"><%=member.getMemberName() %></span>
                                </div>
                                <ul class="list-unstyled mb-1-9">
                                    <li class="mb-2 mb-xl-3 display-28"><span class="display-26 text-secondary me-2 font-weight-600">소요시간:</span><%=recipe.getRecipeLeadTime() %>분</li>
                                    <li class="mb-2 mb-xl-3 display-28"><span class="display-26 text-secondary me-2 font-weight-600">카테고리:</span><%=recipe.getCategory().getCategoryDept1() %>/<%=recipe.getCategory().getCategoryDept2() %></li>
                                    <li class="mb-2 mb-xl-3 display-28"><span class="display-26 text-secondary me-2 font-weight-600">내용:</span> <br>
                                    <%=recipe.getRecipeComment() %>
									</li>
                                    <li class="mb-2 mb-xl-3 display-28"><span class="display-26 text-secondary me-2 font-weight-600">해시태그:</span>
                                    <%for(Hashtag h:hashtag){ %> 
                                    #<%=h.getHashtagValue() %> 
                                    <% }%> </li>
<!--                                     <li class="display-28"><span class="display-26 text-secondary me-2 font-weight-600"></span> 댓글 0  좋아요 7</li> -->
                                </ul>
                                <ul class="social-icon-style1 list-unstyled mb-0 ps-0">
                                    <li><a href="#!"><i class="ti-twitter-alt"></i></a></li>
                                    <li><a href="#!"><i class="ti-facebook"></i></a></li>
                                    <li><a href="#!"><i class="ti-pinterest"></i></a></li>
                                    <li><a href="#!"><i class="ti-instagram"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mb-4 mb-sm-5">
                <div>
                    <span class="section-title text-primary mb-3 mb-sm-4">재료</span>
                    <table style="width:100%; text-align: center;" >
                    	<tr>
                    		<th colspan="2">필수재료</th>
                    		<th colspan="2">부재료</th>
                    		<th colspan="2">양념</th>
                    	</tr>
                    	<tr>
							<td>주재료 이름</td>
							<td>주재료 수량</td>
							<td>부재료 이름</td>
							<td>부재료 수량</td>
							<td>소스 이름</td>
							<td>소스 양</td>
                    	</tr>
                    	<%for(int i=0;i<lengthM;i++){%>                    	
                    	<tr>
                    		<%if(i < mainM.size() && mainM.get(i) != null){%>
                    		<td><%=mainM.get(i).getMaterialName() %></td>
                    		<td><%=mainM.get(i).getMaterialCapa() %></td>
                    		<%}else{ %>
                    		<td></td>
                    		<td></td>
                    		<%} %>
                    		<%if(i < subM.size() && subM.get(i) != null){%>
                    		<td><%=subM.get(i).getMaterialName() %></td>
                    		<td><%=subM.get(i).getMaterialCapa() %></td>
                    		<%}else{ %>
                    		<td></td>
                    		<td></td>
                    		<%} %>
                    		<%if(i < sourceM.size() && sourceM.get(i) != null){%>
                    		<td><%=sourceM.get(i).getMaterialName() %></td>
                    		<td><%=sourceM.get(i).getMaterialCapa() %></td>
                    		<%}else{ %>
                    		<td></td>
                    		<td></td>
                    		<%} %>                		
                    	</tr>
                    	<%} %>
                    </table>
                </div>
            </div>
            <div class="col-lg-12 mb-4 mb-sm-5">
                <div>
                    <span class="section-title text-primary mb-3 mb-sm-4">절차</span>
                    <table style="width:100%; text-align: center;" >
                    	<tr>
                    		<th >번호</th>
                    		<!-- <th >파일</th> -->
                    		<th >요리설명</th>
                    	</tr>
                    		<%
                    		if(!recipe.getProcedure().isEmpty()){
                    		for(int i=procedure.size()-1;i>=0;i-- ){ 
                    		%>
                    	<tr>
							<td><%=procedure.get(i).getProcedureOrder() %></td>
							<%-- <td><%=p.getProcedureOriginalFileName() %></td> --%>
							<td><%=procedure.get(i).getProcedureComment() %></td>
                    	</tr>
							<%}
							}%>
                    </table>
                </div>
            </div>
            
            
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-12 mb-4 mb-sm-5">
                        <ol type="1">
                        <%if(procedure.isEmpty()){
                        	for(Procedure p : procedure){%>
                        	<li><%=p.getProcedureComment() %></li>
                        <%}
                       	}%>
                        </ol>
                        <div>
                        	<!-- <form>
                            <span class="section-title text-primary mb-3 mb-sm-4">댓글</span>
                        	<input type="hidden" name="boardRef" value="">
							<input type="hidden" name="level" value="1">
							<input type="hidden" name="writer" value="">
					
							<input type="hidden" name="boardCommentRef" value="0"><br>
                            <textarea name="content" rows="3" cols="55"></textarea>
                            <button type="submit" id="btn-insert">작성</button>
                            </form> -->
                        </div>
                    </div>
                </div>
            </div>
            <div>
           <%--  <%if(!comments.isEmpty()){ %>
            <table id="tbl-comment">
            <%for(RecipeComment r : comments){ %>
            	<tr class="level1">
            			<td>
							<sub class="comment-writer"><%=r.getCommentWriter() %></sub>
							<sub class="comment-date"><%=r.getCommentDate() %></sub>
							<br>
							<%=r.getCommentContent() %>
						</td>
					</tr>
			<%} %>
			</table>
		<%} %> --%>
            
            </div>
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp" %>