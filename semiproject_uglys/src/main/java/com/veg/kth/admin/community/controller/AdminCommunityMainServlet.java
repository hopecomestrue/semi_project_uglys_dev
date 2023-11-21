package com.veg.kth.admin.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.ksj.order.model.service.OrderService;
import com.veg.kth.admin.community.service.AdminCommunityService;
import com.veg.kth.community.model.dto.Recipe;

/**
 * Servlet implementation class AdminCommunityMainServlet
 */
@WebServlet("/admin/recipeList.do")
public class AdminCommunityMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommunityMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문 페이지 페이징 처리 리스트 출력
		int cPage;
        try {
                cPage=Integer.parseInt(request.getParameter("cPage"));
        }catch(NumberFormatException e) {
                cPage=1;
        }
        int numPerpage=10;
		
		//페이징 처리 제외
		List<Recipe> recipes = new AdminCommunityService().selectRecipeAllByPage();

		request.setAttribute("recipes", recipes);
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
		
		
		request.getRequestDispatcher("/views/admin/admincommunity/communityRecipe.jsp")
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
