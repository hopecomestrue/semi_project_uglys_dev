package com.veg.seoj.cscenter.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFiledownServlet
 */
@WebServlet("/filedownload.do")
public class NoticeFiledownServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFiledownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fname");

        String path = getServletContext().getRealPath("/upload/notice/");
        FileInputStream fis = new FileInputStream(path + fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        String encodingName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + encodingName);

        ServletOutputStream sos = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(sos);

        int read = -1;
        while ((read = bis.read()) != -1) {
            bos.write(read);
        }

        bis.close();
        bos.close();


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
