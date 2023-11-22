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
//    String memberId = request.getParameter("memberId");
//    String memberPw = request.getParameter("memberPw");
//    // 1. 현재 비밀번호가 맞는지 확인
//    Member m = new MyinfoService().selectMemberByIdAndPw(memberId, memberPw);
//    String msg = "다시 시도하세요.: ", loc = "/delete.do?memberId=" + memberId;
//
//    if (m != null) {
//        // 2. 일치하면 회원 탈퇴
//        int result = -1; // Initialize result to some default value
//        try {
//            result = new MyinfoService().deleteMember(memberId,memberPw);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, such as logging or showing an error message.
//        }
//
//        if (result >= 0) { // Check if result is not equal to the default value
//            msg = "회원 탈퇴가 완료되었습니다. 다시 로그인해주세요.";
//            loc = "/"; // 로그인 페이지로 이동하도록 설정
//            // 탈퇴 후 자동 로그아웃 스크립트
//            String script = "opener.location.replace('" + request.getContextPath() + "/loginout.do');" + "close();";
//            request.setAttribute("script", script);
//        } else {
//            msg = "회원 탈퇴 중 오류가 발생했습니다. 다시 시도하세요."; // 에러 메시지 추가
//        }
//    } else {
//        msg = "비밀번호가 일치하지 않습니다. 다시 시도하세요.";
//    }
	
	
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
