package com.veg.ojy.cart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.cart.dto.Cart;
import com.veg.ojy.cart.service.CartService;

/**
 * Servlet implementation class MainCartListServlet
 */
@WebServlet("/cart/maincartList.do")
public class MainCartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 회원의 정보 가져오기
		Member mem=(Member)request.getSession().getAttribute("loginMember");
		
		//해당 회원의 장바구니 리스트를 가져오기
		List<Cart> carts=new CartService().selectAllCart(mem.getMemberNo());
		
		//장바구니를 session에 담기
		request.getSession().setAttribute("carts", carts);
		
		//장바구니 화면으로 이동
		request.getRequestDispatcher("/views/member/cart/mycart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
