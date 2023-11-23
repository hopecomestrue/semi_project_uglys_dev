package com.veg.seoj.cscenter.controller;

/**
 * Brief description of functions
 *
 * @author J
 * @version 2023-11-17
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veg.hjj.member.service.MemberService;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.order.model.service.OrderService;
import com.veg.ksj.refund.model.dto.Refund;
import com.veg.ksj.refund.service.RefundService;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.service.ProductionService;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.InquiryComment;
import com.veg.seoj.cscenter.model.service.InquiryService;

@WebServlet("/inquiry/inquiryView.do")
public class InquiryViewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        Cookie[] cookies = request.getCookies();
        String readBoard = "";
        boolean readResult = false;

        for (Cookie c : cookies) {
            String name = c.getName();

            if (name.equals("readBoard")) {
                readBoard = c.getValue();

                if (readBoard.contains("|" + no + "|")) {
                    readResult = true;
                }
                break;
            }
        }

        if (!readResult) {
            Cookie c = new Cookie("readBoard", readBoard + "|" + no + "|");
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }
        Inquiry inquiry = new InquiryService().selectInquiryByNo(no);
        Order order = new OrderService().selectOrderDetailsByOrderNo(inquiry.getFkOrderNo());
        Production production = new ProductionService().selectProductionByNo(inquiry.getFkProductNo());
        Refund refund =
                new RefundService().selectRefundByOrderNo(((Object)inquiry.getRefundNo() != null|| inquiry.getRefundNo()==0) ?
                inquiry.getRefundNo() : -1);
        request.setAttribute("order", order);
        request.setAttribute("production", production);
        request.setAttribute("refund", refund);

        request.setAttribute("inquiry", inquiry);

        if (new InquiryService().selectInquiryCommentgeyByNo(no) != null) {
            List<InquiryComment> inquryComments = new InquiryService().selectInquiryCommentgeyByNo(no);
            request.setAttribute("inquryComments", inquryComments);
        } else {
            List<InquiryComment> inquryComments = new ArrayList<>();
            request.setAttribute("inquryComments", inquryComments);
        }

        request
                .getRequestDispatcher("/views/cscenter/inquiry/inquiryView.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
