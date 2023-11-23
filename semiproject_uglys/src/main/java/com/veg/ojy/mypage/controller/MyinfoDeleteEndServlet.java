package com.veg.ojy.mypage.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.mypage.service.MyinfoService;

/**
 * Servlet implementation class MyinfoDeleteEndServlet
 */
@WebServlet("/deleteEnd.do")
public class MyinfoDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoDeleteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 탈퇴하려는 회원을 구분할 수 있는 유니크 정보 추출
	HttpSession session=request.getSession();
	Member loginMember=(Member)session.getAttribute("loginMember");
	String memberId = loginMember.getMemberId();
	
	// 비즈니스 로직 처리
	MyinfoService mService = new MyinfoService();
	int result = mService.deleteMember(memberId);
	RequestDispatcher view= request.getRequestDispatcher("/views/member/mypage/memberCancellation3.jsp");
	if(result>0) {
		request.setAttribute("result", true);
		session.invalidate();// 회원 탈퇴를 했다면 세션 파기
	}else {
		request.setAttribute("result", false);
	}
	request.setAttribute("memberPw", loginMember.getMemberPw());
	view.forward(request, response);
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
