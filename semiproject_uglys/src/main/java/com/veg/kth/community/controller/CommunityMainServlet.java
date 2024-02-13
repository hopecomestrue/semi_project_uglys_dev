package com.veg.kth.community.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.hjj.member.service.MemberService;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.kth.admin.community.service.AdminCommunityService;
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.service.CommunityService;

/**
 * Servlet implementation class CommunityMainServlet
 */
@WebServlet("/community/communitymain.do")
public class CommunityMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recipe> recipes = new CommunityService().selectRecipeAll();
		
//		System.out.println(recipes);
		

		List<Member> members = new ArrayList<>(); 
		members = new CommunityService().selectMemberByNo(recipes);
		
		
		/*
		 * for(Recipe r : recipes) { members.add(new
		 * OrderService().selectMemberByNo(r.getMember_no())); }
		 */
		
		request.setAttribute("members", members);
		
		request.setAttribute("recipes", recipes);
//		System.out.println(recipes);
//		System.out.println(members);
		
		request.getRequestDispatcher("/views/community/community_main.jsp")
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
