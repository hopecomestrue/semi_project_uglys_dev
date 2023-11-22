package com.veg.seoj.cscenter.controller;

import com.google.gson.Gson;
import com.veg.seoj.common.exception.BadAccessException;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.InquiryComment;
import com.veg.seoj.cscenter.model.service.InquiryService;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/kakao.do")
public class ngrokServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ngrokServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

/*        if((request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual) !=null)){
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        }else{
                response.sendRedirect(request.getContextPath() + "/error/errortest.do");
                return;
        }*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();

        try {

            if(        gson.fromJson(request.getReader(), Object.class)==null){
                throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
                /*            response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
            }else{
                System.out.println("json 있음");
                String result = generateJson(request,response);
                response.setContentType("application/json");
                try (PrintWriter out = response.getWriter()) {
                    out.println(result);
                }
            }


        } catch (Exception e) {

            throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
            /*       response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
        }

/*        System.out.println("하이");
        System.out.println(request);*/
/*        List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");*/

/*        String result = generateJson(request,response);*/

/*        // 요청에서 JSON 데이터 추출
        String jsonBody = request
                .getReader()
                .lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);

        // JSON 데이터 출력 (테스트용)
*//*        response.setContentType("text/plain");
        PrintWriter some =  response.getWriter();
        some.println("하이하이");*//*

        *//*        System.out.println(jsonBody);*//*

        // 추출한 JSON 데이터를 다른 서블릿으로 포워딩
        request.setAttribute("jsonBody", jsonBody);*/
        /*        request.getRequestDispatcher("/inquirylist.jsp").forward(request, response);*/

/*        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(result);
        }*/
    }
     /*   "{\"version"\": \"2.0\", \"template": {
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
        doGet(request, response);

/*        System.out.println(request);*/

    }

    public String generateJson(HttpServletRequest request, HttpServletResponse response) {

/*        ServletContext context=getServletContext();*/
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(1, 9999999);
        List<Inquiry> forThisUserInquiryList = removeDuplicateInquiries(inquiryListAndComments);
//        List<Inquiry> forThisUserInquiryList = new ArrayList<>();

        System.out.println("dddddddddddddddddddd"+forThisUserInquiryList.size());
        String jsonTemplate="";

        String productionName1="";
        String orderStatus1="";
        int totalPrice1=0;
        String productionName2="";
        String orderStatus2="";
        int totalPrice2=0;
        String productionName3="";
        String orderStatus3="";
        int totalPrice3=0;

/*        Inquiry inquiry = Inquiry.builder().build();*/
        /*Member member = (Member)request.getAttribute("loginMember");*/
/*        List<DAOImplOrder> orderList = new InquiryService().selectOrderByMemberNo(5);
        List<DAOImplRefund> refundList = new InquiryService().selectRefundByMemberNo(5);*/
 /*       System.out.println("inquiryList(0) : "+inquiryList.get(0).getInquiryNo());*/
 /*       for (Inquiry inq : inquiryList22) {
            if(inq.getFkMemberNo()==39){
     *//*           System.out.println("여기 들어옴1");*//*
                forThisUserInquiryList.add(inq);
            }
        }*/
        context.setAttribute("forThisUserInquiryList",forThisUserInquiryList);
        session.setAttribute("forThisUserInquiryList",forThisUserInquiryList);
        System.out.println("forThisUserInquiryList.size()"+forThisUserInquiryList.size());
        System.out.println(forThisUserInquiryList.size() < 2);
        System.out.println(forThisUserInquiryList.size() < 3);
        System.out.println(forThisUserInquiryList.size() > 2);
        session.setAttribute("context", "contextData");
        session.setAttribute("forThisUserInquiryList", forThisUserInquiryList);

        System.out.println(forThisUserInquiryList.get(0).getInquiryNo());
        System.out.println(forThisUserInquiryList.get(0).getTotalPrice());
        System.out.println(forThisUserInquiryList.get(1).getInquiryNo());
        System.out.println(forThisUserInquiryList.get(1).getTotalPrice());
        System.out.println(forThisUserInquiryList.get(2).getInquiryNo());
        System.out.println(forThisUserInquiryList.get(2).getTotalPrice());
        System.out.println(forThisUserInquiryList.get(3).getInquiryNo());
        System.out.println(forThisUserInquiryList.get(3).getTotalPrice());
        for(int i = 0; i < 3; i++){
            if(i == 0){
                if(forThisUserInquiryList.size() < 2){
                    break;
                }
/*                productionName = forThisUserInquiryList.get(i).getProductionName();
                totalPrice = forThisUserInquiryList.get(i).getTotalPrice();*/
                System.out.println(forThisUserInquiryList.get(i).getProductionName());

                productionName1=forThisUserInquiryList.get(i).getProductionName();
                session.setAttribute("productionName1",
                                     productionName1);


                session.setAttribute("productionNo1", forThisUserInquiryList.get(i).getFkProductNo());


                totalPrice1=forThisUserInquiryList.get(i).getTotalPrice();
                System.out.println("111111111111111"+forThisUserInquiryList.get(i).getTotalPrice());
                session.setAttribute("totalPrice1", totalPrice1);

                orderStatus1=forThisUserInquiryList.get(i).getOrderStatus();
                session.setAttribute("orderStatus1", orderStatus1);

   /*             Object a = request.getAttribute("ProductionName1");
                Object b = request.getAttribute("productionNo1");*/

/*                System.out.println("여기22 a : "+ a);
                System.out.println("여기23 b : "+ b);*/
               /* OrderStatus = forThisUserInquiryList.get(i).getOrderStatus();*/
            }else if(i == 1){
                if(forThisUserInquiryList.size() < 3){
                    break;
                }
                System.out.println(forThisUserInquiryList.get(i).getProductionName());

                productionName2=forThisUserInquiryList.get(i).getProductionName();
                session.setAttribute("productionName2",
                                     productionName2);


                session.setAttribute("productionNo2", forThisUserInquiryList.get(i).getFkProductNo());


                totalPrice2=forThisUserInquiryList.get(i).getTotalPrice();
                System.out.println("22222222222222222222"+forThisUserInquiryList.get(i).getTotalPrice());
                session.setAttribute("totalPrice2", totalPrice2);

                orderStatus2=forThisUserInquiryList.get(i).getOrderStatus();
                session.setAttribute("orderStatus2", orderStatus2);
       /*         productionName2 = forThisUserInquiryList.get(i).getProductionName();
                totalPrice2 = forThisUserInquiryList.get(i).getTotalPrice();
                request.setAttribute("ProductionName2", productionName2);
                request.setAttribute("totalPrice2", forThisUserInquiryList.get(i).getTotalPrice());
                OrderStatus2 = forThisUserInquiryList.get(i).getOrderStatus();*/
            }else if(i == 2){
                if(forThisUserInquiryList.size() < 3){
                    break;
                }
                System.out.println(forThisUserInquiryList.get(i).getProductionName());

                productionName3=forThisUserInquiryList.get(i).getProductionName();
                session.setAttribute("productionName3",
                                     productionName3);
                System.out.println("3333333333333" + productionName3);
                session.setAttribute("productionNo3", forThisUserInquiryList.get(i).getFkProductNo());


                totalPrice3=forThisUserInquiryList.get(i).getTotalPrice();
                System.out.println("3333333333333333333"+forThisUserInquiryList.get(i).getTotalPrice());
                session.setAttribute("totalPrice3", totalPrice3);

                orderStatus3=forThisUserInquiryList.get(i).getOrderStatus();
                session.setAttribute("orderStatus3", orderStatus3);
/*                productionName3 = forThisUserInquiryList.get(i).getProductionName();
                totalPrice3 = forThisUserInquiryList.get(i).getTotalPrice();
                request.setAttribute("ProductionName3", productionName3);
                request.setAttribute("productionNo3", forThisUserInquiryList.get(i).getFkProductNo());
                request.setAttribute("totalPrice3", forThisUserInquiryList.get(i).getTotalPrice());
                OrderStatus3 = forThisUserInquiryList.get(i).getOrderStatus();*/
            }
        }


/*        System.out.println("{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"commerceCard\":{\"title\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"description\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"price\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"currency\":\"won\",\"thumbnails\":[{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"1\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}},{\"commerceCard\":{\"title\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"description\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"price\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"currency\":\"won\",\"thumbnails\":[{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"2\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}},{\"commerceCard\":{\"title\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"description\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"price\":\"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ\",\"currency\":\"won\",\"thumbnails\":[{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"3\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}}]}}");*/





/*        System.out.println("'{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"보물상자\",\"description\":\"보물상자 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자2\",\"description\":\"보물상자2 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자3\",\"description\":\"보물상자3 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]}]}}]}}'");*/
/*        String jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
                "\"items\":[{\"title\":\"보물상자\",\"description\":\"보물상자 안에는 뭐가 있을까\"," +
                "\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자2\",\"description\":\"보물상자2 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자3\",\"description\":\"보물상자3 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]}]}}]}}";*/
/*        String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard" +
                "\"," + "\"items\":[{\"title\":\"%s\",\"description\":\"%s\"," + "\"thumbnail\":{\"imageUrl\":\"https" +
                "://www.ibabynews" + ".com/news/photo/202012" + "/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\"," + "\"label\":\"이 주문 " + "선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"}," + "{\"action\":\"webLink\"," + "\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 " + "SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://pds" + ".joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728" + ".jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\"," + "\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]}]}}]}}";*/


        String result = "";
        if(forThisUserInquiryList.size()==1){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"https://d569fb1f67e3.ngrok.app/semiproject_uglys/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
             result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1);
            session.setAttribute("no",1);
            context.setAttribute("no",1);
        }else if(forThisUserInquiryList.size()==2){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"https://e19d44c70424.ngrok.app/semiproject_uglys/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
             result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1, productionName2,
                                          orderStatus2, totalPrice2);
            context.setAttribute("no",2);
            session.setAttribute("no",2);
        }else if(forThisUserInquiryList.size()>=3){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"https://d569fb1f67e3.ngrok.app/semiproject_uglys/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
            System.out.println(productionName1+", "+ orderStatus1+", "+totalPrice1+", "+ productionName2+", "+
                               orderStatus2+", "+ totalPrice2+", "+ productionName3+", "+ orderStatus3+", "+ totalPrice3);
            result = String.format(jsonTemplate, productionName1, orderStatus1, productionName2,
                                   orderStatus2, productionName3, orderStatus3);
 /*            result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1, productionName2,
                                          orderStatus2, totalPrice2, productionName3, orderStatus3, totalPrice3);*/
            context.setAttribute("no",3);
            session.setAttribute("no",13);
        }


/*        String jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"commerceCard\":{\"title" +
                "\":\"%s\"," +
                "\"description\":\"%s\",\"price\":\"%s\",\"currency\":\"won\"," +
                "\"thumbnails\":[{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"1\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}},{\"commerceCard\":{\"title\":\"%s\",\"description\":\"%s\",\"price\":\"%s\",\"currency\":\"won\",\"thumbnails\":[{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"2\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}},{\"commerceCard\":{\"title\":\"%s\",\"description\":\"%s\",\"price\":\"%s\",\"currency\":\"won\",\"thumbnails\":[{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\",\"link\":{\"web\":\"https://store.kakaofriends.com/kr/products/1542\"}}],\"profile\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\",\"nickname\":\"채소랑\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"extra\":{\"no\":\"3\"}},{\"action\":\"block\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}}]}}";*/



        /*String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s\"}}]}}";*/

/*      String productionName1="";
        String orderStatus1="";
        int totalPrice1=0;
        String productionName2="";
        String orderStatus2="";
        int totalPrice2=0;
        String productionName3="";
        String orderStatus3="";
        int totalPrice3=0;        */
/*        String result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1, productionName2,
                                      orderStatus2, totalPrice2,productionName3,orderStatus3,totalPrice3);*/
/*        System.out.println(result);*/

        return result;
    }
    private static List<Inquiry> removeDuplicateInquiries(List<Inquiry> inquiryListandComments) {
        List<Inquiry> filteredList = new ArrayList<>();
        Set<Integer> addedInquiryNos = new HashSet<>();
/*

        for (Inquiry inquiry : inquiryListandComments) {
            int inquiryNo = inquiry.getInquiryNo();

            if (!addedInquiryNos.contains(inquiryNo)) {
                filteredList.add(inquiry);
                addedInquiryNos.add(inquiryNo);
            }
        }

*/


        int previousMemberNo = -2;
        int previousTotalPrice = -2;

        for (Inquiry result : inquiryListandComments) {
            if (result.getFkMemberNo() != previousMemberNo && result.getTotalPrice() != previousTotalPrice) {
                // FKMemberNo가 다르거나 totalPrice가 다른 경우만 추가
                filteredList.add(result);
                System.out.println("????????"+result.getTotalPrice());
            }

            // 현재 값으로 갱신
            previousMemberNo = result.getFkMemberNo();
            previousTotalPrice = result.getTotalPrice();
        }
        /*        sortListByInquiryDateDesc(filteredList);*/
        /*        Collections.sort(filteredList, Comparator.comparing(Inquiry::getInquiryDate).reversed());*/
        return filteredList;
    }
}
