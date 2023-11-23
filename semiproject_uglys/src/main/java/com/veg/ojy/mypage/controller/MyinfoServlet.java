package com.veg.ojy.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.veg.hjj.member.dto.Member;
import com.veg.hjj.member.service.MemberService;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.ojy.mypage.dto.Address;
import com.veg.ojy.mypage.service.MyinfoService;


/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/myInfo.do")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginMember");
		int memberNo = m.getMemberNo();
		//String address=request.getParameter("address");
		List<Address> a = new MyinfoService().selectAddress(memberNo);
		request.setAttribute("member", m);
		request.setAttribute("address", a);
		
		//회원번호로 주문내역 row 전부 가져오기
		List<Order>orders=new OrderService().selectAllOrderDetailsByMemNo(memberNo);
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("/views/member/mypage/myInfo.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
