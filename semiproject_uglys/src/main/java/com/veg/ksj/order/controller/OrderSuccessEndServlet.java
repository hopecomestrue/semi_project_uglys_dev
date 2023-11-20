package com.veg.ksj.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class OrderSuccessEndServlet
 */
@WebServlet("/order/ordersuccessEnd.do")
public class OrderSuccessEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSuccessEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Gson gson=new Gson();
	
//		long orderNo=Long.parseLong(request.getParameter("orderNo"));
//		System.out.println("마지막에 받은 주문번호"+orderNo);
//		long orderNo=(Long)request.getAttribute("orderNo");
//		Order order=new OrderService().selectOrderDetailsByOrderNo(orderNo);
//		System.out.println(order.getOrderAddress());
		
		
		request.getRequestDispatcher("/views/order/orderSuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
