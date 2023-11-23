<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.veg.pdw.production.model.dto.Production,com.veg.pdw.production.model.dto.ProductionContent,java.util.Map,java.util.List,com.veg.pdw.production.model.dto.*,com.veg.hjj.member.dto.Member" %>
<%
	Production p = (Production)request.getAttribute("production");
	ProductionContent pc = (ProductionContent)request.getAttribute("productionContent");
	Map<Integer,Integer> reviewCount =(Map<Integer,Integer>)request.getAttribute("reviewCount");
	Map<Integer,Double> reviewRating =(Map<Integer,Double>)request.getAttribute("reviewRating");
	List<ProductionReview> ProductionReviews=(List<ProductionReview>)request.getAttribute("ProductionReviews");
	Member m = (Member)request.getAttribute("member");
	
%>

<!DOCTYPE html>
    <title>채소랑의 채소농장</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/magnific-popup.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/aos.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ionicons.min.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/icomoon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
	<script src="https://cdn.ckeditor.com/ckeditor5/40.0.0/classic/ckeditor.js"></script>
	   <style>
	   .sub a::after {/*after 가상요소*/
	   display:block;/*a요소를 블록 요소라고 선언*/
	   /*카테고리 메뉴 밑줄의 크기를 동일하게 주기 위해 width 설정*/
	              /*혹시 a요소 크기만큼 생기길 바란다면 width 삭제*/
	   content: '';/*comtent안은 밑줄 디자인을 위해 비워두세요.*/
	   border-bottom: solid 2px #000;
	   transform: scaleX(0);/*크기를 0으로 줌으로써 평상시엔 밑줄 없음*/
	   transition: transform 250ms ease-in-out; /*변형 방식*/
	   font-size: 18px;
	}
	   .sub a:hover:after {
	   transform: scaleX(1);/*a 속성에 hover시 after를 기존 크기로 변경*/
	}
	
	.accordion-content {
	  max-height: none;
	  transition: max-height 0.2s ease-out;
	
	
	  /* 이미지를 가운데로 정렬 */
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	}

	.active {
	  max-height: 100%;
	}
	.accordion-item {
	  display: flex;
	  flex-direction: column;
	  align-items: center; /* 이 부분이 버튼을 가운데로 위치시킵니다 */
	}
	
	.accordion-content img {
	  display: none; /* 모든 이미지를 숨깁니다 */
	}
	
	.accordion-content img:nth-of-type(1) {
	  display: block; /* 첫 번째 이미지만 보이게 합니다 */
	}
	.rating {
	   width: 180px;
	}
	
	.rating__star {
	   cursor: pointer;
	   color: #dabd18b2;
	}
	
	.ck.ck-editor {
            width: 100%;
            max-width: 1000px;
            margin: 0 auto;
        }

     .ck-editor__editable {
         height: 50vh;
     }

   </style>
  </head>
  

    <!-- 상품등록섹션 -->
    <section class="ftco-section">
       <div class="container">
          <div class="row">
             <div class="col-lg-6 mb-5 ftco-animate">
                <!-- 사진  -->
               <a href="<%=request.getContextPath()%>/upload/production/thumnail/<%=pc.getProductionImg()%>" class="image-popup"><img src="<%=request.getContextPath()%>/upload/production/thumnail/<%=pc.getProductionImg()%>" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-lg-6 product-details pl-md-5 ftco-animate">
               <div class="rating d-flex" style="display:flex;">
                  <p >
                     <% if(reviewRating.get(p.getProduction_no())!=null&&reviewCount.get(p.getProduction_no())!=null) { %>
                     <!-- 별점 -->
                      <a href="#" class="mr-6">
				    <% 
				    double rating = (reviewRating.get(p.getProduction_no()));
				    int fullStars = (int)rating;
				    boolean halfStar = (rating - fullStars) >= 0.5;
				    for(int i = 0; i < fullStars; i++) { %>
				        <span class="ion-ios-star"></span>
				    <% } 
				    if(halfStar) { %>
				        <span class="ion-ios-star-half"></span>
				    <% } 
				    for(int i = 0; i < 5-fullStars-(halfStar ? 1 : 0); i++) { %>
				        <span class="ion-ios-star-outline"></span>
				    <% } %>
				</a>
                  </p>
                  &nbsp;&nbsp;
                  <p>
                     <!-- 후기갯수 -->
                     &nbsp;<a href="#" class="mr-6" style="color: #000;"><%=reviewCount.get(p.getProduction_no())%>건의 후기 <span style="color: #bbb;"></span></a>
                  </p>
                  <%} %>
               </div>
               <!-- 상품명 -->
               <h3><%=p.getProduction_name() %></h3>
               <div class="flex gap-4px">
               
               <div style="display: flex;">
               <p><%=p.getDiscount()%>%&nbsp;&nbsp;</p>
               <p style="text-decoration: line-through;"><%=p.getPrice()%></p>
               </div>  
                 
               <!-- 가격 -->
               <div>
                <p class="price"><span><%=(p.getPrice()*(1-(p.getDiscount()*0.01))) %></span></p>
                </div>
               <hr style="margin-top: 32px; margin-bottom: 32px;">
               <!--태그-->
               <div >
                  <span style="border-radius: 10px; font-size: 14px; background-color: rgb(65, 75, 90); color: white; padding: 8px;">NEW</span>
                  <span style="border-radius: 10px; font-size: 14px; background-color: rgb(181, 82, 228); color: white; padding: 8px;">친환경</span>
                  <span style="border-radius: 10px; font-size: 14px; background-color: rgb(205, 143, 80); color: white; padding: 8px;">무농약</span>
               </div>
               <div class="w-full" style="height: 16px;"></div>
               <!-- 상품설명 -->
                <div style="display: grid; grid-template-columns: 114px 1fr;">
                  <span>재배환경</span> 
                  <span><%=p.getEnvironment() %></span>
               </div>
               <div style="display: grid; grid-template-columns: 114px 1fr;">
                  <span>생산지</span> 
                  <span><%=p.getPlace() %></span>
               </div>
                  <div class="row mt-4">
                     <div class="col-md-6">
                        <div class="form-group d-flex">
                    <div class="select-wrap">
                     <!-- 상품옵션.... 할까말까-->
                 <!-- <div class="icon"><span class="ion-ios-arrow-down"></span></div> -->
                     <!-- <select name="" id="" class="form-control">
                        <option value="">Small</option>
                       <option value="">Medium</option>
                       <option value="">Large</option>
                       <option value="">Extra Large</option>
                     </select> -->
                   </div>
                  </div>
                     </div>
                     <div class="w-100"></div>
                     <div class="input-group col-md-6 d-flex mb-3">
                   <span class="input-group-btn mr-2">
                      <button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
                      <i class="ion-ios-remove"></i>
                      </button>
                     </span>
                   <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
                   <span class="input-group-btn ml-2">
                      <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                        <i class="ion-ios-add"></i>
                    </button>
                   </span>
                </div>
                <div class="w-100"></div>
             </div>
         <br>
         <!-- 상품장바구니 , 바로구매하기-->
         	<%-- <form name="addForm" action="${request.getContextPath()}/mycart.do" method="post"> --%>
            <%--  <span style="display: flex; gap: 10px;"><p><a href="<%=request.getContextPath() %>/mycart.do" class="btn btn-black py-3 px-5" <!-- onclick="document.addForm.submit();" --> >장바구니</a></p> --%>
			<!-- </form> -->
			<%if(p.getStock()>0) {%>
			<span style="display: flex; gap: 10px;"><p><a href="#" class="btn btn-black py-3 px-5">장바구니</a></p>
            <p><a href="cart.html" class="btn btn-black py-3 px-5">바로구매</a></p></span>
            <%} else{%> 
             	<span style="display: flex; gap: 10px;"><p><a href="#" class="btn btn-black py-3 px-5">품절</a></p>
             <%} %>
             </div>
          </div>
       </div>
    </section>
   <div style="margin: 0;">
      <div style="my: -48px; height: 14px; background-color:  rgb(249 250 251); margin-top: 0px; margin-bottom: 40px; "></div>
   </div>
   <div style=" position: relative; background: white; z-index: 3000px;">
      <!-- 상품설명후기탭 -->
      <div style="border-bottom-width:1px; border-color: rgb(229 231 235);  z-index: 3501;top: 56px;">
         <div style="display: flex; justify-content: center; align-items: center; width: 100%; gap: 16px;">
            <div class="sub"style="cursor: pointer; box-sizing: border-box; font-size: 18px; line-height: 1; padding-top: 8px; padding-bottom: 16px; border-color: rgb(255 103 65); border-bottom-width: 4px;"> <a href="#">상품 설명</a></div>
            <div class="sub" style="cursor: pointer; box-sizing: border-box; font-size: 18px; line-height: 1; padding-top: 8px; padding-bottom: 16px; border-color: rgb(255 103 65); border-bottom-width: 4px;"><a href="#">후기</a></div>
            <div><hr style="max-width: 16px;"></div>
         </div>
         <div></div>
      </div>
      
      <p><br><br></p>
      <!-- 상품상세설명페이지 -->
      <div class="accordion">
         <div class="accordion-item">
           <div class="accordion-content">
            <%=pc.getProductionContent() %>

           </div>
           <button class="accordion-button" style="background-color:white; border-radius: 10px; color: rgb(65 75 90); border-width: 1px; font-weight: 600; border-color: #e5e7eb; width: 53%; margin-top: 10px; margin-bottom: 10px; padding: 1%; border-color: rgb(65 75 90);"><span style="padding: 10px;">상품 소개 펼치기</span></button>
         </div>
        </div>
      
      </div>
      
         <div style="margin: 0;">
            <div style="my: -48px; height: 14px; background-color:  rgb(249 250 251); margin-top: 0px; margin-bottom: 40px; "></div>
         </div>
         <div style="justify-content: center; align-items: center;">
            <!-- 상품후기페이지 -->
            <div>
               <div>
                  <div style="display: flex; align-items: end; justify-content: space-between; ">
                     <div style="flex-direction: column;">
                        <!-- 후기갯수 디비에서 받아오기 -->
                        <%Integer reviewObj = reviewCount.get(p.getProduction_no());%>
                        <h2><%=reviewObj != null ? reviewObj : 0 %>건의 후기가있어요!</h2>
                        <div style="height: 24px;"></div>
                        
                     </div>
                  </div>
                  <div style="display: flex; margin-left: 16px; margin-right: 16px; flex-direction: column;">
                     <div style="padding-top: 28px; padding-bottom: 28px; padding-left: 24px; padding-right: 24px; display: id; border-radius: 10px; background-color: rgb(255 246 238);">
                        <div style="display: flex; align-items: center; justify-content: center; gap: 16px; flex-direction: column;">
                           <p style="font-weight: 600; font-size: 16px; line-height: 1; margin: 0;">평균평점</p>
                           <div style="gap: 4px; align-items: center; display: flex;">
                              <!-- 현재평점 -->
                              <p style="font-weight: 700; font-size: 30px; line-height: 1; margin: 0;">
                              	<%Double ratingObj = reviewRating.get(p.getProduction_no());%>
                              	<%=ratingObj != null ? ratingObj : 0.0 %>
                              	</p>
                              <!-- 총평점 -->
                              <p style="font-size: 16px; line-height: 1; margin: 0;">/5</p>
                           </div>
                           <div style="gap: 2px; display: flex;">별</div>
                        </div>
                        <div style="display: flex; align-items: center; justify-content: center; gap: 16px; flex-direction: column;">
                           <!-- 비율평점 -->
                           <a href="#" class="mr-6">
						    <% 
						    ratingObj = reviewRating.get(p.getProduction_no());
						    double rating = (ratingObj != null) ? ratingObj : 0.0;
						    int fullStars = (int)rating;
						    boolean halfStar = (rating - fullStars) >= 0.5;
						    for(int i = 0; i < fullStars; i++) { %>
						        <span class="ion-ios-star"></span>
						    <% } 
						    if(halfStar) { %>
						        <span class="ion-ios-star-half"></span>
						    <% } 
						    for(int i = 0; i < 5-fullStars-(halfStar ? 1 : 0); i++) { %>
						        <span class="ion-ios-star-outline"></span>
						    <% } %>
						</a>
                           <div style="display: flex; align-content: center; justify-content: center; gap: 8px;"></div>
                        </div>
                     </div>
                     </div>
                  <div style="margin: 0px;">
                     <div style="background-color:  rgb(245,245,247); height: 14px; margin-top: 32px; margin-bottom: 32px;"></div>
                  </div>
                  <!-- 후기 노출란 -->
                  <div style="padding-left: 16px; padding-right: 16px; gap: 24px; display: flex; flex-direction: column;">
                     <div style="justify-content: space-between; display: flex; align-items: center;">
                        <p style="font-weight: 700; font-size: 22px; line-height: 1; margin: 0;">전체 후기</p>
                        <div style="display: flex; align-items: center; gap: 8px; justify-content: center;">
                          
                        </div>
                     </div>
                     <div style="border-width: 1px; position: relative; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px; border-color: rgb(229 231 235); display: block;">
                        <div style="padding-left: 14px; padding-right: 14px; padding-top: 16; padding-bottom: 16px; justify-content: space-between; align-items: center; cursor: pointer; display: flex;">
                           <span style="color:  rgb(31 41 55); font-weight: 400; font-size: 16px;line-height: 1;">
                              
                           </span>
                        </div>
                        <hr>
                        <!-- 후기리스트 -->
                        <%if(ProductionReviews!=null&&!ProductionReviews.isEmpty()) {
                        	 for( ProductionReview pr : ProductionReviews)    {%>
                        <div style="gap: 12px; flex-direction: column; display: flex;">
                           <span>
                           <%for (int i=0;i<pr.getRating();i++) {%>
                           <img src="https://d3cpiew7rze14b.cloudfront.net/assets/mypage/order-history/Vector__26__enBGagMTM.svg">
                           <%} %>
                           </span>
                           <span><%=p.getProduction_name() %></span>
                           <span><%=pr.getMemberNo()%></span>
                           <span><%=pr.getReviewContent() %></span>
                           <span><%=pr.getReviewDate() %></span>
                           
                        </div>
                        <hr style="margin-top: 24px; margin-bottom: 24px; margin: 0; border-top-width: 1px;">
                        <%} 
                        }%>
                        

        
                        

                     </div>
                     <!-- 후기 페이징처리란 -->
                     
                     <!-- 후기 작성란 -->
                     <div>
                        
     <h2>후기남기기</h2>         
 	 <%if(m!=null){ %>		
    <div class="rating"> <p>별점주기</p>
	    <i class="rating__star far fa-star"></i>
	    <i class="rating__star far fa-star"></i>
	    <i class="rating__star far fa-star"></i>
	    <i class="rating__star far fa-star"></i>
	    <i class="rating__star far fa-star"></i>
	</div>
	
	<div id="editor"></div>
	
    <form id="upload-form" action="<%=request.getContextPath()%>/production/review.do" method="post">
 	 <input type="hidden" id="ratingInput" name="rating">
 	 <input type="hidden" name="content" value="" id="content-input">
 	 <input type="hidden" name="productionNo" value="<%=p.getProduction_no()%>">
 	 <input type="hidden" name="member" value="<%=m.getMemberNo()%>" id="content-input">			
  	<button type="submit" style="margin-top: 100px;" id="upload">등록</button>
	</form>
                        
 	 <%}else{%>
 		 <h2>로그인후 이용해주세요</h2>
 		 
 	<%} %> 
                        
                        
                        
                        
                     
                      
                   </div>
                </div>
             </div>
          </div>
       </div>
  


	    <script>
        var editor;
        ClassicEditor
            .create(document.querySelector('#editor'), {
                ckfinder: {
                    uploadUrl: '<%=request.getContextPath()%>/upload/production/review'
                }
            })
            .then(e => {
                editor = e;
                console.log('Editor was initialized');
            })
            .catch(error => {
                console.error(error);
            });

       
    </script>
    
    
    <script>
    
    window.onload = function() {
        document.getElementById('upload-form').addEventListener('submit', function(event) {
            event.preventDefault();

            const editorData = editor.getData();
            $("#content-input").val(editorData);

            if (confirm('등록하시겠습니까?')) {
                console.log("upload function is called");
                console.log($("#content-input").val()); 
                $("#upload-form").submit();
            } else {
                console.log('폼 제출이 취소되었습니다.');
            }
        });
    };	
    </script>	
     
  

  
 
  <script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
		var acc = document.getElementsByClassName("accordion-button");
	var i;

	for (i = 0; i < acc.length; i++) {
  	acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.previousElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;

      /* 첫 번째 이미지를 제외한 모든 이미지를 숨깁니다 */
      var imgs = content.getElementsByTagName('img');
      for (var i = 1; i < imgs.length; i++) {
        imgs[i].style.display = 'none';
      }
    } else {
      /* 모든 이미지의 높이를 합산하여 max-height를 설정합니다 */
      var imgs = content.getElementsByTagName('img');
      var totalHeight = 0;
      for (var i = 0; i < imgs.length; i++) {
        imgs[i].style.display = 'block';
        totalHeight += imgs[i].offsetHeight;
      }
      content.style.maxHeight = totalHeight + "px";
    }

    /* 버튼을 숨깁니다 */
    this.style.display = 'none';
  });
}




</script>
<script>
$(document).ready(function(){
    // 첫 번째 탭의 내용만 보여줍니다.
    $(".accordion").hide();
    $(".accordion:first").show();

    $(".sub").click(function(){
        // 모든 내용을 숨깁니다.
        $(".accordion").hide();

        // 클릭된 tab에 해당하는 내용만 보여줍니다.
        var idx = $(".sub").index(this); // 클릭된 tab의 index를 가져옵니다.
        $(".accordion").eq(idx).show(); // 해당 index의 내용만 보여줍니다.
    });
});
</script>
<!-- <script>
  function addToCart() {
    document.addForm.submit();
    alert('장바구니에 추가되었습니다.');
  }
</script>
 -->
 <script type="text/javascript">
    const ratingStars = [...document.getElementsByClassName("rating__star")];
    const starClassActive = "rating__star fas fa-star";
    const starClassInactive = "rating__star far fa-star";
    
    ratingStars.forEach((star, index) => {
        star.addEventListener('click', () => {
            // 모든 별점을 비활성화
            ratingStars.forEach((s) => s.className = starClassInactive);

            // 클릭된 별점과 그 앞에 있는 별점들을 활성화
            for(let i = 0; i <= index; i++) {
                ratingStars[i].className = starClassActive;
            }

            // 별점 값을 폼의 인풋 필드에 설정
            document.getElementById('ratingInput').value = index + 1;
            console.log('Current rating value:', index + 1);
        });
    });
</script>


	
  </body>

<%@ include file="/views/common/footer.jsp" %>

 