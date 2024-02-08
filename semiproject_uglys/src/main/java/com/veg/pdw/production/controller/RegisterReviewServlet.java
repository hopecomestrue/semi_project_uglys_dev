package com.veg.pdw.production.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.pdw.production.model.dto.ProductionReview;
import com.veg.pdw.production.service.ProductionService;

/**
 * Servlet implementation class RegisterReviewServlet
 */
@WebServlet("/production/review.do")
public class RegisterReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int productionNo = (Integer.parseInt(request.getParameter("productionNo")));
		int rating = (Integer.parseInt(request.getParameter("rating")));
		String content = request.getParameter("content");
		int memberNo = (Integer.parseInt(request.getParameter("member")));
		
		ProductionReview pr =ProductionReview.builder()
											.reviewContent(content)
											.productionNo(productionNo)
											.memberNo(memberNo)
											.rating(rating)
											.build();
		int result = new ProductionService().insertProductionReview(pr);
		
		response.sendRedirect(request.getContextPath()+"/vegfarm/vegfarm.do?no="+productionNo);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
