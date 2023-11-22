package com.veg.seoj.cscenter.controller;

import com.google.gson.Gson;
import com.veg.seoj.common.exception.BadAccessException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/kakao2.do")
public class ngRokWrite01Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ngRokWrite01Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {


    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();

            if(        gson.fromJson(request.getReader(), Object.class)==null){
                throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");

            }else{
                extracted(request);
            }
    }

    private void extracted(HttpServletRequest request) {
        ServletContext context = getServletContext();

        HttpSession session = request.getSession();
        int no=0;
        try {
            int noAttr= (int)context.getAttribute("no");

            if (noAttr != 0) {
                no = noAttr;

            } else {
                System.out.println("'no' 파라미터 없음");
            }
        } catch (NumberFormatException e) {
            System.out.println("예외 발생. 숫자로 변환 불가");
        } if (no == 1) {
            context.setAttribute("selectedProduct", 1);
        } else if (no == 2) {
            context.setAttribute("selectedProduct", 2);
        } else if (no == 3) {
            context.setAttribute("selectedProduct", 3);
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
