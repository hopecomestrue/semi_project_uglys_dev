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

/*        if((request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual) !=null)){
            System.out.println("json 있음");
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        }else{
            System.out.println("json 없음");
            response.sendRedirect(request.getContextPath() + "/error/errortest.do");
            return;
        }*/
        // Gson 객체 생성
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();

        try {

            if(        gson.fromJson(request.getReader(), Object.class)==null){
                throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
    /*            response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
            }else{
                System.out.println("json 있음");
                extracted(request);
            }


        } catch (Exception e) {

            throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
     /*       response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
        }




        // 요청에서 JSON 데이터 추출
      /*  String jsonBody = request
                .getReader()
                .lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);

        // JSON 데이터 출력 (테스트용)
*//*        response.setContentType("text/plain");
        PrintWriter some =  response.getWriter();
        some.println("하이하이");*//*


        *//*        System.out.println(jsonBody);*//*

        // 추출한 JSON 데이터를 다른 서블릿으로 포워딩
        request.setAttribute("jsonBody", jsonBody);
        jsonBody = jsonBody.replace("\"", "\\\"");

        *//*        request.getRequestDispatcher("/inquirylist.jsp").forward(request, response);*//*


        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonBody);
        }*/
    }

    private void extracted(HttpServletRequest request) {
/*        ServletContext context=getServletContext();*/
        HttpSession session = request.getSession();
        int no=0;
        try {


            int noAttr= (int)session.getAttribute("no");
/*             String noAttr= (String)context.getAttribute("no");*/
            if (noAttr != 0) {
                no = noAttr;
/*                no = Integer.parseInt(noAttr);*/
                System.out.println("형변환: " + no);
            } else {
                System.out.println("'no' 파라미터 없음");
            }
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우 예외 처리
            System.out.println("예외 발생. 숫자로 변환 불가");
        } if (no == 1) {
            System.out.println("여기 55");
            session.setAttribute("selectedProduct", 1);
            System.out.println("여기 56");
        } else if (no == 2) {
            System.out.println("여기 57");
            session.setAttribute("selectedProduct", 2);
            System.out.println("여기 58");
        } else if (no == 3) {
            System.out.println("여기 59");
            session.setAttribute("selectedProduct", 3);
            System.out.println("여기 60");
        }
    }


/*    "'{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"해당 주문에 대한 " +
            "문의를 작성해 주세요.\"}}]}}'"*/
   /* "'{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
            "\"items\":[{\"title\":\"P.PRODUCTION_NAME\",\"description\":\"S.ORDER_STATUS\"," +
            "\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews" + ".com/news/photo/202012" +
            "/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\"," + "\"label\":\"이 주문 " +
            "선택\",\"messageText\":\"해당상품에 대한 문의하기\"}," + "{\"action\":\"webLink\"," +
            "\"label\":\"구경하기\"," +
            "\"webLinkUrl\":\"해당 문의로 가는 " + "SERVLET주소\"}]},{\"title\":\"S.ORDER_STATUS2\",\"description\":\"P" + ".PRODUCTION_NAME2\",\"thumbnail\":{\"imageUrl\":\"https://pds.joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당상품에 대한 문의하기\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]},{\"title\":\"P.PRODUCTION_NAME\",\"description\":\"P.PRODUCTION_NAME3\",\"thumbnail\":{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당상품에 대한 문의하기\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]}]}}]}}'"*/
    /* {
        "version": "2.0",
            "outputs": [
            {
                "carousel": {
                "type": "basicCard",
                        "items": [
                {
                    "title": "P.PRODUCTION_NAME",
                        "description": "S.ORDER_STATUS",
                        "thumbnail": {
                    "imageUrl": "https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg"
                },
                    "buttons": [
                    {
                        "action": "message",
                            "label": "이 주문 선택",
                            "messageText": "해당 주문에 대한 문의를 작성해 주세요."
                    },
                    {
                        "action":  "webLink",
                            "label": "구경하기",
                            "webLinkUrl": "해당 문의로 가는 SERVLET주소"
                    }
              ]
                },
                {
                    "title": "S.ORDER_STATUS2",
                        "description": "P.PRODUCTION_NAME2",
                        "thumbnail": {
                    "imageUrl": "https://pds.joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728.jpg"
                },
                    "buttons": [
                    {
                        "action": "message",
                            "label": "이 주문 선택",
                            "messageText": "해당 주문에 대한 문의를 작성해 주세요."
                    },
                    {
                        "action":  "webLink",
                            "label": "구경하기",
                            "webLinkUrl": "해당 문의로 가는 SERVLET주소"
                    }
              ]
                },
                {
                    "title": "S.ORDER_STATUS3",
                        "description": "P.PRODUCTION_NAME3",
                        "thumbnail": {
                    "imageUrl": "https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg"
                },
                    "buttons": [
                    {
                        "action": "message",
                            "label": "이 주문 선택",
                            "messageText": "해당 주문에 대한 문의를 작성해 주세요."
                    },
                    {
                        "action":  "webLink",
                            "label": "구경하기",
                            "webLinkUrl": "해당 문의로 가는 SERVLET주소"
                    }
              ]
                }
          ]
            }
            }
    ]
        }
        }

    }






        try (PrintWriter out = response.getWriter()) {
            out.println("{"version":"2.0","template":{"outputs":[{"carousel":{"type":"basicCard","items":[{"title":"P.PRODUCTION_NAME","description":"S.ORDER_STATUS","thumbnail":{"imageUrl":"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg"},"buttons":[{"action":"message","label":"이 주문 선택","messageText":"해당 주문에 대한 문의를 작성해 주세요."},{"action":"webLink","label":"구경하기","webLinkUrl":"해당 문의로 가는 SERVLET주소"}]},{"title":"S.ORDER_STATUS2","description":"P.PRODUCTION_NAME2","thumbnail":{"imageUrl":"https://pds.joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728.jpg"},"buttons":[{"action":"message","label":"이 주문 선택","messageText":"해당 주문에 대한 문의를 작성해 주세요."},{"action":"webLink","label":"구경하기","webLinkUrl":"해당 문의로 가는 SERVLET주소"}]},{"title":"S.ORDER_STATUS3","description":"P.PRODUCTION_NAME3","thumbnail":{"imageUrl":"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg"},"buttons":[{"action":"message","label":"이 주문 선택","messageText":"해당 주문에 대한 문의를 작성해 주세요."},{"action":"webLink","label":"구경하기","webLinkUrl":"해당 문의로 가는 SERVLET주소"}]}]}}]}}");
        }










        SELECT RESULT.*,M.MEMBER_NAME,S.TOTAL_PRICE,S.ORDER_STATUS,P.PRODUCTION_NAME,PC.PRODUCT_IMG,IC.*,R.REFUND_NO,R.REFUND_DATE FROM (SELECT ROWNUM AS RNUM, I.* FROM (SELECT * FROM INQUIRY ORDER BY INQUIRY_DATE DESC) I) RESULT JOIN MEMBER M ON RESULT.MEMBER_NO = M.MEMBER_NO LEFT JOIN SHOP_ORDER S ON RESULT.ORDER_NO = S.ORDER_NO LEFT JOIN PRODUCTION P ON RESULT.PRODUCT_NO = P.PRODUCT_NO LEFT JOIN PRODUCTION_CONT PC ON P.PRODUCT_NO = PC.PRODUCT_NO LEFT JOIN INQUIRY_COMMENT IC ON RESULT.INQUIRY_NO = IC.INQUIRY_NO LEFT JOIN REFUND R ON S.ORDER_NO = R.ORDER_NO WHERE RESULT.INQUIRY_NO = 14
        여기서*/


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println(request);
        doGet(request, response);
    }

}
