package com.veg.ksj.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String imp=request.getParameter("imp_uid"); //결제고유번호
		String merchantuid=request.getParameter("merchant_uid"); //주문번호
		String amount=request.getParameter("paid_amount"); //결제금액
		String buyerName=request.getParameter("buyer_name"); //구매자 이름
		String pg=request.getParameter("pg_provider"); //PG사 구분코드, kakaopay,kcp(NHN KCP)
		String buyerEmail=request.getParameter("buyer_email"); //주문자 email
		String buyerPhone=request.getParameter("buyer_tel"); //주문자 연락처
		String buyerAddr=request.getParameter("buyer_addr"); //주문자 주소
		String paidAt=request.getParameter("paid_at"); //결제승인시각
		
		System.out.println(imp);
		System.out.println(merchantuid);
		System.out.println(amount);
		System.out.println(buyerName);
		System.out.println(pg);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
