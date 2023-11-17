package com.veg.seoj.cscenter.controller;

import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.Notice;
import com.veg.seoj.cscenter.model.service.InquiryService;
import com.veg.seoj.cscenter.model.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/inquiry/inquiryList.do")
public class InquiryListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //DB에 저장된 전체 inquiry데이터 가져오기
        int cPage, numPerpage = 5;

//		if(request.getParameter("cPage")!=null) cPage=request;
        try {
            cPage = Integer.parseInt(request.getParameter("cPage"));
        } catch (NumberFormatException e) {
            cPage = 1;
        }

        List<Inquiry> inquiryList = new InquiryService().selectInquiry(cPage, numPerpage);
        int totalData = new InquiryService().selectInquiryCount();
        int totalPage = (int)Math.ceil((double)totalData / numPerpage);
        int pageBarSize = 5;
        int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
        int pageEnd = pageNo + pageBarSize - 1;

        String pageBar = "";

        if (pageNo == 1) {
            pageBar += "<span>이전  </span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo - 1) + "'>이전  </a>";
        }

        while (!(pageNo > pageEnd || pageNo > totalPage)) {

            if (pageNo == cPage) {
                pageBar += "<span>" + pageNo + "</span>";
            } else {
                pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + pageNo + "'>" + pageNo + "</a>";
            }
            pageNo++;
        }

        if (pageNo > totalPage) {
            pageBar += "<span>  다음</span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + pageNo + "'>  다음</a>";
        }

        request.setAttribute("inquiryList", inquiryList);
        request.setAttribute("pageBar", pageBar);

        request
                .getRequestDispatcher("/views/cscenter/inquiry/inquiryList.jsp")
                .forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
