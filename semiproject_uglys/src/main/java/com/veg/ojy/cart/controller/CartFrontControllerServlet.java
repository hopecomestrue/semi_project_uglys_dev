package com.veg.ojy.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartFrontControllerServlet
 */
@WebServlet("/w")
public class CartFrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartFrontControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		/* 1. 요청 주소 파악 */		
//		String requestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();		
//		String command = requestURI.substring(contextPath.length());

//		/* 2. 각 요청 주소의 매핑 처리 */
//		ActionForward forward = null;
//		CartAction action = null;
//		
//		// 책 상품 장바구니 추가 요청
//		if (command.equals("/")) {
//			action = new CartAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//        
//        	/* 3. 포워딩 처리 */
//		if(forward != null) {
//			if(forward.isRedirect()) {
//				// redirect 방식
//				response.sendRedirect(forward.getPath());
//			} else {
//				// forward 방식
//				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
//				dispatcher.forward(request, response);
//			} else if (command.equals("")) {
//			    action = new CartListServlet();
//			    try {
//			        forward = action.execute(request, response);
//			    } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
