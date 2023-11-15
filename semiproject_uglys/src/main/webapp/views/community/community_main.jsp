<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.veg.kth.community.model.dto.Recipe, java.util.List" %>

<%

	List<Recipe> recipes = (List<Recipe>)request.getAttribute("recipe");  

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
                  <a href="#" class="tag-cloud-link">fruits</a>
                  <a href="#" class="tag-cloud-link">tomatoe</a>
                  <a href="#" class="tag-cloud-link">mango</a>
                  <a href="#" class="tag-cloud-link">apple</a>
                  <a href="#" class="tag-cloud-link">carrots</a>
                  <a href="#" class="tag-cloud-link">orange</a>
                  <a href="#" class="tag-cloud-link">pepper</a>
                  <a href="#" class="tag-cloud-link">eggplant</a>
                </div>
              </div>
            </div>
        </div>
      </div>
      </div>

        <section class="review-section rev1">
          <div class="section-inner">
            <ul class="review-items">
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art1.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    어글리어스 첫배송! 여러가지 제품군을 저렴한 가격으로 받아볼
                    수 있다고 하여 주문해봤어요. 아기가 이유식을 시작해서 다양한
                    채소들도 필요한데 아무래도 제가 고르면 한정적인 재료들만
                    고를 것 같아서 이렇게 다양한 제품을 소량씩 받을 수 있다는
                    점이 마음에 들었어요.
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art2.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    이때 양상추 볶음 레시피 였나 추천받아서 반신반의하면서
                    먹어봤는데 맛있어서 놀랐어요 ㅠ 야채를 자주 접하니 어떻게
                    먹는지 알게되는게 재밋어요ㅋㅋ 특히 라따뚜이를 자주 해먹게
                    됩니다.
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art3.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    이번에 온 버섯과 로메인으로 오픈 샌드위치 열심히
                    만들어먹었네요 싱싱하고 신선해서 엄청 맛있었어요
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art4.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    보내주신 야채들 모두 신선하고 요리가 괜시리 재미지게하는
                    매력있는 못난이 유기농 채소들이예 이번에 캠핑가서 호박전이랑
                    호박구이 맛있게 해먹었어요
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art5.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    싱싱한 채소들로 잘 왔어요 적혀있는 레시피대로
                    양배추간장국수를 해먹었는데 맛있게 잘 먹었습니다 ^^
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
              <li class="item">
                <div class="img-area">
                  <img src="../img/review/art6.png" alt="" />
                </div>

                <div class="icon-area">
                  <img class="i1" src="../img/review/quote.png" alt="" />
                  <img class="i2" src="../img//review/stars.png" alt="" />
                </div>

                <div class="desc-area">
                  <p>
                    외식과 배달음식도 줄여볼겸 취지도 좋은것같아 어글리어스를
                    신청해봤어요. 레시피 이용해서 비트 라페도 만들어보고
                    애호박팽이버섯 덮밥도 해보고 평소라면 해먹을일 없는
                    단호박에그슬럿 등 다양한 요리를 하게 되네요.
                  </p>
                </div>

                <div class="info-area">
                  <h6>2회차 어글리어스 채소박스</h6>
                  <div class="line"></div>
                  <h5>김*원 고객님</h5>
                </div>
              </li>
            </ul>
            </div>
            </section>
<%@ include file="/views/common/footer.jsp" %>