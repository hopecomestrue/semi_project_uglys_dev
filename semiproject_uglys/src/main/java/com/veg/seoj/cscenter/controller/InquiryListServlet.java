package com.veg.seoj.cscenter.controller;

import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.InquiryMember;
import com.veg.seoj.cscenter.model.dto.Notice;
import com.veg.seoj.cscenter.model.service.InquiryService;
import com.veg.seoj.cscenter.model.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/inquiry/inquiryList.do")
public class InquiryListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String productionName = "하이1";
    String orderStatus = "하이2";
    String productionName2 = "하이3";
    String orderStatus2 = "하이4";
    String productionName3 = "하이5";
    String orderStatus3 = "하이6";
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
        int cPage;
        int numPerpage = 10;

        try {
            cPage = Integer.parseInt(request.getParameter("cPage"));
        } catch (NumberFormatException e) {
            cPage = 1;
        }

        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(cPage, numPerpage);
        List<Inquiry> inquiryList = removeDuplicateInquiries(inquiryListAndComments);
        String a = new InquiryService().generateJson(productionName, orderStatus, productionName2, orderStatus2,
                                                     productionName3, orderStatus3);

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
        request.setAttribute("inquiryTotalData",totalData);
        request.setAttribute("inquiryList", inquiryList);
        request.setAttribute("inquiryListAndComments", inquiryListAndComments);
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

    private static List<Inquiry> removeDuplicateInquiries(List<Inquiry> inquiryListandComments) {
        List<Inquiry> filteredList = new ArrayList<>();
        Set<Integer> addedInquiryNos = new HashSet<>();

        for (Inquiry inquiry : inquiryListandComments) {
            int inquiryNo = inquiry.getInquiryNo();

            if (!addedInquiryNos.contains(inquiryNo)) {
                filteredList.add(inquiry);
                addedInquiryNos.add(inquiryNo);
            }
        }

        return filteredList;
    }

}
