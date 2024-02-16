package com.veg.seoj.cscenter.controller;

import com.veg.hjj.member.dto.Member;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;
import com.veg.pdw.production.service.ProductionService;
import com.veg.seoj.cscenter.model.dto.DAOImplOrder;
import com.veg.seoj.cscenter.model.dto.DAOImplRefund;
import com.veg.seoj.cscenter.model.service.InquiryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/inquiry/inquiryWrite.do")
public class InquiryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
//		List<Map<String, Object>> getProductList = new InquiryService().getProductList();
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		System.out.println("memberNo@InquiryWriteServlet="+memberNo);
		List<Production> productions = new ProductionService().selectProductionList();
		List<ProductionContent>productinContents= new ProductionService().selectProductionContentList();
/*		Map<Integer,Integer> ReviewCount=new ProductionService().selectProductionReviewList();
		Map<Integer,Double> reviewRating=new ProductionService().selectreviewRating();*/


		List<DAOImplOrder> selectOrderByMemberNo = new InquiryService().selectOrderByMemberNo(memberNo);
		System.out.println("selectOrderByMemberNo.size(): "+selectOrderByMemberNo.size());
		List<DAOImplRefund> selectRefundByMemberNo = new InquiryService().selectRefundByMemberNo(memberNo);

		request.setAttribute("productions", productions);
		request.setAttribute("productionContents", productinContents);
/*		request.setAttribute("reviewCount", ReviewCount);
		request.setAttribute("reviewRating", reviewRating);*/
		request.setAttribute("selectOrderByMemberNo", selectOrderByMemberNo);
		request.setAttribute("selectRefundByMemberNo", selectRefundByMemberNo);



		request
				.getRequestDispatcher("/views/cscenter/inquiry/inquiryWrite.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
