package com.veg.ojy.cart.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.ojy.cart.dto.Cart;
import com.veg.ojy.cart.service.CartService;
import com.veg.pdw.production.model.dto.Production;

/**
 * Servlet implementation class CartList
 */
@WebServlet("/CartList")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 private void doProcess(HttpServletRequest req, HttpServletResponse resp, ServletRequest reuqest)
	            throws ServletException, IOException {
		 /* 장바구니 항목으로 추가될 책 상품의 아이디와 마지막 페이지를 파라미터 값으로 받아온다 */
			String producion_name = reuqest.getParameter("production_name");
	
			
			/* DB 접근이 필요한 비즈니스 로직 호출
			 * 장바구니 항목으로 추가될 책 상품 정보를 얻어오는 메서드 호출
			 * */
			CartService service = new CartService();
			Production cartProduction = service.getProudctCart(producion_name);
			
			/* 책 상품을 장바구니 항목으로 추가하는 메서드 호출 
			 * 세션 영역 객체에 장바구니 항목을 추가해야 하므로 파라미터 값으로 request 객체를 던진다. */
			addCart(req, cartProduction, producion_name);		
			
			/* 세션ID 쿠키로 만들어 브라우저에 넘겨주기 
			 * 생성한 쿠키의 유효 기간 : 24H(60*60*24)*/
//			Cookie c_session = new Cookie("c_session", URLEncoder.encode(session.getId(), "UTF-8")); 
//			c_session.setMaxAge(60*60*24);
//			resp.addCookie(c_session);
//			
			/* 포워딩
			 * .ok -> .ok : redirect
			 * */
//			ActionForward forward = new ActionForward();
//			forward.setPath("");
//			forward.setRedirect(true);
//
//			return forward;
		 
		 
	}
		@SuppressWarnings("unchecked")
		public void addCart(HttpServletRequest req, Production cartProduction, String production_name) {

//			session = req.getSession(true);
//			ArrayList<Cart> s_cartList = (ArrayList<Cart>) session.getAttribute("cartList");
//			
//			if(s_cartList == null ) {
//				s_cartList = new ArrayList<>();
//				session.setAttribute("cartList", s_cartList);
//			}
			
			// 지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 판단하는 변수
			// 기본값 true로 하여 요청에서 지정한 항목이 처음으로 추가되는 장바구니 항목으로 지정되게 한다.
//			boolean isNewCart = true;	
			
			/* 새로 추가하는 장바구니 항목인지에 따른 처리
			 * 새로 추가할 장바구니 항목이 기존 장바구니 항목 목록에 존재하는 경우
			 * 1. 기존에 존재하는 장바구니 항목일 때 isNewCart = false
			 * 2. 기존 장바구니 항목의 수량을 하나 증가 
			 * */
//			for(int i=0; i<s_cartList.size(); i++) {
//				if(cartProduction.getProduction_Name() == s_cartList.get(i).getCartNo()) {
//					isNewCart = false;
//					s_cartList.get(i).setCount(s_cartList.get(i).getCount()+1);
//					break;
//				}
//			}
			
			/* 새로 추가하는 장바구니 항목인지에 따른 처리
			 * 새로 추가할 장바구니 항목이 기존 장바구니 항목 목록에 존재하지 않는 경우
			 * 1. 장바구니 항목을 저장하는 cartList에 새로운 Cart 객체 추가
			 * */
//			if(isNewCart) {
//				Cart cart = new Cart();
//				cart.setCartNo(cartNo);
//				cart.setMemberNo(cartProduction.getMemberNo());
//				cart.setProductionName(cartProduction.getProductionName());
//				cart.setCount(1);
//				
//				s_cartList.add(cart);
//			}
//		}
		}}
