package com.veg.ksj.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class AdminSearchDelCheck
 */
@WebServlet("/admin/searchDelCheck.do")
public class AdminSearchDelCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchDelCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//배달 주문 현황 검색하기(이름,주문번호,주소)
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("searchType");
		String keyword=request.getParameter("searchKeyword");
		int cPage;
        try {
                cPage=Integer.parseInt(request.getParameter("cPage"));
        }catch(NumberFormatException e) {
                cPage=1;
        }
        int numPerpage=10;
                        
        
        List<Order> result=new OrderService().searchDelByKeyword(type,keyword,cPage,numPerpage);
        int totalData=new OrderService().selectDelByKeywordCount(type,keyword);
        int totalPage=(int)Math.ceil((double)totalData/numPerpage);
        int pageBarSize=5;
        int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
        int pageEnd=pageNo+pageBarSize-1;
        String pageBar="<ul class='pagination justify-content-center'>";
        if(pageNo==1) {
                pageBar+="<li class='page-item disabled'>";
                pageBar+="<a class='page-link' href='#'>이전</a>";
                pageBar+="</li>";
        }else {
                pageBar+="<li class='page-item'>";
                pageBar+="<a class='page-link' href='"
                                 +request.getRequestURI()
                                 +"?searchType="+type
                                 +"&searchKeyword="+keyword
                                 +"&cPage="+(pageNo-1)
                                 +"'>이전</a>";
                pageBar+="</li>";
        }
        
        while(!(pageNo>pageEnd||pageNo>totalPage)) {
                if(cPage==pageNo) {
                        pageBar+="<li class='page-item active'>";
                        pageBar+="<a class='page-link' href='#'>"+pageNo+"</a>";
                        pageBar+="</li>";
                }else {
                        pageBar+="<li class='page-item'>";
                        pageBar+="<a class='page-link' href='"
                                         +request.getRequestURI()
                                         +"?searchType="+type
                                         +"&searchKeyword="+keyword
                                         +"&cPage="+(pageNo)
                                         +"'>"+pageNo+"</a>";
                        pageBar+="</li>";
                }
                pageNo++;
        }
        if(pageNo>totalPage) {
                pageBar+="<li class='page-item disabled'>";
                pageBar+="<a class='page-link' href='#'>다음</a>";
                pageBar+="</li>";
        }else {
                pageBar+="<li class='page-item'>";
                pageBar+="<a class='page-link' href='"
                                 +request.getRequestURI()
                                 +"?searchType="+type
                                 +"&searchKeyword="+keyword
                                 +"&cPage="+(pageNo)
                                 +"'>다음</a>";
                pageBar+="</li>";
        }
        pageBar+="</ul>";
        
        request.setAttribute("pageBar",pageBar);
        
        request.setAttribute("orderList", result);
        
        //주문 리스트로 이동
        request.getRequestDispatcher("/views/admin/deliveryList.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
