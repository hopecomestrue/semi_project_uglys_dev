package com.veg.ojy.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.mypage.service.MyinfoService;

/**
 * Servlet implementation class MyAddressEndServlet
 */
@WebServlet("/myaddressend.do")
public class MyAddressEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAddressEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId=request.getParameter("memberId");
	
		String addressNew=request.getParameter("address_New");
//		int result = new MyinfoService().insertAddress(memberId,addressNew);
		
//		if(result>0) {
				String msg="변경이 완료되었습니다.";
				String script="opener.location.replace('"+request.getContextPath()+"/myInfo.do');"+"close();";
//				request.setAttribute("script",script);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
