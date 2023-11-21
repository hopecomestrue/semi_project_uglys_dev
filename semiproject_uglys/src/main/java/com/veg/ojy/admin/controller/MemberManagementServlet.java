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
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		
		int numPerpage = 5;
		//출력될 페이지 고정.
		
		
		
		// DB web계정의 member테이블의 전체 데이터를 가져오기
		// -> 전체 가져오는 건 jdbc 
		
		// 가져온 데이터를 화면에 출력하기 전체 데이터 출력하는 화면을 선택해주기 
		List<Member> members = new MemberManagementService().searchMemberList(cPage, numPerpage); // cPage, numPerpage 보내기.
		// -> 다수의 객체 -> 객체를 다수로 저장할 수 있는 것 List 사용하기.
		//List<Member> members = new AdminService().searchMemberList();
		// 매개변수 없이 다 가져오는 거, 클라이언트가 요청한 값이 없다면 getParameter() 안씀!
		

		request.setAttribute("members", members);
		// 가져온 데이터를 화면에서 출력되도록!! 
		// 공용객체 이용!

		
		// pageBar만들기~~ 재미있겠다!!
		// 1. 전체 데이터를 가져와 저장하기
		int totalData = new MemberManagementService().selectMemberCount();
		
		// 2. 전체 페이지수를 저장하기
		int totalPage = (int) Math.ceil((double) totalData / numPerpage);
		// totalData / numPerpage -> 정수(int) 실수가 나오면 소수점 버림.
		// double로 바꿔주면 자료형이 안맞음 (int totalpage)
		// (int)(double) totalData / numPerpage -> (double)의미가 없어짐
		// (int) Math.ceil((double) //소수점 올림처리 해버리기.
		// (int) Math.round((double) // 반올림처리
		
		// 3. 페이지바에 출력될 번호의 갯수 설정
		int pageBarSize = 5;
		
		// 4. pageBar에 출력될 번호의 시작번호
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		
		// 5. pageBar에 출력될 번호의 끝번호
		int pageEnd = pageNo + pageBarSize - 1;
		
		// 1~5번 데이터들은 html 출력하는 페이지바를 만들기위한 값들!! 
		// 1번 누르면 1번페이지 요청하도록 만드는것.

		String pageBar = "<ul class='pagination justify-content-center'>";
		// String pageBar를 저장하는 문자열이 필요함!!! 
		// 

		if (pageNo == 1) {
			// 페이지 번호가 1이면 앞으로 갈 값이 없음.
			pageBar += "<li class='page-item disabled'><a class='page-link' href='#'></a></li>";
		} else {
			// 페이지 번호가 1이 아니면 이전값이 있음. -> 이동할 수 있도록 a태그 사용. // ?Page 써서 보내기..=?가 머야..
			pageBar += "<li class='page-item'><a class='page-link' href='" + request.getRequestURI() + "?cPage="
					+ (pageNo - 1) + "'></a></li>";
		}
		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			// 반복문으로 1씩 증가하게 만들어주는 것!
			// pageNo가 pageEnd보다 또는 totalPage 크지 않으면 (작으면) 돌아!! 
			if (pageNo == cPage) {
				// pageNo 현재 보는 페이지와 같으면, 클릭되지 않도록!
				pageBar += "<li class='page-item active'><a class='page-link' href='#'>" + pageNo + "</a></li>";
			} else {
				// 현재 보는 페이지와 다르면, 이동할 수 있도록! 번호 출력을 해줘야.
				pageBar += "<li class='page-item'><a class='page-link' href='" + request.getRequestURI() + "?cPage="
						+ pageNo + "'>" + pageNo + "</a></li>";
			}
			pageNo++;
			//빠져나오게 하려면 pageNo를 1씩증가하게끔!!   
		}

		if (pageNo > totalPage) {
			// totalpage보다 커야 while에서 빠져나올 수 있음.
			pageBar += "<li class='page-item disabled'><a class='page-link' href='#'></a></li>";
		} else {
			// totalpage보다 작으면 다음 값이 있다는 것.
			pageBar += "<li class='page-item'><a class='page-link' href='" + request.getRequestURI() + "?cPage="
					+ pageNo + "'></a></li>";
		}
		pageBar += "</ul>";
		request.setAttribute("pageBar", pageBar);
		//저장 ㄴㄱ

		// 가져온 데이터를 화면에 출력하기-> 전체데이터를 출력하는 화면선택하기
		request.getRequestDispatcher("/views/admin/memberManagement/memberCheck.jsp").forward(request, response);
		// members에 저장했으니까 출력하기! -> jsp만들기
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
