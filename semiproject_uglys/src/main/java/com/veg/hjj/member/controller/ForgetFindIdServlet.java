package com.veg.hjj.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.hjj.member.service.MemberService;

/**
 * Servlet implementation class ForgetFindIdServlet
 */
@WebServlet("/forgetfindid.do")
public class ForgetFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("email");
	
	
		
		MemberService service = new MemberService();
		Member member = service.searchId(memberName,memberEmail);
		
		System.out.println("member : " + member);

	
		if(member != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/member/forgetfindid.jsp");
			request.setAttribute("members", member);
			rd.forward(request, response);
			
		}else {
			request.setAttribute("msg", "정확한 정보를 입력해 주세요!");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/views/member/msg.jsp");
			rd.forward(request, response);
		}
		
	}

//	   request.getRequestDispatcher("/views/member/forgetfindid.jsp").forward(request, response);
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
