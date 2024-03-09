package com.veg.pdw.production.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.service.ProductionService;


/**
 * Servlet implementation class ProductionIndexJSPServlet
 */
@WebServlet("/admin/production.do")
public class ProductionIndexJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductionIndexJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage,numPerpage=5;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		
		List<Production> productions = new ProductionService()
								.selectProductions(cPage,numPerpage);
								
		int totalData=new ProductionService().selectProductionsCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		String pageBar="<ul class='pagination justify-content-center'>";
        
        if(pageNo==1) {
                pageBar+="<li class='page-item disabled'><a class='page-link' href='#'>이전</a></li>";
        }else {
                pageBar+="<li class='page-item'><a class='page-link' href='"+request.getRequestURI()
                                        +"?cPage="+(pageNo-1)+"'>이전</a></li>";
        }
        while(!(pageNo>pageEnd||pageNo>totalPage)) {
                if(pageNo==cPage) {
                        pageBar+="<li class='page-item active'><a class='page-link' href='#'>"+pageNo+"</a></li>";
                }else {
                        pageBar+="<li class='page-item'><a class='page-link' href='"+request.getRequestURI()
                                        +"?cPage="+pageNo+"'>"+pageNo+"</a></li>";
                }
                pageNo++;
        }
        
        if(pageNo>totalPage) {
                pageBar+="<li class='page-item disabled'><a class='page-link' href='#'>다음</a></li>";
        }else {
                pageBar+="<li class='page-item'><a class='page-link' href='"+request.getRequestURI()
                                +"?cPage="+pageNo+"'>다음</a></li>";
        }
        pageBar+="</ul>";
		
		
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("productions", productions);
		//request.setAttribute("cPage", cPage);
		
		
		
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
