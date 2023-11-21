package com.veg.seoj.cscenter.controller;

import com.veg.hjj.member.dto.Member;
import com.veg.seoj.cscenter.model.dto.DAOImplOrder;
import com.veg.seoj.cscenter.model.dto.DAOImplRefund;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.service.InquiryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println(request);
/*        List<Inquiry> inquiryList = (List<Inquiry>)request.getAttribute("inquiryList");*/


        String ProductionName = "";
        String OrderStatus = "";
        String ProductionName2 = "";
        String OrderStatus2 = "";
        String ProductionName3 = "";
        String OrderStatus3 = "";




        String result = generateJson(request,response,ProductionName, OrderStatus, ProductionName2, OrderStatus2,
                                     ProductionName3, OrderStatus3);
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

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(result);
        }
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
/*        System.out.println(request);*/
        doGet(request, response);
    }

    public String generateJson(HttpServletRequest request, HttpServletResponse response,String ProductionName,
                                      String OrderStatus,
                                      String ProductionName2,
                                      String OrderStatus2,
                                      String ProductionName3,
                                      String OrderStatus3) {

        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(1, 9999999);
        List<Inquiry> inquiryList = removeDuplicateInquiries(inquiryListAndComments);
        List<Inquiry> forThisUserInquiryList = new ArrayList<>();
/*        Inquiry inquiry = Inquiry.builder().build();*/
        /*Member member = (Member)request.getAttribute("loginMember");*/
/*        List<DAOImplOrder> orderList = new InquiryService().selectOrderByMemberNo(5);
        List<DAOImplRefund> refundList = new InquiryService().selectRefundByMemberNo(5);*/
 /*       System.out.println("inquiryList(0) : "+inquiryList.get(0).getInquiryNo());*/
        for (Inquiry inq : inquiryList) {
            if(inq.getFkMemberNo()==39){
     /*           System.out.println("여기 들어옴1");*/
                forThisUserInquiryList.add(inq);
            }
        }
        request.setAttribute("forThisUserInquiryList", forThisUserInquiryList);
        for(int i = 0; i < 3; i++){
            if(i == 0){
                if(forThisUserInquiryList.size() < 1){
                    break;
                }
                ProductionName = forThisUserInquiryList.get(i).getProductionName();
                request.setAttribute("ProductionName1", ProductionName);
                request.setAttribute("productionNo1", forThisUserInquiryList.get(i).getFkProductNo());
   /*             Object a = request.getAttribute("ProductionName1");
                Object b = request.getAttribute("productionNo1");*/

/*                System.out.println("여기22 a : "+ a);
                System.out.println("여기23 b : "+ b);*/
                OrderStatus = forThisUserInquiryList.get(i).getOrderStatus();
            }else if(i == 1){
                if(forThisUserInquiryList.size() < 2){
                    break;
                }
                ProductionName2 = forThisUserInquiryList.get(i).getProductionName();
                request.setAttribute("ProductionName2", ProductionName2);
                request.setAttribute("productionNo2", forThisUserInquiryList.get(i).getFkProductNo());
                OrderStatus2 = forThisUserInquiryList.get(i).getOrderStatus();
            }else if(i == 2){
                if(forThisUserInquiryList.size() < 3){
                    break;
                }
                ProductionName3 = forThisUserInquiryList.get(i).getProductionName();
                request.setAttribute("ProductionName3", ProductionName3);
                request.setAttribute("productionNo3", forThisUserInquiryList.get(i).getFkProductNo());
                OrderStatus3 = forThisUserInquiryList.get(i).getOrderStatus();
            }
        }

/*        System.out.println("'{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"보물상자\",\"description\":\"보물상자 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자2\",\"description\":\"보물상자2 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자3\",\"description\":\"보물상자3 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]}]}}]}}'");*/
/*        String jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
                "\"items\":[{\"title\":\"보물상자\",\"description\":\"보물상자 안에는 뭐가 있을까\"," +
                "\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자2\",\"description\":\"보물상자2 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자3\",\"description\":\"보물상자3 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]}]}}]}}";*/
        String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard" +
                "\"," + "\"items\":[{\"title\":\"%s\",\"description\":\"%s\"," + "\"thumbnail\":{\"imageUrl\":\"https" +
                "://www.ibabynews" + ".com/news/photo/202012" + "/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\"," + "\"label\":\"이 주문 " + "선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"}," + "{\"action\":\"webLink\"," + "\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 " + "SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://pds" + ".joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728" + ".jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\"," + "\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]}]}}]}}";
        /*String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s\"}}]}}";*/

        String result = String.format(jsonTemplate, ProductionName, OrderStatus, ProductionName2, OrderStatus2,
                                      ProductionName3, OrderStatus3);
/*        System.out.println(result);*/

        return result;
    }
    private static List<Inquiry> removeDuplicateInquiries(List<Inquiry> inquiryListandComments) {
        List<Inquiry> filteredList = new ArrayList<>();
        Set<Integer> addedInquiryNos = new HashSet<>();

        for (Inquiry inquiry : inquiryListandComments) {
            int inquiryNo = inquiry.getInquiryNo();

            if (!addedInquiryNos.contains(inquiryNo)) {
                filteredList.add(inquiry);
                addedInquiryNos.add(inquiryNo);
            }
        }
        /*        sortListByInquiryDateDesc(filteredList);*/
        /*        Collections.sort(filteredList, Comparator.comparing(Inquiry::getInquiryDate).reversed());*/
        return filteredList;
    }
}
