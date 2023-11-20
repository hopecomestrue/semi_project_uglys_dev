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

import com.veg.pdw.production.service.ProductionService;

/**
 * Servlet implementation class ProductionListJSPServlet
 */
@WebServlet("/ProductionListJSPServlet")
public class ProductionListJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductionListJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Production> productions = new ProductionService().selectProductionList();
		List<ProductionContent>productinContents= new ProductionService().selectProductionContentList();
		Map<Integer,Integer> ReviewCount=new ProductionService().selectProductionReviewList();
		Map<Integer,Double> reviewRating=new ProductionService().selectreviewRating();
		request.setAttribute("productions", productions);
		request.setAttribute("productionContents", productinContents);
		request.setAttribute("reviewCount", ReviewCount);
		request.setAttribute("reviewRating", reviewRating);
		
		
		request.getRequestDispatcher("/views/vegfarm/vegfarmlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
