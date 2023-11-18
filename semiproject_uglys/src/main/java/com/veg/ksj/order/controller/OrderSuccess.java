package com.veg.ksj.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;

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
		Member m=(Member)request.getAttribute("loginMember");
		
		String orderNo=request.getParameter("merchant_uid"); //주문번호
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		String orderName=request.getParameter("buyer_name"); //구매자 이름
		String orderPhone=request.getParameter("buyer_tel"); //주문자 연락처
		String orderAddr=request.getParameter("buyer_addr"); //주문자 주소
		String orderComment=request.getParameter("delrequest"); //배송요청사항
		int orderCount=Integer.parseInt(request.getParameter("oder_count"));
		String pg=request.getParameter("pg_provider"); //PG사 구분코드, kakaopay,kcp(NHN KCP)
		String imp=request.getParameter("imp_uid"); //결제고유번호
		int totalPrice=Integer.parseInt(request.getParameter("paid_amount")); //결제금액
		String buyerEmail=request.getParameter("buyer_email"); //주문자 email
//		long paidAt=Long.parseLong(request.getParameter("paid_at")); //결제승인시각
		
		System.out.println(pg);
		System.out.println(orderNo);
		System.out.println(imp);
		System.out.println(totalPrice);
		System.out.println(orderName);
		System.out.println(buyerEmail);
		System.out.println(orderPhone);
		System.out.println(orderAddr);
//		System.out.println(paidAt);
		System.out.println(orderComment);
		
		
//		Date date = new Date(paidAt * 1000L); // 유닉스 타임스탬프는 초 단위이므로 밀리초로 변환하기 위해 1000을 곱함
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String strDate = formatter.format(date);
//		System.out.println("변환된 날짜와 시간: " + strDate);
		
		
		Order order=Order.builder()
						.orderNo(orderNo)
						.memberNo(memberNo)
						.orderName(orderName)
						.orderPhone(orderPhone)
						.orderAddress(orderAddr)
						.orderComment(orderComment)
						.orderCount(orderCount)
						.totalPrice(totalPrice)
						.deliveryPay(0)
						.payment(pg)
						.trakingNumber(1)
						.build();
		
		int result=new OrderService().insertOrderDetails(order,m);
		
		if(result>0) System.out.println("DB저장 성공");
		else System.out.println("DB저장 실패");
		
		
		request.getRequestDispatcher("성공페이지").forward(request, response); //마이페이지로
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
