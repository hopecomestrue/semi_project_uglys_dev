package com.veg.seoj.cscenter.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.veg.seoj.common.exception.BadAccessException;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.service.InquiryService;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/kakao3.do")
public class ngRokWrite02Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ngRokWrite02Servlet() {
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
        Gson gson = new Gson();

        try {

            if(        gson.fromJson(request.getReader(), Object.class)==null){
                throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
                /*            response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
            }else{
                System.out.println("json 있음");
                requestExport(request, response);
            }


        } catch (Exception e) {

            throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
            /*       response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
        }


/*        if((request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual) !=null)){
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        }else{
            response.sendRedirect(request.getContextPath() + "/error/errortest.do");
            return;
        }*/


    }

    private void requestExport(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("하 22222222");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        System.out.println("하 11111111");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(requestBody.toString()).getAsJsonObject();

        JsonObject userRequestNode = json.getAsJsonObject("userRequest");
        String utterance = userRequestNode.getAsJsonPrimitive("utterance").getAsString();
/*        JsonObject userRequestNode2 = json.getAsJsonObject("extra");
        int no = userRequestNode.getAsJsonPrimitive("no").getAsInt();*/
        // Now 'utterance' variable contains the value of 'utterance' from the JSON
        System.out.println("받은 utterance: " + utterance);
        String jsonResult = generateJson(request,response,utterance);
        // Your further processing logic here...

        // Send a response if needed
        response
                .getWriter().write(jsonResult);




    }

    private String generateJson(HttpServletRequest request, HttpServletResponse response,String utterance) {

      /*  ServletContext context=getServletContext();*/
        HttpSession session = request.getSession();

/*        String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard" +
                "\"," + "\"items\":[{\"title\":\"%s\",\"description\":\"%s\"," + "\"thumbnail\":{\"imageUrl\":\"https" +
                "://www.ibabynews" + ".com/news/photo/202012" + "/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\"," + "\"label\":\"이 주문 " + "선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"}," + "{\"action\":\"webLink\"," + "\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 " + "SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://pds" + ".joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728" + ".jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\"," + "\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]}]}}]}}";*/
        System.out.println("여기1");
String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s\"}}]}}";
        System.out.println("여기2");
      /*  List<Inquiry>forThisUserInquiryList = (List<Inquiry>)session.getAttribute("forThisUserInquiryList");*/
        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(1, 9999999);
        List<Inquiry> forThisUserInquiryList = removeDuplicateInquiries(inquiryListAndComments);
        if((int)session.getAttribute("no")==1){
            String ProductionName1 = (session.getAttribute("productionName1") != null) ? (String)session.getAttribute(
                    "productionName1") : "상품이름";
            String ProductNo1 = ((String)session.getAttribute("productionName1") != null) ?
                    (String)session.getAttribute(
                    "productionNo1") : "선택 상품번호 없음";
        }else if((int)session.getAttribute("no")==2) {
            String ProductionName2 = (session.getAttribute("productionName2") != null) ? (String)session.getAttribute(
                    "productionName2") : "상품이름";
            String ProductNo2 = ((String)session.getAttribute("productionName1") != null) ?
                    (String)session.getAttribute(
                            "productionNo2") : "선택 상품번호 없음";
        }else if((int)session.getAttribute("no")==3) {
            String ProductionName3 = (session.getAttribute("productionName3") != null) ? (String)session.getAttribute(
                    "productionName3") : "상품이름";
            String ProductNo3 = ((String)session.getAttribute("productionName1") != null) ?
                    (String)session.getAttribute(
                            "productionNo3") : "선택 상품번호 없음";
        }

        System.out.println("여기3");
/*        String result = String.format(jsonTemplate, ProductionName, OrderStatus, ProductionName2, OrderStatus2,
                                      ProductionName3, OrderStatus3);*/

/*        System.out.println(result);*/
/*        Inquiry.InquiryBuilder builder = null;*/
       int selectedProductNum = (int)session.getAttribute("selectedProduct");

        if((int)session.getAttribute("no")==1){
             selectedProductNum = 1;
        }else if((int)session.getAttribute("no")==2){
             selectedProductNum = 2;
        }else if((int)session.getAttribute("no")==3){
             selectedProductNum = 3;
        }

        System.out.println("여기4");
        System.out.println("selectedProduct : " + selectedProductNum);

        System.out.println("여기5");
/*        if(selectedProductNum ==1){
             productNo = (int)request.getAttribute("productionNo1");
        }else if(selectedProductNum ==2){
            productNo = (int)request.getAttribute("productionNo2");
        }else if(selectedProductNum ==3){
            productNo = (int)request.getAttribute("productionNo3");
        }*/
        System.out.println("여기6");

        java.util.Date utilDate = new java.util.Date();
        System.out.println("여기7");

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("여기8");

        LocalDateTime now = LocalDateTime.now();
        System.out.println("여기9");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("여기10");
        String formattedDateTime = now.format(formatter);
        ////////////////////////////////////////////forThisUserInquiryList 여기 있지도 않을거임 슈발..
        // .////////////////////////////////////////

        System.out.println("여기11");
        System.out.println("ngrokWrite02Servlet : " + forThisUserInquiryList.get(0).getOrderStatus());
        System.out.println("여기12");

        Inquiry inquiry = Inquiry
                .builder()
                .inquiryType("상품")
                .inquiryTitle("카카오 챗봇 문의")
                .inquiryContent(utterance)
                .fkMemberNo(forThisUserInquiryList.get(0).getFkMemberNo())
                .fkOrderNo(-1)
                .inquiryRenameFilename(formattedDateTime+".txt")
                .inquiryOriginalFilename(formattedDateTime+"re.txt")
                .fkProductNo(forThisUserInquiryList.get(selectedProductNum-1).getFkProductNo())
                .memberName(forThisUserInquiryList.get(selectedProductNum-1).getMemberName())
                .totalPrice(forThisUserInquiryList.get(selectedProductNum-1).getTotalPrice())
                .orderStatus(forThisUserInquiryList.get(selectedProductNum-1).getOrderStatus())
                .productionName(forThisUserInquiryList.get(selectedProductNum-1).getProductionName())
                .productImg(forThisUserInquiryList.get(selectedProductNum-1).getProductImg())
                .refundNo(forThisUserInquiryList.get(selectedProductNum-1).getRefundNo())
                .refundDate(sqlDate)
                .inquiryComments(new ArrayList<>())
                .build();

        int insertResult = new InquiryService().insertInquiry(inquiry);
        System.out.println("여기13");


        String msg = "";

        String insertResultMessage = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s" +
                "\"},\"buttons\":[{\"action\":\"webLink\",\"label\":\"페이지 이동\"," +
                "\"webLinkUrl\":\"http://localhost:8888/semiproject_uglys/inquiry/inquiryList.do\"}]}]}}";

        System.out.println("여기14");
        if (insertResult > 0) {
            msg = "문의가 남겨졌습니다. 문의글 보기를 눌러주세요.";
        } else {
            msg = "문의 등록에 실패 했습니다. 관리자에게 문의해 주세요.";
        }
        System.out.println("여기15");
        String result = String.format(insertResultMessage, msg);
        System.out.println("여기16");
        return result;
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

        doGet(request, response);
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
//                System.out.println("????????"+result.getTotalPrice());
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
