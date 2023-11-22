<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import= "java.util.List,java.util.Map,com.veg.pdw.production.model.dto.Production,com.veg.pdw.production.model.dto.ProductionContent,com.veg.pdw.production.model.dto.ProductionReview" %>
<% 
	List<Production> soldouts = (List<Production>)request.getAttribute("soldouts"); 
	List<ProductionContent> productionContents = (List<ProductionContent>)request.getAttribute("productionContents");
	Map<Integer,Integer> reviewCount = (Map<Integer,Integer>)request.getAttribute("reviewCount");
	Map<Integer,Double> reviewRating = (Map<Integer,Double>)request.getAttribute("reviewRating");
	
%>
<style>
    .product{
    border: 0px;
    }
    .img-fluid{
    border-radius: 10px;
    }
    
    </style>



	<div style="max-width: 1200px; margin: 0 auto;">
	<h2 style="font-weight: 600; margin-top: 40px;margin-bottom: -60px; font-size: 26px;">곧 다시만날수있어요</h2>
    <section class="ftco-section">
          <div class="row">
             <%if(soldouts!=null&&!soldouts.isEmpty()) {%>
             <%for(Production p : soldouts) {%>
             <div class="col-md-6 col-lg-4 ftco-animate">
                <div class="product">
                   <%for(ProductionContent pc : productionContents) {
                   		if(p.getProduction_no()== pc.getProductionNo()){
                   													%>
                   <a href="<%=request.getContextPath()%>/vegfarm/vegfarm.do?no=<%=p.getProduction_no()%>" class="img-prod"><img class="img-fluid" 
                   src="<%=request.getContextPath()%>/upload/production/thumnail/<%=pc.getProductionImg()%>" alt="외안대">
                      <%} 
                     }%>
                      <span class="status"><%=p.getDiscount()%>%</span>
                      <div class="overlay"></div>
                   </a>
                   <div class="text py-3 pb-4 px-3 text-center">
                      <h3><a href="<%=request.getContextPath()%>/vegfarm/vegfarm.do?no=<%=p.getProduction_no()%>">
                      <%=p.getProduction_name() %>
                      </a></h3>
                      <div class="d-flex">
                         <div class="pricing">
                            <p class="price"><span class="mr-2 price-dc"><%=p.getPrice()%></span><span class="price-sale"><%=(p.getPrice()*(1-(p.getDiscount()*0.01))) %></span></p>
                            <% if(reviewRating.get(p.getProduction_no())!=null&&reviewCount.get(p.getProduction_no())!=null) { %>
                            
                            <p class="rating"><span>
                            <img src="https://d3cpiew7rze14b.cloudfront.net/assets/mypage/order-history/Vector__26__enBGagMTM.svg">
                            	<%=reviewRating.get(p.getProduction_no())%>
                            	(
                            	<%=reviewCount.get(p.getProduction_no())%>
                            	)
                            </span>
                            <% 
                            }%>
                         </div>
                      </div>
                   </div>
                </div>
             </div>
             <%} 
             }
             %>
             </div>
</section>
<%@ include file="/views/common/footer.jsp" %>