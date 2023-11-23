package com.veg.ojy.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.cart.dto.Cart;
import com.veg.ojy.cart.service.CartService;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;
import com.veg.pdw.production.service.ProductionService;

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
		
		int memberNo=mem.getMemberNo();
		int productNo=Integer.parseInt(request.getParameter("productNo"));
		int count =Integer.parseInt(request.getParameter("quantity"));
		
		
		
		
		List<Cart> carts = (List<Cart>) request.getSession().getAttribute("carts");

		
		if (carts == null) {
		    carts = new ArrayList<>();
		}

		Cart c = Cart.builder()
		            .memberNo(memberNo)
		            .count(count)
		            .productNo(productNo)
		            .build();

		
		carts.add(c);
		
		
		List<Production>productions=new ArrayList<>();
		List<ProductionContent>productionContents=new ArrayList<>();
		for(Cart c1 : carts) {
			Production p = new ProductionService().selectProductionByNo(c1.getProductNo());
			productions.add(p);
		}
		
		for(Cart c1 : carts) {
			ProductionContent pc = new ProductionService().selectProductionContentByNo(c1.getProductNo());
			productionContents.add(pc);
		}
		
		
		
		//장바구니를 session에 담기
		request.getSession().setAttribute("carts", carts);
		
		request.getSession().setAttribute("productions", productions);
		request.getSession().setAttribute("productionContents", productionContents);
		
		//장바구니 화면으로 이동
		request.getRequestDispatcher("/views/member/cart/mycart.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
