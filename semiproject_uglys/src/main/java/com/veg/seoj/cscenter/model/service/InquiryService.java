package com.veg.seoj.cscenter.model.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.veg.seoj.cscenter.model.dao.GenericDAOImpl;
import com.veg.seoj.cscenter.model.dto.Inquiry;
import com.veg.seoj.cscenter.model.dto.Inquiry;

public class InquiryService {
    /*private InquiryDao dao=new InquiryDao();*/

    public List<Inquiry> selectInquiry(int cPage, int numPerpage) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
        Inquiry Some = (Inquiry)Inquiry
                .builder()
                .build();
        int a = (cPage - 1) * numPerpage + 1;
        int b = cPage * numPerpage;
        List<Inquiry> result = inquiryDAO.getTo(conn, Some, "sql.inquiry.select", a, b);

        close(conn);
        return result;
    }

    public int selectInquiryCount() {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
//		int result=InquiryDAO.selectInquiryCount(conn);
        int result = inquiryDAO.count(conn, (Inquiry)Inquiry
                .builder()
                .build(), "sql.inquiry.selectCount");
        close(conn);
        return result;
    }

    public Inquiry selectInquiryByNo(int InquiryNo) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
//		Inquiry n=dao.selectInquiryByNo(conn, InquiryNo);
        Inquiry n = inquiryDAO.getById(conn, (Inquiry)Inquiry
                .builder()
                .build(), "sql.Inquiry.getByNo", InquiryNo);
        close(conn);
        return n;
    }

    public int insertInquiry(Inquiry n) {
        Connection conn = getConnection();
        GenericDAOImpl<Inquiry, Integer> inquiryDAO = new GenericDAOImpl<>(conn, "INQUIRY");
        /*		int result=dao.insertInquiry(conn, n);*/
        int result = inquiryDAO.addUpdateDelete(conn, n, "sql.inquiry.add", n.getInquiryType(), n.getInquiryTitle(),
                                                n.getInquiryContent(), n.getFkMemberNo(), n.getFkOrderNo(),
                                                n.getInquiryRenameFilename(), n.getInquiryOriginalFilename(),
                                                n.getFkProductNo());
        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
}
