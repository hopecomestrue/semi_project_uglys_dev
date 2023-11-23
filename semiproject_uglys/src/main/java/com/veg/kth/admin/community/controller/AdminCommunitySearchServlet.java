package com.veg.kth.admin.community.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.kth.admin.community.service.AdminCommunityService;
import com.veg.kth.community.model.dto.Recipe;

/**
 * Servlet implementation class AdminCommunitySearchServlet
 */
@WebServlet("/admin/recipeSearch.do")
public class AdminCommunitySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommunitySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dateStart=request.getParameter("search_date_start");
		String dateEnd=request.getParameter("search_date_end");
		String searchType=request.getParameter("searchType").toUpperCase();
		String searchContent=request.getParameter("searchContent");
		
		
		List<Recipe> recipes = new ArrayList<>();
		if(dateStart!="" || dateEnd!="") {
			recipes = new AdminCommunityService().searchRecipeByAnythingAndDate(searchType,searchContent,dateStart,dateEnd);
		}else {
			recipes = new AdminCommunityService().searchRecipeByAnything(searchType,searchContent);			
		}
		List<Member> members = new ArrayList<>(); 
		for(Recipe r : recipes) {
			members.add(new OrderService().selectMemberByNo(r.getMember_no()));
		}

		
		request.setAttribute("recipes", recipes);
		request.setAttribute("members", members);
		
		
		request.getRequestDispatcher("/views/admin/admincommunity/communityRecipe.jsp")
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
