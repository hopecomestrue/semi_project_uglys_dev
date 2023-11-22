package com.veg.seoj.cscenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.seoj.cscenter.model.dto.Notice;
import com.veg.seoj.cscenter.model.service.NoticeService;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/notice/noticeView.do")
public class NoticeViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        int no = Integer.parseInt(request.getParameter("no"));

        try {
            Notice n = new NoticeService().selectNoticeByNo(no);

            System.out.println("Notice 객체가 성공적으로 받아졌습니다.");
            System.out.println("Notice 정보: " + n.toString());
            request.setAttribute("notice", n);
        } catch (Exception e) {

            System.out.println("Notice 객체를 받아오지 못했습니다. 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }


        request
                .getRequestDispatcher("/views/notice/noticeView.jsp")
                .forward(request, response);

/*      Inquiry(inquiryNo=65,
              inquiryType=상품,
              inquiryTitle=카카오 챗봇 문의,
              inquiryContent=감자가 너무 셔요,
              answerStatus=N,
              inquiryDate=2023-11-22 04:05:35.098044,
              fkMemberNo=-1,
              fkOrderNo=-1,
              inquiryRenameFilename=2023-11-22 04:05:36.272.txt,
              inquiryOriginalFilename=2023-11-22 04:05:36.272re.txt,
              fkProductNo=-1,
              memberName=Sing21letary,
              totalPrice=47404,
              orderStatus=배송완료,
              productionName=Crwafts,
              productImg=null,
              inquiryComments=[],
              refundNo=0,
              refundDate=null)*/

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
