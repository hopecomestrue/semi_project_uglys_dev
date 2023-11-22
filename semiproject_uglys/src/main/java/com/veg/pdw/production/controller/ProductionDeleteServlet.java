package com.veg.pdw.production.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.veg.pdw.production.service.ProductionService;

/**
 * Servlet implementation class ProductionDeleteServlet
 */
@WebServlet("/production/deletes.do")
public class ProductionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("");
        }
        String json = sb.toString();

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, List<String>>>() {}.getType();
        Map<String, List<String>> data = gson.fromJson(json, type);  // JSON 데이터를 Map으로 변환

        List<String> checkedValues = data.get("checkedValues");  // 체크된 체크박스의 값들을 가져옴

		/*
		 * for (String value : checkedValues) { System.out.println(value); // 체크된 체크박스의
		 * 값들을 출력 }
		 */
        
        int result = new ProductionService().deleteProductionByNo(checkedValues);
        
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
