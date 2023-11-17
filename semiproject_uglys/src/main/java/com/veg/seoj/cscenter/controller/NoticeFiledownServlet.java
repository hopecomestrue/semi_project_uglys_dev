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
        //파일 다운로드 기능 구현하기
        //클라이언트가 요청한 파일 이름 가져오기
        String fileName = request.getParameter("fname");

        //파일 스트림연결하기
        //실제 경로가져오기
        String path = getServletContext().getRealPath("/upload/notice/");
        FileInputStream fis = new FileInputStream(path + fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        //파일명 인코딩처리하기
        String encodingName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");


        //응답해더설정 -> contentType설정
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + encodingName);

        //사용자에게 파일 데이터 전송
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
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
