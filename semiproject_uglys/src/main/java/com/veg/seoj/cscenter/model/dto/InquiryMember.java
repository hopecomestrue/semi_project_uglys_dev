package com.veg.seoj.cscenter.model.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryMember implements ResultSetMapper<InquiryMember> {

    @Builder.Default
    private int memberNo = 0;
    @Builder.Default
    private String memberId = "";
    @Builder.Default
    private String memberPw = "";
    @Builder.Default
    private String memberName = "";
    @Builder.Default
    private String memberAge = "";
    @Builder.Default
    private String memberEmail = null;
    @Builder.Default
    private String memberPhone = "";
    @Builder.Default
    private String acceptAgree = "";
    @Builder.Default
    private String adminCheck = "";
    @Builder.Default
    private String serviceAgree = "";
    @Builder.Default
    private int marketingAgree = 0;
    @Builder.Default
    private Date enrollDate = null;
    @Builder.Default
    private String photoRegist = "";
    @Builder.Default
    private String MemberQuit = "";
    @Builder.Default
    List<Inquiry> inquiryList = new ArrayList<>();
    @Builder.Default
    List<InquiryComment> inquiryCommentList = new ArrayList<>();

    /////// 안쓰는거 /////////
    @Override
    public InquiryMember fromResultSet(ResultSet rs, String type) throws SQLException {

        InquiryMember.InquiryMemberBuilder builder = null;
        if (type.equals("getById_List")) {
            builder = InquiryMember
                    .builder()
                    .memberNo(rs.getInt("MEMBER_NO"))
                    .memberId(rs.getString("MEMBER_ID"))
                    .memberPw(rs.getString("MEMBER_PW"))
                    .memberName(rs.getString("MEMBER_NAME"))
                    .memberAge(rs.getString("MEMBER_AGE"))
                    .memberEmail(rs.getString("MEMBER_EMAIL"))
                    .memberPhone(rs.getString("MEMBER_PHONE"))
                    .acceptAgree(rs.getString("ACCEPT_AGREE"))
                    .adminCheck(rs.getString("ADMIN_CHECK"))
                    .serviceAgree(rs.getString("SERVICE_AGREE"))
                    .marketingAgree(rs.getInt("MARKETING_AGREE"))
                    .enrollDate(rs.getDate("ENROLL_DATE"))
                    .photoRegist(rs.getString("PHOTO_REGIST"))
                    .MemberQuit(rs.getString("MEMBER_QUIT"));
            while (rs.next()) {
                Inquiry inquiry = Inquiry
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
                        .build();

                inquiryList.add(inquiry);
            }
            builder.inquiryList(inquiryList);

        } else if (type.equals("getById_View")) {
            builder = InquiryMember
                    .builder()
                    .memberNo(rs.getInt("MEMBER_NO"))
                    .memberId(rs.getString("MEMBER_ID"))
                    .memberPw(rs.getString("MEMBER_PW"))
                    .memberName(rs.getString("MEMBER_NAME"))
                    .memberAge(rs.getString("MEMBER_AGE"))
                    .memberEmail(rs.getString("MEMBER_EMAIL"))
                    .memberPhone(rs.getString("MEMBER_PHONE"))
                    .acceptAgree(rs.getString("ACCEPT_AGREE"))
                    .adminCheck(rs.getString("ADMIN_CHECK"))
                    .serviceAgree(rs.getString("SERVICE_AGREE"))
                    .marketingAgree(rs.getInt("MARKETING_AGREE"))
                    .enrollDate(rs.getDate("ENROLL_DATE"))
                    .photoRegist(rs.getString("PHOTO_REGIST"))
                    .MemberQuit(rs.getString("MEMBER_QUIT"));
            while (rs.next()) {
                Inquiry inquiry = Inquiry
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
                        .build();

                inquiryList.add(inquiry);
                InquiryComment inquiryComment = InquiryComment
                        .builder()
                        .inquiryCommentNo(rs.getInt("INQUIRY_COMMENT_NO"))
                        .inquiryCommentWriter(rs.getString("INQUIRY_COMMENT_WRITER"))
                        .inquiryCommentContent(rs.getString("INQUIRY_COMMENT_CONTENT"))
                        .inquiryCommentDate(rs.getTimestamp("INQUIRY_COMMENT_DATE"))
                        .fkInquiryNo(rs.getInt("INQUIRY_NO"))
                        .fkMemberNo(rs.getInt("MEMBER_NO"))
                        .build();
                inquiryCommentList.add(inquiryComment);
            }
            builder.inquiryList(inquiryList);
            builder.inquiryCommentList(inquiryCommentList);
        } else if (type.equals("getTo")) {
            builder = InquiryMember
                    .builder()
                    .memberNo(rs.getInt("MEMBER_NO"))
                    .memberId(rs.getString("MEMBER_ID"))
                    .memberPw(rs.getString("MEMBER_PW"))
                    .memberName(rs.getString("MEMBER_NAME"))
                    .memberAge(rs.getString("MEMBER_AGE"))
                    .memberEmail(rs.getString("MEMBER_EMAIL"))
                    .memberPhone(rs.getString("MEMBER_PHONE"))
                    .acceptAgree(rs.getString("ACCEPT_AGREE"))
                    .adminCheck(rs.getString("ADMIN_CHECK"))
                    .serviceAgree(rs.getString("SERVICE_AGREE"))
                    .marketingAgree(rs.getInt("MARKETING_AGREE"))
                    .enrollDate(rs.getDate("ENROLL_DATE"))
                    .photoRegist(rs.getString("PHOTO_REGIST"))
                    .MemberQuit(rs.getString("MEMBER_QUIT"))
                    // 빈 리스트
                    .inquiryList(new ArrayList<>())
                    .inquiryCommentList(new ArrayList<>());
        }
        return builder.build();
    }
}
