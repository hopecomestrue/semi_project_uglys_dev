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
		String merchant_uid=request.getParameter("merchant_uid"); //주문번호
		String name=request.getParameter("buyerName"); //구매자 이름
		String total=request.getParameter("total"); //총가격
		String amount=request.getParameter("amount"); //결제금액
		System.out.println(imp);
		System.out.println(merchant_uid);
		System.out.println(name);
		System.out.println(total);
		System.out.println(amount);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
