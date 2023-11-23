//package com.veg.ojy.admin.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class SearchEndServlet
// */
//@WebServlet("/searchEnd.do")
//public class SearchEndServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SearchEndServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	      String category = request.getParameter("question");
//	      System.out.println(category);
//	      int cPage,numPerpage=10; 
//	      try {
//	         cPage=Integer.parseInt(request.getParameter("cPage"));
//	      }catch(NumberFormatException e) {
//	         cPage=1;
//	      }
//	      List<Question> question;
//	      int totalData;
//	      if(category.equals("전체")) {
//	         question=new QuestionService().selectQuestion(cPage, numPerpage);
//	         totalData=new QuestionService().selectQuestionCount();  
//	      }else {
//	         question=new QuestionService().selectQuestionCategory(cPage, numPerpage,category);
//	         totalData=new QuestionService().selectQuestionCountByCategory(category);  
//	      }
//	      
//	      int totalPage=(int)Math.ceil((double)totalData/numPerpage);
//	      int pageBarSize=5;
//	      int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1; 
//	      int pageEnd=pageNo+pageBarSize-1; 
//	      
//	      
//	      StringBuffer pageBar=new StringBuffer(); 
//	      
//	      if(pageNo==1) {
//	         pageBar.append("<span>[이전]</span>"); 
//	                                 
//	      }else {
//	         pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"&question="+(category)+"'>");
//	         pageBar.append("[이전]</a>"); 
//	      }
//	      
//	      while(!(pageNo>pageEnd||pageNo>totalPage)) {
//	         if(cPage==pageNo) {
//	            pageBar.append("<span>"+pageNo+"</span>"); 
//	         }else {
//	            pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+pageNo+"&question="+(category)+"'>");
//	            pageBar.append(pageNo);
//	            pageBar.append("</a>"); 
//	         }
//	         pageNo++;
//	      }
//	      
//	      if(pageNo>totalPage) {
//	         pageBar.append("<span>[다음]</span>"); 
//	      }else {
//	         pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+pageNo+"&member"+(category)+"'>");
//	         pageBar.append("[다음]");
//	         pageBar.append("</a>"); 
//	      }
//	      
//	      request.setAttribute("member", member); 
//	      request.setAttribute("pageBar", pageBar); 
//	      request.getRequestDispatcher("/views/admin/memberManagement/memberCheck.jsp").forward(request, response); 
//	      
//	      
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
