package com.veg.ojy.cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.ojy.cart.dto.Cart;

/**
 * Servlet implementation class CartListAddServlet
 */
@WebServlet("/CartListAddServlet")
public class CartListAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		/* 세션에 저장된 장바구니 목록을 ArrayList 타입의 객체로 반환하는 메서드 호출 */
		//ArrayList<Cart> cartList = getCartList(request);

		/* 총금액 계산 */
		int totalMoney = 0; // 지불해야 하는 총금액
		int money = 0; // 장바구니 항목 하나에 대한 지불 금액

//		if (cartList != null) {
//			for (int i = 0; i < cartList.size(); i++) {
//				money = cartList.get(i).getPrice() * cartList.get(i).getCount();
//				totalMoney += money;
//				}
//			}
		request.setAttribute("totalMoney", totalMoney);
//		ActionForward forward = new ActionForward();
//		forward.setPath("/book/bookCartList.jsp");
//		forward.setRedirect(false);
//
//			return forward;
//		}

		/** 세션에 저장된 장바구니 목록을 ArrayList 타입의 객체로 반환하는 메서드 */
//		@SuppressWarnings("unchecked")
//		public ArrayList<Cart> getCartList(HttpServletRequest request) {
//			ArrayList<Cart> s_cartList = null;
//			session = request.getSession(false);
//			if (session != null) {
//				// 세션이 생성되어 있는 경우
//				s_cartList = (ArrayList<Cart>) session.getAttribute("cartList");
//				}
//		        
//				return cartList;
//			}

	}

}
