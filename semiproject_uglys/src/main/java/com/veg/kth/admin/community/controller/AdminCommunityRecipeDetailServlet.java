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
import com.veg.kth.community.model.dto.Category;
import com.veg.kth.community.model.dto.Hashtag;
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.service.CommunityService;

/**
 * Servlet implementation class AdminCommunityRecipeDetailServlet
 */
@WebServlet("/admin/recipedetail.do")
public class AdminCommunityRecipeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommunityRecipeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo"));
		
		Recipe r = new AdminCommunityService().selectRecipeByNo(recipeNo);
		
		r.getMember_no();// 나중에 멤버 고유번호만으로도 고객 정보 찾기
	
		Member member = new OrderService().selectMemberByNo(r.getMember_no());
		
		List<Hashtag> hashtags = new CommunityService().selectHashtagAll();
		List<Category> category = new CommunityService().selectCategoryAll();
		
		request.setAttribute("hashtags", hashtags);
		request.setAttribute("category", category);
		
		
		request.setAttribute("member", member);
		
		request.setAttribute("recipe", r);

		request.getRequestDispatcher("/views/admin/admincommunity/communityRecipeDetail.jsp")
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
