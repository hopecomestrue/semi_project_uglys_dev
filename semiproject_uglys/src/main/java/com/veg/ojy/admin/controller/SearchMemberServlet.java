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
@WebServlet("/searchMember.do")
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	      //검색창으로 search 하는 서블릿 
	      //넘겨준 값 갖고오기 name값 2개 가져오기 
	      String key = request.getParameter("searchKey");
	      String keyword = request.getParameter("searchKeyword");
	      System.out.println(key +", "+ keyword);
	      //서비스->dao->쿼리문까지 가져가서 select문에 넣어서 선택해서 가져오기 
	      int cPage;
	      try {
	         cPage=Integer.parseInt(request.getParameter("cPage"));
	      }catch(NumberFormatException e) {
	         cPage=1;
	      }
	      int numPerpage=10;
	      
	      List<Member> searchResult = new MemberManagementService().searchMember(key, keyword,cPage,numPerpage);
	      int totalData = new MemberManagementService().selectMemberCount(key,keyword);
	     System.out.println("result:"+ searchResult);
	      
	      int totalPage=(int)Math.ceil((double)totalData/cPage);
	      int pageBarSize=5;
	      int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1; 
	      int pageEnd=pageNo+pageBarSize-1; 
	      
	      
	      StringBuffer pageBar=new StringBuffer(); 
	      
	      if(pageNo==1) {
	         pageBar.append("<span>[이전]</span>"); 
	                                 
	      }else {
	         pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"&searchKeyword="+(keyword)+"'>");
	         pageBar.append("[이전]</a>"); 
	      }
	      
	      while(!(pageNo>pageEnd||pageNo>totalPage)) {
	         if(cPage==pageNo) {
	            pageBar.append("<span>"+pageNo+"</span>"); 
	         }else {
	            pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+pageNo+"&searchKeyword="+(keyword)+"'>");
	            pageBar.append(pageNo);
	            pageBar.append("</a>"); 
	         }
	         pageNo++;
	      }
		request.setAttribute("member", searchResult);
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
