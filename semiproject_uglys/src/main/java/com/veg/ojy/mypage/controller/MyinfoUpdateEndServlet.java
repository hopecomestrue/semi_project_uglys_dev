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
			
			if(result>0) {
				msg="변경이 완료되었습니다. 다시 로그인해주세요.";
				loc="/";
				String script="opener.location.replace('"+request.getContextPath()+"/logout.do');"+"close();";
				request.setAttribute("script",script);
			}
		}else {
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
