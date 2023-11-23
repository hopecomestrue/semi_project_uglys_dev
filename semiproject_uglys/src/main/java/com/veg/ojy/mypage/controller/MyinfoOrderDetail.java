package com.veg.ojy.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class MyinfoOrderDetail
 */
@WebServlet("/myinfo/myOrderDetail.do")
public class MyinfoOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoOrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long orderNo=Long.parseLong(request.getParameter("orderNo"));
		System.out.println("주문번호 : "+orderNo);
		Order order=new OrderService().selectOrderDetailsByOrderNo(orderNo);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/views/member/mypage/myOrderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
