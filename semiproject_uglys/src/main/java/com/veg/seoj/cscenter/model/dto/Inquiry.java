package com.veg.seoj.cscenter.model.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inquiry implements ResultSetMapper<Inquiry> {

    @Builder.Default
    private int inquiryNo = 0;
    @Builder.Default
    private String inquiryType = "";
    @Builder.Default
    private String inquiryTitle = "";
    @Builder.Default
    private String inquiryContent = "";
    @Builder.Default
    private String answerStatus = "";
    @Builder.Default
    private Timestamp inquiryDate = null;
    @Builder.Default
    private int fkMemberNo = 0;
    @Builder.Default
    private int fkOrderNo = 0;
    @Builder.Default
    private String inquiryRenameFilename = "";
    @Builder.Default
    private String inquiryOriginalFilename = "";
    @Builder.Default
    private int fkProductNo = 0;
    @Builder.Default
    private String memberName = "";
    @Builder.Default
    private int totalPrice = 0;
    @Builder.Default
    private String orderStatus = "";
    @Builder.Default
    private String productionName = "";
    @Builder.Default
    private String productImg = "";
    @Builder.Default
    private List<InquiryComment> inquiryComments = new ArrayList<InquiryComment>();
    @Builder.Default
    private int refundNo = 0;
    @Builder.Default
    private Date refundDate = null;



    @Override
    public Inquiry fromResultSet(ResultSet rs, String type) throws SQLException {

        InquiryBuilder builder = null;
        if (type.equals("getById")) {
            builder = Inquiry
                    .builder()
                    .inquiryNo(rs.getInt("inquiry_no"))
                    .inquiryType(rs.getString("inquiry_type"))
                    .inquiryTitle(rs.getString("inquiry_title"))
                    .inquiryContent(rs.getString("inquiry_content"))
                    .answerStatus(rs.getString("answer_status"))
                    .inquiryDate(rs.getTimestamp("inquiry_date"))
                    .fkMemberNo(rs.getInt("member_no"))
                    .fkOrderNo(rs.getInt("order_no"))
                    .inquiryRenameFilename(rs.getString("inquiry_renamed_filename"))
                    .inquiryOriginalFilename(rs.getString("inquiry_original_filename"))
                    .fkProductNo(rs.getInt("product_no"))
                    .memberName(rs.getString("MEMBER_NAME"))
                    .totalPrice(rs.getInt("TOTAL_PRICE"))
                    .orderStatus(rs.getString("ORDER_STATUS"))
                    .productionName(rs.getString("PRODUCTION_NAME"))
                    .productImg(rs.getString("PRODUCT_IMG"))
                    .refundNo(rs.getInt("REFUND_NO"))
                    .refundDate(rs.getDate("REFUND_DATE"))
                    .inquiryComments(new ArrayList<>());

        } else if (type.equals("getTo")) {
            builder = Inquiry
                    .builder()
                    .inquiryNo(rs.getInt("INQUIRY_NO"))
                    .inquiryType(rs.getString("INQUIRY_TYPE"))
                    .inquiryTitle(rs.getString("INQUIRY_TITLE"))
                    .inquiryContent(rs.getString("INQUIRY_CONTENT"))
                    .answerStatus(rs.getString("ANSWER_STATUS"))
                    .inquiryDate(rs.getTimestamp("INQUIRY_DATE"))
                    .fkMemberNo(rs.getInt("MEMBER_NO"))
                    .fkOrderNo(rs.getInt("ORDER_NO"))
                    .inquiryRenameFilename(rs.getString("INQUIRY_RENAMED_FILENAME"))
                    .inquiryOriginalFilename(rs.getString("INQUIRY_ORIGINAL_FILENAME"))
                    .fkProductNo(rs.getInt("PRODUCT_NO"))
                    .memberName(rs.getString("MEMBER_NAME"))
                    .totalPrice(rs.getInt("TOTAL_PRICE"))
                    .orderStatus(rs.getString("ORDER_STATUS"))
                    .productionName(rs.getString("PRODUCTION_NAME"))
                    .productImg(rs.getString("PRODUCT_IMG"))
                    .refundNo(rs.getInt("REFUND_NO"))
                    .refundDate(rs.getDate("REFUND_DATE"))

                    .inquiryComments(new ArrayList<>());
        }
        return builder.build();
    }
}
