<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
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

   </style>
  </head>
  <body class="goto-here">
      <div class="py-1 bg-primary">
       <div class="container">
          <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
             <div class="col-lg-12 d-block">
                <div class="row d-flex">
                   <div class="col-md pr-4 d-flex topper align-items-center">
                      <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
                      <span class="text">+ 1235 2355 98</span>
                   </div>
                   <div class="col-md pr-4 d-flex topper align-items-center">
                      <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
                      <span class="text">youremail@email.com</span>
                   </div>
                   <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                      <span class="text">3-5 Business days delivery &amp; Free Returns</span>
                   </div>
                </div>
             </div>
          </div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
       <div class="container">
         <a class="navbar-brand" href="index.html"><img src="/images/KakaoTalk_20231111_130144404_02.png"></a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
           <span class="oi oi-menu"></span> Menu
         </button>

         <div class="collapse navbar-collapse" id="ftco-nav">
           <ul class="navbar-nav ml-auto">
             <li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
             <li class="nav-item active dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
                 <a class="dropdown-item" href="shop.html">Shop</a>
                 <a class="dropdown-item" href="wishlist.html">Wishlist</a>
                <a class="dropdown-item" href="product-single.html">Single Product</a>
                <a class="dropdown-item" href="cart.html">Cart</a>
                <a class="dropdown-item" href="checkout.html">Checkout</a>
              </div>
            </li>
             <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
             <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
             <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
             <li class="nav-item cta cta-colored"><a href="cart.html" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>

           </ul>
         </div>
       </div>
     </nav>
    <!-- END nav -->

    <!-- 상품등록섹션 -->
    <section class="ftco-section">
       <div class="container">
          <div class="row">
             <div class="col-lg-6 mb-5 ftco-animate">
                <!-- 사진  -->
               <a href="images/product-12.jpg" class="image-popup"><img src="images/product-11.jpg" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-lg-6 product-details pl-md-5 ftco-animate">
               <div class="rating d-flex">
                  <p class="text-left mr-4">
                     <!-- 별점 -->
                     <a href="#" class="mr-2">5.0</a>
                     <a href="#"><span class="ion-ios-star-outline"></span></a>
                     <a href="#"><span class="ion-ios-star-outline"></span></a>
                     <a href="#"><span class="ion-ios-star-outline"></span></a>
                     <a href="#"><span class="ion-ios-star-outline"></span></a>
                     <a href="#"><span class="ion-ios-star-outline"></span></a>
                  </p>
                  <p class="text-left mr-4">
                     <!-- 후기갯수 -->
                     <a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">후기갯수</span></a>
                  </p>
               </div>
               <!-- 상품명 -->
               <h3>맛없는애</h3>
               <div class="flex gap-4px">
               <p> 할인율 50%</p>  
               <!-- 가격 -->
                <p class="price"><span>12000원</span></p>
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
                  <span>우리집</span>
               </div>
               <div style="display: grid; grid-template-columns: 114px 1fr;">
                  <span>생산지</span> 
                  <span>우리집</span>
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
			<span style="display: flex; gap: 10px;"><p><a href="#" class="btn btn-black py-3 px-5">장바구니</a></p>
            <p><a href="cart.html" class="btn btn-black py-3 px-5">바로구매</a></p></span>
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
         <div style="display: flex; justify-content: center; align-items: center; width: 100%; gap: 16px;";>
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
            <img src="./images/image_1.jpg">
            <img src="./images/image_2.jpg">
            <img src="./images/image_3.jpg">

           </div>
           <button class="accordion-button" style="background-color:white; border-radius: 10px; color: rgb(65 75 90); border-width: 1px; font-weight: 600; border-color: #e5e7eb; width: 53%; margin-top: 10px; margin-bottom: 10px; padding: 1%; border-color: rgb(65 75 90);"><span style="padding: 10px;">상품 소개 펼치기</span></button>
         </div>
        </div>
      
      </div>
      <div >
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
                        <h2>702건의 후기가있어요!</h2>
                        <div style="height: 24px;"></div>
                     </div>
                  </div>
                  <div style="display: flex; margin-left: 16px; margin-right: 16px; flex-direction: column;">
                     <div style="padding-top: 28px; padding-bottom: 28px; padding-left: 24px; padding-right: 24px; display: id; border-radius: 10px; background-color: rgb(255 246 238);">
                        <div style="display: flex; align-items: center; justify-content: center; gap: 16px; flex-direction: column;">
                           <p style="font-weight: 600; font-size: 16px; line-height: 1; margin: 0;">평균평점</p>
                           <div style="gap: 4px; align-items: center; display: flex;">
                              <!-- 현재평점 -->
                              <p style="font-weight: 700; font-size: 30px; line-height: 1; margin: 0;">4.7</p>
                              <!-- 총평점 -->
                              <p style="font-size: 16px; line-height: 1; margin: 0;">/5</p>
                           </div>
                           <div style="gap: 2px; display: flex;">별</div>
                        </div>
                        <div style="display: flex; align-items: center; justify-content: center; gap: 16px; flex-direction: column;">
                           <!-- 비율평점 -->
                           <p style="font-size: 16px; line-height: 1; font-weight: 600; margin: 0;">5점 비율</p>
                           <p style="font-weight: 700;font-size: 30px; line-height: 1; margin: 0;">89%</p>
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
                           <p>사진 후기만 보기</p>
                           <button>체크박스</button>
                        </div>
                     </div>
                     <div style="border-width: 1px; position: relative; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px; border-color: rgb(229 231 235); display: block;">
                        <div style="padding-left: 14px; padding-right: 14px; padding-top: 16; padding-bottom: 16px; justify-content: space-between; align-items: center; cursor: pointer; display: flex;">
                           <span style="color:  rgb(31 41 55); font-weight: 400; font-size: 16px;line-height: 1;">
                              추천순
                           </span>
                           <button style="padding-left: 4px; padding-right: 4px; height: 16px; cursor: pointer; text-transform: none;">
                              <svg style="width: 10; height: 7; "></svg>
                           </button>
                        </div>
                        <hr>
                        <!-- 후기리스트 -->
                        <div style="gap: 12px; flex-direction: column; display: flex;">
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>신고</span>
                        </div>
                        <hr style="margin-top: 24px; margin-bottom: 24px; margin: 0; border-top-width: 1px;">

                        <div style="gap: 12px; flex-direction: column; display: flex;">
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>신고</span>
                        </div>
                        <hr style="margin-top: 24px; margin-bottom: 24px; margin: 0; border-top-width: 1px;">

                        <div style="gap: 12px; flex-direction: column; display: flex;">
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>후기정보들</span>
                           <span>신고</span>
                        </div>
                        <hr style="margin-top: 24px; margin-bottom: 24px; margin: 0; border-top-width: 1px;">

                     </div>
                     <!-- 후기 페이징처리란 -->
                     <div style="padding-bottom: 86px; padding-top: 60px; text-align: center; font-size: 13px;">
                        <button style="text-decoration: underline; font-weight: 500; cursor: pointer; text-transform: none;">후기정보10개더보기</button>
                     </div>
                     <!-- 후기 작성란 -->
                     <div>
                        <form>
                        <div>아이디</div>
                        <div>사진,내용</div>
                        <button type="submit" >등록</button>
                        </form>
                        
                     </div>
                  </div>
               </div>
            </div>
         </div>
    

    

		<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
      <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
          <div class="col-md-6">
          	<h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
          	<span>Get e-mail updates about our latest shops and special offers</span>
          </div>
          <div class="col-md-6 d-flex align-items-center">
            <form action="#" class="subscribe-form">
              <div class="form-group d-flex">
                <input type="text" class="form-control" placeholder="Enter email address">
                <input type="submit" value="Subscribe" class="submit px-3">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
     
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.waypoints.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.stellar.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.magnific-popup.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/aos.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.animateNumber.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
  <script src="<%=request.getContextPath()%>/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="<%=request.getContextPath()%>/js/google-map.js"></script>
  <script src="<%=request.getContextPath()%>/js/main.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
 
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
  </body>

 