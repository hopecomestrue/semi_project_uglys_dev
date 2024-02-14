package com.veg.kth.community.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.dto.Member;
import com.veg.kth.community.model.dto.Material;
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.model.dto.RecipeComment;
import com.veg.kth.community.service.CommunityService;

/**
 * Servlet implementation class CommunityDetailServlet
 */
@WebServlet("/community/recipedetail.do")
public class CommunityDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo"));
		
		Recipe r = new CommunityService().selectRecipeByNo(recipeNo);
	
		Collections.sort(r.getMaterial(),(m1, m2)-> m1.getMaterialType().compareTo(m2.getMaterialType()));
		
		List<Material> mainM = new ArrayList<>();
		List<Material> subM = new ArrayList<>();
		List<Material> sourceM = new ArrayList<>();
		
		for(Material m : r.getMaterial()) {
			if(m.getMaterialType().equals("MAIN")) {
				mainM.add(m);
			}
			if(m.getMaterialType().equals("SUB")) {
				subM.add(m);
			}
			if(m.getMaterialType().equals("SOURCE")) {
				sourceM.add(m);
			}
		}
		
		
		Member member = new CommunityService().selectMemberByNo(r.getMember_no()); // 나중에 멤버 고유번호만으로도 고객 정보 찾기
		
		List<RecipeComment> comments = new CommunityService().selectRecipeComment(recipeNo);

		int lengthM = Math.max(mainM.size(), Math.max(subM.size(), sourceM.size()));
		
		System.out.println(mainM);
		System.out.println(subM);
		System.out.println(sourceM);
		System.out.println(lengthM);
		
		request.setAttribute("member", member);
		request.setAttribute("recipe", r);
		request.setAttribute("comments", comments);
		request.setAttribute("mainM", mainM);
		request.setAttribute("subM", subM);
		request.setAttribute("sourceM", sourceM);
		request.setAttribute("lengthM", lengthM);
		
		request.getRequestDispatcher("/views/community/detail_recipe.jsp")
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
