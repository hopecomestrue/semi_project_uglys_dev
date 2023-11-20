package com.veg.ksj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.veg.ksj.order.model.service.OrderService;


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
		Gson gson=new Gson();
		//주문번호, 송장번호,배송상태 값 받아오기
		long orderNo=Long.parseLong(request.getParameter("orderNo")); //주문번호
		long delNo=Long.parseLong(request.getParameter("delNo")); //송장번호
		String delCheck=request.getParameter("delCheck"); //배송상태 : 배송준비중,배송중,배송완료
		
		System.out.println(delCheck);
		System.out.println(delNo);
		System.out.println(orderNo);
		
		//주문번호로 조회해서 송장번호,배송상태 변경
		int result=new OrderService().updateOrderDetails(delCheck, delNo, orderNo);
		
//		if(result>0) System.out.println("DB 배송상태 변경 성공");
//		else  System.out.println("DB 배송상태 변경 실패");
		
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
