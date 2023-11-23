package com.veg.seoj.cscenter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.seoj.cscenter.model.dto.Notice;
import com.veg.seoj.cscenter.model.service.NoticeService;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/noticeList.do")
public class NoticeListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
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

        List<Notice> notices = new NoticeService().selectNotice(cPage, numPerpage);
        int totalData = new NoticeService().selectNoticeCount();
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

        request.setAttribute("notices", notices);
        request.setAttribute("pageBar", pageBar);

        request
                .getRequestDispatcher("/views/cscenter/notice/noticeList.jsp")
                .forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
