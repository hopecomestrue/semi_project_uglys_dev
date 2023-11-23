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
 * Servlet implementation class MyinfoUpdateEndServlet
 */
@WebServlet("/updateInfoend.do")
public class MyinfoUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId=request.getParameter("memberId");
		String memberPw=request.getParameter("memberPw");
		String passwordNew=request.getParameter("password_new");
		// 1. 현재 비밀번호가 맞는지 확인
		Member m = new MyinfoService().selectMemberByIdAndPw(memberId,memberPw);
		String msg="변경실패! 다시 시도하세요.: ",loc="/updateInfo.do?memberId="+memberId;
		if(m!=null) {
		// 2. 일치하면 비밀번호를 변경
			int result = new MyinfoService().updatePassword(memberId,passwordNew);
			System.out.println(result);
			if(result>0) {
		// -> 변경이 완료되면 변경완료 메세지 후 창 자동으로 닫기, 로그아웃 후 메인화면으로 이동.
				msg="변경이 완료되었습니다. 다시 로그인해주세요.";
				loc="/";
				String script="opener.location.replace('"+request.getContextPath()+"/loginout.do');"+"close();";
				request.setAttribute("script",script);
			}
		// -> 변경실패하면 변경 실패 메세지 출력 후 비밀번호 변경 화면으로 이동 
		}else {
		// 3. 일치하지 않으면 비밀번호 변경화면으로 전환.
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
		String URL = response.encodeRedirectURL(request.getContextPath() + "/myInfo.do");
		response.sendRedirect(URL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
