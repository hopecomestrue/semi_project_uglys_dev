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
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.service.CommunityService;

/**
 * Servlet implementation class CommunitySearchServlet
 */
@WebServlet("/community/search.do")
public class CommunitySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchTitle = request.getParameter("searchTitle");
		
		List<Recipe> recipes = new CommunityService().selectRecipeByTitle(searchTitle);
		
		System.out.println(recipes);
		
		List<Member> members = new ArrayList<>(); 
		members = new CommunityService().selectMemberByNo(recipes);
		

		
		request.setAttribute("members", members);
		
		request.setAttribute("recipes", recipes);
		
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
