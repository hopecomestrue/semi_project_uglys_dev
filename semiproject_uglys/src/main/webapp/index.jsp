<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image: url(images/bg_1.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-md-12 ftco-animate text-center">
	              <h2 class="mb-2" style="color: white;">함께 만들어가는 건강 식단, &amp; 채소랑</h2>
	              <h3 class="subheading mb-4"> 매주 만나는 신선함  </h3>
	              <p><a href="<%=request.getContextPath() %>/productionList/vegfarm.do" class="btn btn-primary">신선한 채소 보기</a></p>
	            </div>
	          </div>
	        </div>
	      </div>
	      <div class="slider-item" style="background-image: url(images/bg_2.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-sm-12 ftco-animate text-center">
	              <h2 class="mb-2"style="color: white;">신선한 채소로 모두가 만들어 가는 레시피</h2>
	              <h3 class="subheading mb-4">요리도 하고 자신만의 노하우를 공유해 보세요</h3>
	              <p><a href="<%=request.getContextPath() %>/community/communitymain.do" class="btn btn-primary">레시피 보기</a></p>
	            </div>
	            
	          </div>
	        </div>
	      </div>
	    </div>
    </section>

    <section class="ftco-section">
			<div class="container">
				<div class="row no-gutters ftco-services">
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-shipped"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">정기 배송</h3>
                <span>매주 간편하고 쉽게</span>
              </div>
            </div>      
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-diet"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">신선한 채소</h3>
                <span>산지부터 집 앞까지 신선하게</span>
              </div>
            </div>    
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-award"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">친환경 인증</h3>
                <span>자연과 사람 모두에게 좋은</span>
              </div>
            </div>      
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-customer-service"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">고객 지원</h3>
                <span>제품 문의부터 농산물 납품까지</span>
              </div>
            </div>      
          </div>
        </div>
			</div>
		</section>

		<section class="ftco-section ftco-category ftco-no-pt">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div class="row">
							<div class="col-md-6 order-md-last align-items-stretch d-flex">
								<div class="category-wrap-2 ftco-animate img align-self-stretch d-flex" style="background-image: url(images/category.jpg);">
									<div class="text text-center">
										<h2>채소농장</h2>
										<p>나와 가족 모두를 건강하게</p>
										<p><a href="<%=request.getContextPath() %>/productionList/vegfarm.do" class="btn btn-primary">채소 보러 가기</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(images/category-1.jpg);">
								</div>
								<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(images/category-2.jpg);">
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(images/category-3.jpg);">
						</div>
						<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(images/category-4.jpg);">

						</div>
					</div>
				</div>
			</div>
		</section>

    <section class="ftco-section testimony-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate text-center">
          	<span class="subheading"></span>
            <h2 class="mb-4">레시피,<br> 함께 공유해요</h2>
            <p>채소를 활용해 만들어 먹을 수 있는 자신만의 레시피를 함께 공유해요</p>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel">
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(images/돼지고기김치찌개.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">진한 국물이 맛있는 돼지고기 김치찌개입니다.</p>
                    <p class="name">돼지고기 김치찌개</p>
                    <span>Lorem Ipsum</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(images/fish.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">고등어조림을 할 때에는 묵은지나 미네랄 식이섬유소가 풍부한 시래기와 함께 조려도 맛이 좋지만, 달콤하고 시원한 무와 함께 조려 낸 고등어 무 조림은 밥도둑이 따로 없더라고요.</p>
                    <p class="name">고등어무조림</p>
                    <span>Lorem Ipsum</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(images/무생채.jfif)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">소금에 절이지 않고 10분 만에 휘리릭 만들어 먹는 간단 반찬 무생채를 만들어 보았어요.</p>
                    <p class="name">무생채</p>
                    <span>Lorem Ipsum</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(images/소세지야채볶음.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">"우리집 단골 메뉴 소세지야채볶음! 일명 '쏘야'라고도 불리우죠. 쏘야는 아이들 반찬으로도 어른들 술안주로도 먹기 정말 좋아요!</p>
                    <p class="name">소세지야채볶음</p>
                    <span>Lorem Ipsum</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(images/콩나물무침.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">바쁜 일상 속에 반찬 만들기도 큰 일거리죠? 그래서 더 간단한 방법의 레시피가 필요하구요. 맛도 있고 영양도 살아있는 아삭 콩나물무침 보여드릴게요~^^</p>
                    <p class="name">콩나물무침</p>
                    <span>Lorem Ipsum</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </section>
<%@ include file="/views/common/footer.jsp" %>