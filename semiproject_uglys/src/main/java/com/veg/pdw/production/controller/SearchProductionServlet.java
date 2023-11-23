package com.veg.pdw.production.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.service.ProductionService;

/**
 * Servlet implementation class SearchProductionServlet
 */
@WebServlet("/searchProduction.do")
public class SearchProductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
        String productNo = request.getParameter("product_no");
        String productName = request.getParameter("product_name");
        String priceStart = request.getParameter("price_start");
        String priceEnd = request.getParameter("price_end");
        String stockStart = request.getParameter("stock_start");
        String stockEnd = request.getParameter("stock_end");
        String productionPlace = request.getParameter("production_place");
        
        productNo = productNo.trim();
        productName = productName.trim();
        priceStart = priceStart.trim();
        priceEnd = priceEnd.trim();
        stockStart = stockStart.trim();
        stockEnd = stockEnd.trim();
        productionPlace = productionPlace.trim();
		
		Map <String,String> sql= new HashMap<>();
		Map <String,String> sql1= new HashMap<>();
        
        
		sql1.put("PRODUCT_NO", productNo);
		sql1.put("PRODUCTION_NAME", productName);
		sql1.put("PLACE", productionPlace);
        
		sql.put(priceStart," <= PRICE");
		sql.put("PRICE <= ",priceEnd);
		sql.put(stockStart," <= STOCK");
		sql.put("STOCK <= ",stockEnd);
        
		
        Iterator<Map.Entry<String, String>> iter = sql.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (entry.getValue().isEmpty()){
                iter.remove();
            }
        }
        iter = sql.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (entry.getKey().isEmpty()) {
                iter.remove();
            }
        }
        Iterator<Map.Entry<String, String>> iter1 = sql1.entrySet().iterator();
        while (iter1.hasNext()) {
            Map.Entry<String, String> entry = iter1.next();
            if (entry.getValue().isEmpty()) {
                iter1.remove();
            }
        }
        
   
        
        List<Production> productions = new ProductionService().selectSearchbyKey(sql,sql1);
        
        request.setAttribute("productions", productions);
        
        request.getRequestDispatcher("/views/admin/adminproduct/productfront.jsp")
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
