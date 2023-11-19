package com.veg.ksj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDeliveryDetailEnd
 */
@WebServlet("/admin/deliveryDetailEnd.do")
public class AdminDeliveryDetailEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeliveryDetailEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long orderNo=Long.parseLong(request.getParameter("orderNo")); //주문번호
		int delNo=Integer.parseInt(request.getParameter("delNo")); //송장번호
		String delCheck=request.getParameter("delCheck"); //배송상태 : 배송준비중,배송중,배송완료
		
		System.out.println(orderNo);
		System.out.println(delNo);
		System.out.println(delCheck);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
