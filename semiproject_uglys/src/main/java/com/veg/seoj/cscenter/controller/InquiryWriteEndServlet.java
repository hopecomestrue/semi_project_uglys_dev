package com.veg.seoj.cscenter.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/*            Enumeration names=mr.getFileNames();
            List<Map<String,String>> files=new ArrayList<>();
            while(names.hasMoreElements()) {
                String name=(String)names.nextElement();
                String re=mr.getFilesystemName(name);
                String ori=mr.getOriginalFileName(name);
                files.add(Map.of("rename",re,"oriName",ori));
            }*/
/*            files.forEach(e -> {
                System.out.println(e);
            });*/
            Enumeration names = mr.getFileNames();

            String name = "";
            String re = "";
            String ori = "";
            while (names.hasMoreElements()) {
                name = (String)names.nextElement();
                re = mr.getFilesystemName(name);
                ori = mr.getOriginalFileName(name);
            }
            // 배송정보, 작성자 정보 없음
            Inquiry I = Inquiry
                    .builder()
                    .inquiryType(mr.getParameter("category"))
                    .inquiryTitle(mr.getParameter("title"))
                    .inquiryContent(mr.getParameter("content"))
                    .fkMemberNo(1)
                    .fkOrderNo(2)
                    .inquiryRenameFilename(re)
                    .inquiryOriginalFilename(ori)
                    .fkProductNo(3)
                    .build();

            int result = new InquiryService().insertInquiry(I);
            String msg, loc;
            if (result > 0) {
                msg = "게시글 등록성공";
                loc = "/inquiry/inquiryList.do";
            } else {
                msg = "게시글 등록실패";
                loc = "History.back()";
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
