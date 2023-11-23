package com.veg.ksj.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.ojy.cart.dto.Cart;
import com.veg.pdw.production.model.dto.Production;

/**
 * Servlet implementation class OrderSuccess
 */
@WebServlet("/order/ordersuccess.do")
public class OrderSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Gson gson = new Gson();
		
		Member m=(Member)request.getSession().getAttribute("loginMember");
		
		long orderNo=Long.parseLong(request.getParameter("merchant_uid")); //주문번호
		String buyerName=request.getParameter("buyer_name"); //구매자 이름
		String buyerPhone=request.getParameter("buyer_tel"); //주문자 연락처
		String buyerAddr=request.getParameter("buyer_addr"); //주문자 주소
		String buyerComment=request.getParameter("delrequest"); //배송요청사항
//		int orderCount=Integer.parseInt(request.getParameter("oder_count"));
		String pg=request.getParameter("pg_provider"); //PG사 구분코드, kakaopay,kcp(NHN KCP)
		String imp=request.getParameter("imp_uid"); //결제고유번호
		int totalPrice=Integer.parseInt(request.getParameter("paid_amount")); //결제금액
		String buyerEmail=request.getParameter("buyer_email"); //주문자 email
		String orderStatus=request.getParameter("order_status"); //결제상태
		String orderName=request.getParameter("name"); //상품명
//		long paidAt=Long.parseLong(request.getParameter("paid_at")); //결제승인시각
		
		//결제상태 : paid==결제완료, ready==미결제, failed==결제실패
		if(orderStatus.equals("paid")) orderStatus="결제완료";
		else if(orderStatus.equals("ready")) orderStatus="미결제";
		else if(orderStatus.equals("failed")) orderStatus="결제실패";
		
		
//		System.out.println("주문번호 : "+orderNo);
//		System.out.println("session 회원번호 : "+m.getMemberNo());
//		System.out.println("주문자 : "+buyerName);
//		System.out.println("주문자 전화번호 : "+buyerPhone);
//		System.out.println("주문자 주소 : "+buyerAddr);
//		System.out.println("배달요청사항 : "+buyerComment);
//		//주문 수량
//		System.out.println("결제가격 : "+totalPrice);
//		//배달비
//		System.out.println("결제수단 : "+pg);
//		System.out.println("결제상태 : "+orderStatus);
//		//운송장 번호
//		//주문 날짜
//		System.out.println("결제고유번호 : "+imp);
//		System.out.println("주문자 이메일 : "+buyerEmail);
//		System.out.println("상품명 : "+orderName);
		
//		Date date = new Date(paidAt * 1000L); // 유닉스 타임스탬프는 초 단위이므로 밀리초로 변환하기 위해 1000을 곱함
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String strDate = formatter.format(date);
//		System.out.println("변환된 날짜와 시간: " + strDate);
		
		
		Order order=Order.builder()
						.orderNo(orderNo)
						.memberNo(m.getMemberNo())
						.orderName(buyerName)
						.orderPhone(buyerPhone)
						.orderAddress(buyerAddr)
						.orderComment(buyerComment)
						.orderCount(1)
						.totalPrice(totalPrice)
						.deliveryPay(0)
						.payment(pg)
						.orderStatus(orderStatus)
						.build();
		
		int result=new OrderService().insertOrderDetails(order,m);
//		if(result>0) {
//			System.out.println("DB저장성공");
//		}else {
//			System.out.println("DB저장실패");
//		}
		/* 주문_상세*/
		List<Production> proList=(List<Production>)request.getSession().getAttribute("productions");
		List<Cart>cartsList=(List<Cart>)request.getSession().getAttribute("carts");
		for(int i=0;i<cartsList.size();i++) {
			Cart c=cartsList.get(i);
			Production pro=proList.get(i);
			int result1=new OrderService().inserOrderDetailEnd(order, pro,c);
			
		}
		/* 주문_상세*/
		
		
		request.getSession().setAttribute("order", order);
		 response.setContentType("application/json;charset=utf-8");
		 gson.toJson(order,response.getWriter());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
