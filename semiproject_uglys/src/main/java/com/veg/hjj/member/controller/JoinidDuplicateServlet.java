package com.veg.hjj.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.hjj.member.service.MemberService;

/**
 * Servlet implementation class JoinidDuplicateServlet
 */
@WebServlet("/member/idduplicate.do")
public class JoinidDuplicateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinidDuplicateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String memberId=request.getParameter("memberId");
      System.out.println(memberId);
      Member m=new MemberService().selectMemberById(memberId);
   
      
      request.setAttribute("result", m==null?true:false);
      
      System.out.println(m);
      
      
      request.getRequestDispatcher("/views/member/idduplicate.jsp")
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