package com.veg.pdw.production.controller;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.prodution.service.ProductionService;

/**
 * Servlet implementation class RegisterProductionServlet
 */
@WebServlet("/production/register.do")
public class RegisterProductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProductionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("잘못된 접근입니다");
		}else {
			String path = request.getServletContext().getRealPath("/upload/production/thumnail");
			int maxSize= 1024*1024*100;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy dfr= new DefaultFileRenamePolicy();
			
			MultipartRequest mr = new MultipartRequest(request,path,maxSize,encoding,dfr);
			
			
			
			Enumeration<String> fileNames = mr.getFileNames();

			while (fileNames.hasMoreElements()) {
			    String paramName = fileNames.nextElement();
			    String fileName = mr.getFilesystemName(paramName);
			    System.out.println(fileName);
			}
			
		        
			String productionName=mr.getParameter("production_name");
			int productionPrice=Integer.parseInt(mr.getParameter("production_price"));
			int productionDiscount=Integer.parseInt(mr.getParameter("production_discount"));
			String productionTag=mr.getParameter("production_tag");
			String productionEnvironment=mr.getParameter("production_environment");
			String productionPlace=mr.getParameter("production_place");
			int productionStock=Integer.parseInt(mr.getParameter("production_stock"));
			Production p=Production.builder()
					.production_name(productionName)
					.discount(productionDiscount)
					.price(productionPrice)
					.tag(productionTag)
					.environment(productionEnvironment)
					.place(productionPlace)
					.stock(productionStock)
					.build();
			int result = new ProductionService().insertProduction(p);
			
			if(result>0) {
				System.out.println("되네");
			}else {
				System.out.println("안될줄알았어");
			}
		    
	
			
		
		
		}
		
		
		
	}
		 
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
