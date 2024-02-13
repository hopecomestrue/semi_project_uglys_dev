package com.veg.seoj.cscenter.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.internal.Streams;
import com.veg.seoj.common.exception.BadAccessException;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.service.InquiryService;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/inquiry/inquiryWriteEnd.do")
public class InquiryWriteEndServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
        } else {
            String path = getServletContext().getRealPath("/upload/");
            path += "inquiry";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 100, "UTF-8",
                                                       new DefaultFileRenamePolicy());

            Enumeration names = mr.getFileNames();

            String name = "";
            String re = "";
            String ori = "";
            while (names.hasMoreElements()) {
                name = (String)names.nextElement();
                System.out.println("name: "+name);
                re = mr.getFilesystemName(name);
                System.out.println("re: "+re);
                ori = mr.getOriginalFileName(name);
                System.out.println("ori: "+ori);
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String refundDateString = mr.getParameter("refundDate");
            Date refundDate = null;
            try {
                refundDate = (refundDateString != null && !refundDateString.isEmpty()) ? new Date(dateFormat
                                                                                                          .parse(refundDateString)
                                                                                                          .getTime()) : null;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Inquiry I = Inquiry
                    .builder()
                    .inquiryType(mr.getParameter("category"))
                    .inquiryTitle(mr.getParameter("title"))
                    .inquiryContent(mr.getParameter("content"))
                    .fkMemberNo(((mr.getParameter("memberNo") != null && !mr
                            .getParameter("memberNo")
                            .equals(""))) ? Integer.parseInt(mr.getParameter("memberNo")) : -1)
                    .fkOrderNo(((mr.getParameter("orderNo") != null && !mr
                            .getParameter("orderNo")
                            .equals(""))) ? Integer.parseInt(mr.getParameter("orderNo")) : -1)
                    .inquiryRenameFilename(re)
                    .inquiryOriginalFilename(ori)
                    .fkProductNo(((mr.getParameter("productNo") != null && !mr
                            .getParameter("productNo")
                            .equals(""))) ? Integer.parseInt(mr.getParameter("productNo")) : -1)
                    .memberName(mr.getParameter("memberName"))
                    .totalPrice(((mr.getParameter("totalPrice") != null && !mr
                            .getParameter("totalPrice")
                            .equals(""))) ? Integer.parseInt(mr.getParameter("totalPrice")) : -1)
                    .orderStatus(mr.getParameter("orderStatus"))
                    .productionName(mr.getParameter("productionName"))
                    .productImg(mr.getParameter("productImg"))
                    .refundNo(((mr.getParameter("refundNo") != null && !mr
                            .getParameter("refundNo")
                            .equals(""))) ? Integer.parseInt(mr.getParameter("refundNo")) : -1)
                    .refundDate(refundDate)
                    .inquiryComments(new ArrayList<>())
                    .build();

            int result = new InquiryService().insertInquiry(I);
            String msg, loc;
            if (result > 0) {
                msg = "게시글 등록성공";
                loc = "/inquiry/inquiryList.do";
            } else {
                msg = "게시글 등록실패";
                loc = "javascript:history.back();";
                File delFile = new File(path + I.getInquiryRenameFilename());
                if (delFile.exists()) {
                    delFile.delete();
                }
            }
            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);

            request
                    .getRequestDispatcher("/views/cscenter/msg.jsp")
                    .forward(request, response);
        }
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
