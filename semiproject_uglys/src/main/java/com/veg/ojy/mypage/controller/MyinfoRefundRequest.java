package com.veg.ojy.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class MyinfoRefundRequest
 */
@WebServlet("/myinfo/refund.do")
public class MyinfoRefundRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoRefundRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		Long orderNo=Long.parseLong(request.getParameter("orderNo"));
		
		int result=new OrderService().OrderRefundRequest(orderNo);
		
		if(result>0) System.out.println("환불요청성공");
		else System.out.println("환불요청실패");
		
		gson.toJson("",response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
