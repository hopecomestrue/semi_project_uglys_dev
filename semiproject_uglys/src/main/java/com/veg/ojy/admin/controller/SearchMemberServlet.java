package com.veg.ojy.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.veg.ojy.admin.service.MemberManagementService;
import com.veg.hjj.member.dto.Member;


/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/SearchMemberServlet")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String type=request.getParameter("searchType");
	      String keyword=request.getParameter("searchKeyword");
	      int cPage;
	      try {
	         cPage=Integer.parseInt(request.getParameter("cPage"));
	      }catch(NumberFormatException e) {
	         cPage=1;
	      }
	      int numPerpage=5;
	            
	      
	      List<Member> result=new MemberManagementService().searchMemberByKeyword(type,keyword,cPage,numPerpage);
	      int totalData=new MemberManagementService().selectMemberByKeywordCount(type,keyword);
	      int totalPage=(int)Math.ceil((double)totalData/numPerpage);
	      int pageBarSize=5;
	      int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
	      int pageEnd=pageNo+pageBarSize-1;
	      String pageBar="<ul class='pagination justify-content-center'>";
	      if(pageNo==1) {
	         pageBar+="<li class='page-item disabled'>";
	         pageBar+="<a class='page-link' href='#'></a>";
	         pageBar+="</li>";
	      }else {
	         pageBar+="<li class='page-item'>";
	         pageBar+="<a class='page-link' href='"
	                +request.getRequestURI()
	                +"?searchType="+type
	                +"&searchKeyword="+keyword
	                +"&cPage="+(pageNo-1)
	                +"'></a>";
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
	         pageBar+="<a class='page-link' href='#'></a>";
	         pageBar+="</li>";
	      }else {
	         pageBar+="<li class='page-item'>";
	         pageBar+="<a class='page-link' href='"
	                +request.getRequestURI()
	                +"?searchType="+type
	                +"&searchKeyword="+keyword
	                +"&cPage="+(pageNo)
	                +"'></a>";
	         pageBar+="</li>";
	      }
	      pageBar+="</ul>";
	      
	      request.setAttribute("pageBar",pageBar);
	      
	      request.setAttribute("members", result);
	 
	      request.getRequestDispatcher("/views/admin/memberManagement/memberCheck.jsp").forward(request, response);
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
