package com.veg.seoj.cscenter.model.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.veg.ksj.order.model.dto.Order;
import com.veg.seoj.cscenter.model.dao.GenericDAOImpl;
import com.veg.seoj.cscenter.model.dto.DAOImplOrder;
import com.veg.seoj.cscenter.model.dto.DAOImplRefund;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.InquiryComment;

public class InquiryService {

    public List<Inquiry> selectInquiry(int cPage, int numPerpage) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
        Inquiry Some = (Inquiry)Inquiry
                .builder()
                .build();
        int a = (cPage - 1) * numPerpage + 1;
        int b = cPage * numPerpage;
        List<Inquiry> result = inquiryDAO.getTo(conn, Some, "sql.inquiry.select", "getTo", a, b);

        close(conn);
        return result;
    }

    public int selectInquiryCount() {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
        int result = inquiryDAO.count(conn, (Inquiry)Inquiry
                .builder()
                .build(), "sql.inquiry.selectCount");
        close(conn);
        return result;
    }

    public Inquiry selectInquiryByNo(int inquiryNo) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
        Inquiry n = (Inquiry)inquiryDAO.getById(conn, (Inquiry)Inquiry
                .builder()
                .build(), "sql.inquiry.getByNo", "getById", inquiryNo);
        close(conn);
        return n;
    }


    public int insertInquiry(Inquiry n) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");

        int result = inquiryDAO.addUpdateDelete(conn, n, "sql.inquiry.add", n.getInquiryType(), n.getInquiryTitle(),
                                                n.getInquiryContent(),
                                                (n.getFkMemberNo() == -1) ? -1 : n.getFkMemberNo(),
                                                (n.getFkOrderNo() == -1) ? -1 : n.getFkOrderNo(),
                                                n.getInquiryRenameFilename(), n.getInquiryOriginalFilename(),
                                                (n.getFkProductNo() == -1) ? -1 : n.getFkProductNo());
        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }


    public int insertInquiryComment(InquiryComment n) {
        Connection conn = getConnection();
        GenericDAOImpl<InquiryComment, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY_COMMENT");

        int result = inquiryDAO.addUpdateDelete(conn, n, "sql.inquirycomment.add", n.getInquiryCommentWriter(),
                                                n.getInquiryCommentContent(), n.getFkInquiryNo(), n.getFkMemberNo());
        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }

    public List<InquiryComment> selectInquiryCommentgeyByNo(int no) {
        Connection conn = getConnection();
        GenericDAOImpl<InquiryComment, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY_COMMENT");
        InquiryComment Some = (InquiryComment)InquiryComment
                .builder()
                .build();
        List<InquiryComment> result = inquiryDAO.getTo(conn, Some, "sql.inquirycomment.select", "getTo", no);
        close(conn);
        return result;
    }
    public List<DAOImplOrder> selectOrderByMemberNo(int no) {
        Connection conn = getConnection();
        GenericDAOImpl<DAOImplOrder, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "SHOP_ORDER");
        DAOImplOrder Some = (DAOImplOrder)DAOImplOrder
                .builder()
                .build();
        List<DAOImplOrder> result = inquiryDAO.getTo(conn, Some, "sql.order.select", "getTo", no);
        close(conn);
        return result;
    }
    public List<DAOImplRefund> selectRefundByMemberNo(int no) {
        Connection conn = getConnection();
        GenericDAOImpl<DAOImplRefund, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "REFUND");
        DAOImplRefund Some = (DAOImplRefund)DAOImplRefund
                .builder()
                .build();
        List<DAOImplRefund> result = inquiryDAO.getTo(conn, Some, "sql.refund.select", "getTo", no);
        System.out.println("refund result: "+result);
        close(conn);
        return result;
    }


    public String generateJson(String productionName,
                               String orderStatus,
                               String productionName2,
                               String orderStatus2,
                               String productionName3,
                               String orderStatus3) {

        String jsonTemplate = "'{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard" +
                "\"," + "\"items\":[{\"title\":\"%s\",\"description\":\"%s\"," + "\"thumbnail\":{\"imageUrl\":\"https://www.ibabynews" + ".com/news/photo/202012" + "/90908_40356_4011.jpg\"},\"buttons\":[{\"action\":\"message\"," + "\"label\":\"이 주문 " + "선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"}," + "{\"action\":\"webLink\"," + "\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 " + "SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://pds" + ".joongang.co.kr/svcimg/newsletter/content/202206/29/d5508b55-8e0a-43f4-a677-392ca1be8728" + ".jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\"," + "\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\"," + "\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]},{\"title\":\"%s\"," + "\"description\":\"%s\",\"thumbnail\":{\"imageUrl\":\"https://www.costco.co.kr/medias/sys_master/images/hab/he3/103890527649822.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"이 주문 선택\",\"messageText\":\"해당 주문에 대한 문의를 작성해 주세요.\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"해당 문의로 가는 SERVLET주소\"}]}]}}]}}'";


        String result = String.format(jsonTemplate, productionName, orderStatus, productionName2, orderStatus2,
                                      productionName3, orderStatus3);

        return result;
    }

/*    public List<Map<String, Object>> getProductList() {
        Connection conn = getConnection();
        GenericDAOImpl<Order, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "SHOP_ORDER");
        Order Some = (Order)Order
                .builder()
                .build();
        List<Order> result = inquiryDAO.getTo(conn, Some, "sql.order.select", "getTo");
        close(conn);
        return result;
    }*/
}
