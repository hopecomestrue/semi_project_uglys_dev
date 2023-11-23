<%@page import="com.veg.pdw.production.model.dto.*"%>
<%@page import="com.veg.ojy.cart.dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%
	List<Cart>carts=(List<Cart>)request.getSession().getAttribute("carts");
	List<Production>productions=(List<Production>)request.getSession().getAttribute("productions");
	List<ProductionContent>productionContents=(List<ProductionContent>)request.getSession().getAttribute("productionContents");
	int sum=0;
	int delFee=0;
%>



   <form class="pay-form" id="pay-form" action="<%=request.getContextPath() %>/order/ordersuccessEnd.do?productNo=<%=productions.get(0).getProduction_no() %>" method="post">
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				<h3 class="mb-4 billing-heading">장바구니</h3>
					<%if(!carts.isEmpty()){ %>
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>상품이미지</th>
									<th>&nbsp;</th>
									<th>상품명</th>
									<th>가격</th>
									<th>수량</th>
									<th>총금액</th>
								</tr>
							</thead>
							<tbody>
							<%for(int i=0;i<carts.size();i++){ %>
								<tr class="text-center">
									<td class="product-remove"><img src="<%=request.getContextPath()%>/upload/production/thumnail/<%=productionContents.get(i).getProductionImg()%>" style="width: 100%; height: 100%"></td>

									<td class="image-prod"></td>

									<td class="product-name1">
										<h3 id="product-name"><%=productions.get(i).getProduction_name() %></h3>
									</td>

									<td class="price"><%=productions.get(i).getPrice() %></td>

									<td class="qua-col first-row">
										<div class="pro-qty">
											<span><%=carts.get(i).getCount() %></span>
										</div>
									</td>

														<%sum+=productions.get(i).getPrice()*carts.get(i).getCount(); %>
									<td class="total"><%=productions.get(i).getPrice()*carts.get(i).getCount() %></td>
									</tr>
									<%} %>
							</tbody>
						</table>
					</div>
					<%} %>
				</div>
			</div>
			</div>
			</section>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
				<h3 class="mb-4 billing-heading">주문/결제하기</h3>
		          	<div class="row align-items-end">
		          		<div class="col-md-6">
		                	<div class="form-group">
	                			<label for="주문자명">주문자명</label>
	                  			<input type="text" class="form-control" placeholder="" id="buyer-name" value="<%=loginMember.getMemberName()%>">
	                		</div>
	              		</div>
           <div class="w-100"></div>
		   	<div class="col-md-6">
		    	<div class="form-group">
		        	<label for="country">배송 요청사항</label>
		    			<div class="select-wrap">
		                  	<div class="icon"><span class="ion-ios-arrow-down"></span></div>
		                  <select name="" id="deli-memo-choice" class="form-control" onchange="deliInputOn()">
		                    <option value="배송메모를 선택해주세요.">배송메모를 선택해주세요.</option>
		                    <option value="요청사항을 직접 입력합니다.">요청사항을 직접 입력합니다.</option>
		                  	<option value="배송 전에 미리 연락바랍니다.">배송 전에 미리 연락바랍니다.</option>
		                    <option value="부재시 경비실에 맡겨 주세요.">부재시 경비실에 맡겨 주세요.</option>
		                    <option value="부재시 전화 주시거나 문자 남겨 주세요.">부재시 전화 주시거나 문자 남겨 주세요.</option>
		                  </select>
		                </div>
		            	</div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="towncity">직접입력</label>
	                  <input type="text" class="form-control" id="deli-input" disabled>
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="streetaddress">우편번호</label>
	                  <input type="text" class="form-control" id="sample4_postcode" readonly>
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                  <input type="button" class="btn btn-outline-secondary" onclick="sample4_execDaumPostcode();" value="우편번호 찾기">
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="towncity">도로명주소</label>
	                  <input type="text" class="form-control" id="sample4_roadAddress" readonly>
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
		            		<label for="postcodezip">상세주소</label>
	                  <input type="text" class="form-control" id="sample4_detailAddress">
	                </div>
	                <input type="hidden" id="sample4_jibunAddress" placeholder="지번주소">
	                <input type="hidden" id="sample4_extraAddress" placeholder="참고항목">
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
	                <div class="form-group">
	                	<label for="phone">전화번호</label>
	                  <input type="text" class="form-control" id="buyer-phone" value="<%=loginMember.getMemberPhone()%>">
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="emailaddress">이메일</label>
	                  <input type="email" class="form-control" id="buyer-email" value="<%=loginMember.getMemberEmail()%>" readonly>
	                </div>
                </div>
                <div class="w-100"></div>
	            </div>
					</div>
					<div class="col-xl-5">
	          <div class="row mt-5 pt-3">
	          	<div class="col-md-12 d-flex mb-5">
	          		<div class="cart-detail cart-total p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">장바구니 합계</h3>
	          			<p class="d-flex">
		    						<span>총가격</span>
		    						<span><%=sum %></span>
		    					</p>
		    					<p class="d-flex">
		    						<span>배송비</span>
		    						<span id="del-pay">
		    							<%if(sum<=50000){delFee=2500;}
		    								else{delFee=0;}%><%=delFee %>
		    						</span>
		    						
		    					</p>
		    					<p class="d-flex">
		    					<%
		    					int sale=sum/100;
		    					int totalSum=sum-sale+delFee;
		    					%>
		    						<span>할인</span>
		    						<span id="sale-per"><%=sale %></span>
		    					</p>
		    					<hr>
		    					<p class="d-flex total-price">
		    						<span>총합계</span>
		    						<span id="total-price"><%=totalSum %></span>
		    					</p>
								</div>
	          	</div>
	          	<div class="col-md-12">
	          		<div class="cart-detail p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">결제 방식</h3>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="payment" class="mr-2" value="kcp"> 카드 결제</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="payment" class="mr-2" value="cacao"> 카카오페이 결제</label>
											</div>
										</div>
									</div>
									<button type="button" class="btn btn-primary py-3 px-4" onclick="paymentOrder_btn()">결제하기</button>
								</div>
								<input type="hidden" name="" id="orderNoHidden">
	          	</div>
	          </div>
          </div> <!-- .col-md-8 -->
        </div>
      </div>
    </section> <!-- .section -->
   </form>


	<!-- 택배 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="/main.js"></script>
	<script>
	/* 택배 api 함수 */
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode(){
        new daum.Postcode({
            oncomplete: function(data){
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                              
              
            }
        }).open();
    }

   
      /* 템플릿 함수 */
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
   
   
      <!-- 결제 분기점 -->
      function paymentOrder_btn(){
         var kcp=document.querySelector('input[name="payment"][value="kcp"]');
         var cacao=document.querySelector('input[name="payment"][value="cacao"]');
         
         if(kcp.checked){
            kcp_payment();
         }else if(cacao.checked){
            cacao_payment();
         }else{
            alert('결제수단을 선택하세요.');
         }
      }
      
   <!-- 배달요청 직접입력 체크박스 -->
       function deliInputOn(){
         var select=document.getElementById("deli-memo-choice");
         var input=document.getElementById("deli-input");
         if(select.value==='요청사항을 직접 입력합니다.'){
            input.value = '';
            input.disabled=false;
         }else{
            input.value = '';
            input.disabled=true;
         }
      }
   <!-- 카드 결제 함수 -->
   /* 카카오결제 */
   function cacao_payment(){
	   //아임포트에 결제 데이터 전송
       var IMP = window.IMP;
       IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
        var msg; //결제 성공,실패시 출력할 msg
        var buyerName=$('#buyer-name').val(); //구매자 이름
        var name='상품명';//상품명
        var amount=parseInt($('#total-price').text(),10);//총가격
        var buyerEmail=$('#buyer-email').val();//구매자 이메일
        var buyerTel=$('#buyer-phone').val();//구매자 폰번호
        var buyerAddr=$('#sample4_roadAddress').val()+' '+$('#sample4_detailAddress').val();//구매자 주소
        var delrequest='';//배송요청사항
        //배송요청사항 분기처리
        var select=document.getElementById("deli-memo-choice");
        var input=document.getElementById("deli-input");
        
        if(buyerName.length<1){
        	alert('구매자 이름을 입력하세요.');
        	return;
        }
        else if(buyerTel.length<1){
        	alert('전화번호를 입력하세요.');
        	return;
        }
        else if($('#sample4_detailAddress').val().length<1){
        	alert('주소를 입력하세요.');
        	return;
        }
        else if(select.value==='배송메모를 선택해주세요.'){
        	alert('배송요청사항을 선택하세요.');
        	return;
        }
        
        
        if(select.value==='요청사항을 직접 입력합니다.'){
        	delrequest=input.value;
        }else{
        	delrequest=select.value;
        }
        

        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : new Date().getTime(),
            name : name,
            amount : amount,
            buyer_name : buyerName,
            buyer_email : buyerEmail,
            buyer_tel : buyerTel,
            buyer_addr : buyerAddr,
            /* buyer_postcode : '123-456', //우편번호*/
        }, function(rsp){
           if (rsp.success) {
            jQuery.ajax({
                url: "<%=request.getContextPath()%>/order/ordersuccess.do", //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                dataType: 'json',
                data: {	
                    pg_provider : rsp.pg_provider, //PG사 구분코드, kakaopay,kcp(NHN KCP)
                    merchant_uid : rsp.merchant_uid, //주문번호
                    /* order_name : rsp.name, //주문명 */
                    imp_uid : rsp.imp_uid,         //결제 고유번호
                    paid_amount : rsp.paid_amount, //결제된 금액
                    buyer_name : rsp.buyer_name, //주문자 이름
                    buyer_email : rsp.buyer_email, // 주문자 email
                    buyer_tel : rsp.buyer_tel, // 주문자 연락처
                    buyer_addr : rsp.buyer_addr, //주문자 주소
                    order_status : rsp.status, //결제상태(결제완료,한도초과,결제실패)
                    delrequest : delrequest //배송요청사항
                    /* paid_at : rsp.paid_at, // 결제승인시각 */
                    //필요한 데이터 있으면 추가
                },
			success:function(res){
				/* console.log('테스트'+res); */
				/* var orderNo=document.getElementById('orderNoHidden');
				orderNo.name='1'; */
				alert("결제완료");
				document.getElementById('pay-form').submit();
			},
			error:function(err){
				console.log('결제 실패 이유 : ' +err);
			}
            });
           }else{
        	   msg = '결제에 실패하였습니다.';
               msg += '에러내용 : ' + rsp.error_msg;
               //실패시 이동할 페이지
               alert(msg);
           }
		});
	}
            
            
            
   /* kcp결제 */
   function kcp_payment(){
	   //아임포트에 결제 데이터 전송
       var IMP = window.IMP;
       IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
        var msg; //결제 성공,실패시 출력할 msg
        var buyerName=$('#buyer-name').val(); //구매자 이름
        var name='상품명';//상품명
        var amount=parseInt($('#total-price').text(),10);//총가격
        var buyerEmail=$('#buyer-email').val();//구매자 이메일
        var buyerTel=$('#buyer-phone').val();//구매자 폰번호
        var buyerAddr=$('#sample4_roadAddress').val()+' '+$('#sample4_detailAddress').val();//구매자 주소
        var delrequest='';//배송요청사항
        //배송요청사항 분기처리
        var select=document.getElementById("deli-memo-choice");
        var input=document.getElementById("deli-input");
        
        if(buyerName.length<1){
        	alert('구매자 이름을 입력하세요.');
        	return;
        }
        else if(buyerTel.length<1){
        	alert('전화번호를 입력하세요.');
        	return;
        }
        else if($('#sample4_detailAddress').val().length<1){
        	alert('주소를 입력하세요.');
        	return;
        }
        else if(select.value==='배송메모를 선택해주세요.'){
        	alert('배송요청사항을 선택하세요.');
        	return;
        }
        
        
        if(select.value==='요청사항을 직접 입력합니다.'){
        	delrequest=input.value;
        }else{
        	delrequest=select.value;
        }
        

        IMP.request_pay({
            pg : 'kcp.{AO09C}',
            pay_method : 'card',
            merchant_uid : new Date().getTime(),
            name : name,
            amount : amount,
            buyer_name : buyerName,
            buyer_email : buyerEmail,
            buyer_tel : buyerTel,
            buyer_addr : buyerAddr,
            /* buyer_postcode : '123-456', //우편번호*/
        }, function(rsp){
           if (rsp.success) {
            jQuery.ajax({
                url: "<%=request.getContextPath()%>/order/ordersuccess.do", //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                dataType: 'json',
                data: {	
                    pg_provider : rsp.pg_provider, //PG사 구분코드, kakaopay,kcp(NHN KCP)
                    merchant_uid : rsp.merchant_uid, //주문번호
                    /* order_name : rsp.name, //주문명 */
                    imp_uid : rsp.imp_uid,         //결제 고유번호
                    paid_amount : rsp.paid_amount, //결제된 금액
                    buyer_name : rsp.buyer_name, //주문자 이름
                    buyer_email : rsp.buyer_email, // 주문자 email
                    buyer_tel : rsp.buyer_tel, // 주문자 연락처
                    buyer_addr : rsp.buyer_addr, //주문자 주소
                    order_status : rsp.status, //결제상태(결제완료,한도초과,결제실패)
                    delrequest : delrequest //배송요청사항
                    /* paid_at : rsp.paid_at, // 결제승인시각 */
                    //필요한 데이터 있으면 추가
                },
			success:function(res){
				/* console.log('테스트'+res); */
				/* var orderNo=document.getElementById('orderNoHidden');
				orderNo.name='1'; */
				alert("결제완료");
				document.getElementById('pay-form').submit();
			},
			error:function(err){
				console.log('결제 실패 이유 : ' +err);
			}
            });
           }else{
        	   msg = '결제에 실패하였습니다.';
               msg += '에러내용 : ' + rsp.error_msg;
               //실패시 이동할 페이지
               alert(msg);
           }
		});
	}
	
	</script>
	
	
	
	
	
	
    
<%@ include file="/views/common/footer.jsp" %>