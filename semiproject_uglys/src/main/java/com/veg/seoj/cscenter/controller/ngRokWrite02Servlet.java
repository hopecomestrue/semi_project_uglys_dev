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

        Gson gson = new Gson();
        requestExport(request, response);
    }

    private void requestExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(requestBody.toString()).getAsJsonObject();

        JsonObject userRequestNode = json.getAsJsonObject("userRequest");
        String utterance = userRequestNode.getAsJsonPrimitive("utterance").getAsString();

        String jsonResult = generateJson(request,response,utterance);

        response
                .getWriter().write(jsonResult);




    }

    private String generateJson(HttpServletRequest request, HttpServletResponse response,String utterance) {


        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

String jsonTemplate = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s\"}}]}}";

        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(1, 9999999);
        List<Inquiry> forThisUserInquiryList = removeDuplicateInquiries(inquiryListAndComments);

        int selectedProductNum = (int)context.getAttribute("no");



        java.util.Date utilDate = new java.util.Date();

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = now.format(formatter);


        Inquiry inquiry = Inquiry
                .builder()
                .inquiryType("상품")
                .inquiryTitle("카카오 챗봇 문의")
                .inquiryContent(utterance)
                .fkMemberNo(forThisUserInquiryList.get(0).getFkMemberNo())
                .fkOrderNo(forThisUserInquiryList.get(selectedProductNum-1).getFkOrderNo())
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


        String msg = "";

        String insertResultMessage = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"%s" +
                "\"},\"buttons\":[{\"action\":\"webLink\",\"label\":\"페이지 이동\"," +
                "\"webLinkUrl\":\"http://localhost:8888/semiproject_uglys/inquiry/inquiryList.do\"}]}]}}";

        if (insertResult > 0) {
            msg = "문의가 남겨졌습니다. 문의글 보기를 눌러주세요.";
        } else {
            msg = "문의 등록에 실패 했습니다. 관리자에게 문의해 주세요.";
        }
        String result = String.format(insertResultMessage, msg);
        return result;
    }


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



        int previousMemberNo = -2;
        int previousTotalPrice = -2;

        for (Inquiry result : inquiryListandComments) {
            if (result.getFkMemberNo() != previousMemberNo && result.getTotalPrice() != previousTotalPrice) {

                filteredList.add(result);

            }

            previousMemberNo = result.getFkMemberNo();
            previousTotalPrice = result.getTotalPrice();
        }

        return filteredList;
    }
}
