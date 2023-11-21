package com.veg.pdw.production.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;
import com.veg.pdw.production.model.dto.ProductionReview;
import com.veg.pdw.production.service.ProductionService;

/**
 * Servlet implementation class VegfarmSevlet
 */
@WebServlet("/vegfarm/vegfarm.do")
public class VegfarmSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VegfarmSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productionNo=Integer.parseInt(request.getParameter("no"));
		
		Production p = new ProductionService().selectProductionByNo(productionNo);
		ProductionContent pc = new ProductionService().selectProductionContentByNo(productionNo);
		request.setAttribute("production", p);
		request.setAttribute("productionContent", pc);
		Map<Integer,Integer> ReviewCount=new ProductionService().selectProductionReviewList();
		Map<Integer,Double> reviewRating=new ProductionService().selectreviewRating();
		List<ProductionReview>pr= new ProductionService().selectProductionReviewByNo(productionNo);
		
		request.setAttribute("reviewCount", ReviewCount);
		request.setAttribute("reviewRating", reviewRating);
		request.setAttribute("ProductionReviews", pr);
		
		
		
		request.getRequestDispatcher("/views/vegfarm/vegfarm.jsp")
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
