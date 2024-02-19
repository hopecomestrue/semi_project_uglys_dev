package com.veg.ojy.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.ojy.admin.service.*;
import com.veg.ojy.admin.dao.*;


/**
 * Servlet implementation class MemberManagementServlet
 */
@WebServlet("/MemberCheck.do")
public class MemberManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
        try {
                cPage=Integer.parseInt(request.getParameter("cPage"));
        }catch(NumberFormatException e) {
                cPage=1;
        }
        int numPerpage=10;
        
		 List<Member> members = new MemberManagementService().selectMemberAll();
		 System.out.println(members);
	     request.setAttribute("member", members);
        
        //pageBar만들기
        //1. 전체 데이터를 가져와 저장하기
        int totalData=new OrderService().selectDelCount();
        //2. 전체 페이지수를 저장하기
        int totalPage=(int)Math.ceil((double)totalData/numPerpage);
        //3. 페이지바에 출력될 번호의 갯수 설정
        int pageBarSize=5;
        //4. pageBar에 출력될 번호의 시작번호
        int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
        //5. pageBar에 출력될 번호의 끝번호
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
		
		// MemberManagementDao memberDAO = new MemberManagementDao();
//		 List<Member> members = new MemberManagementService().selectMemberAll();
//		 System.out.println(members);
//	     request.setAttribute("member", members);
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
