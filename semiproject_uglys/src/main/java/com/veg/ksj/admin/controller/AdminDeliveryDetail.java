package com.veg.ksj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class AdminDeliveryDetail
 */
@WebServlet("/admin/deliveryDetail.do")
public class AdminDeliveryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeliveryDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 주문 고유번호 가져오기
		long orderNo=Long.parseLong(request.getParameter("orderNo"));
		//해당 주문 회원,주문상세 객체 가져오기
		Order order=new OrderService().selectOrderDetailsByOrderNo(orderNo);
		Member m=new OrderService().selectMemberByNo(order.getMemberNo());
		//해당 주문 회원,주문상세 객체 request에 담기
		request.setAttribute("order", order);
		request.setAttribute("mem", m);
		//주문상세 페이지로 이동
		request.getRequestDispatcher("/views/admin/deliveryDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
