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

            if(gson.fromJson(request.getReader(), Object.class)==null){
                throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");
                /*            response.sendRedirect(request.getContextPath() + "/views/cscenter/error/badaccess.jsp");*/
            }else{
                String result = generateJson(request,response);
                response.setContentType("application/json");
                try (PrintWriter out = response.getWriter()) {
                    out.println(result);
                }
            }


        } catch (Exception e) {

            throw new BadAccessException("잘못된 접근입니다. 관리자에게 문의하세요!");

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

    public String generateJson(HttpServletRequest request, HttpServletResponse response) {

/*        ServletContext context=getServletContext();*/
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        List<Inquiry> inquiryListAndComments = new InquiryService().selectInquiry(1, 9999999);
        List<Inquiry> forThisUserInquiryList = removeDuplicateInquiries(inquiryListAndComments);


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

        context.setAttribute("forThisUserInquiryList",forThisUserInquiryList);
        session.setAttribute("forThisUserInquiryList",forThisUserInquiryList);

        context.setAttribute("context", "contextData");
        context.setAttribute("forThisUserInquiryList", forThisUserInquiryList);

        for(int i = 0; i < 3; i++){
            if(i == 0){
                if(forThisUserInquiryList.size() < 2){
                    break;
                }

                productionName1=forThisUserInquiryList.get(i).getProductionName();
                context.setAttribute("productionName1",
                                     productionName1);

                context.setAttribute("productionNo1", forThisUserInquiryList.get(i).getFkProductNo());

                totalPrice1=forThisUserInquiryList.get(i).getTotalPrice();
                context.setAttribute("totalPrice1", totalPrice1);

                orderStatus1=forThisUserInquiryList.get(i).getOrderStatus();
                session.setAttribute("orderStatus1", orderStatus1);

            }else if(i == 1){
                if(forThisUserInquiryList.size() < 3){
                    break;
                }
                System.out.println(forThisUserInquiryList.get(i).getProductionName());

                productionName2=forThisUserInquiryList.get(i).getProductionName();
                context.setAttribute("productionName2",
                                     productionName2);


                context.setAttribute("productionNo2", forThisUserInquiryList.get(i).getFkProductNo());


                totalPrice2=forThisUserInquiryList.get(i).getTotalPrice();
                context.setAttribute("totalPrice2", totalPrice2);

                orderStatus2=forThisUserInquiryList.get(i).getOrderStatus();
                context.setAttribute("orderStatus2", orderStatus2);
            }else if(i == 2){
                if(forThisUserInquiryList.size() < 3){
                    break;
                }

                productionName3=forThisUserInquiryList.get(i).getProductionName();
                context.setAttribute("productionName3",
                                     productionName3);
                context.setAttribute("productionNo3", forThisUserInquiryList.get(i).getFkProductNo());


                totalPrice3=forThisUserInquiryList.get(i).getTotalPrice();
                context.setAttribute("totalPrice3", totalPrice3);

                orderStatus3=forThisUserInquiryList.get(i).getOrderStatus();
                context.setAttribute("orderStatus3", orderStatus3);
            }
        }


        String result = "";
        if(forThisUserInquiryList.size()==1){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
                    "\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"http://14.36.141.71:10071/GDJ71_uglysproject_semi/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
             result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1);
            context.setAttribute("no",1);
        }else if(forThisUserInquiryList.size()==2){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
                    "\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"http://14.36.141.71:10071/GDJ71_uglysproject_semi/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
             result = String.format(jsonTemplate, productionName1, orderStatus1, totalPrice1, productionName2,
                                          orderStatus2, totalPrice2);
            context.setAttribute("no",2);
        }else if(forThisUserInquiryList.size()>=3){
            jsonTemplate ="{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\"," +
                    "\"items\":[{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews.com/news/photo/202012/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\",\"webLinkUrl\":\"http://14.36.141.71:10071/GDJ71_uglysproject_semi/kakao2.do\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://kormedi.com/wp-content/uploads/2023/05/unnamed-file-240.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]},{\"title\":\"%s\",\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4BJ9LU4Ikr_EvZLmijfcjzQKMRCJ2bO3A8SVKNuQ78zu2KOqM\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET 주소\"}]}]}}]}}";
            result = String.format(jsonTemplate, productionName1, orderStatus1, productionName2,
                                   orderStatus2, productionName3, orderStatus3);
            context.setAttribute("no",3);
        }



        return result;
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
