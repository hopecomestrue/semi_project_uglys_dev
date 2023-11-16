package com.veg.seoj.cscenter.model.dto;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryComment implements ResultSetMapper<InquiryComment> {
    @Builder.Default
    private int inquiryCommentNo = 0;

    ///////////////////작성자 두번 들어감 ㅜㅜ////////////////////
    @Builder.Default
    private String inquiryCommentWriter = "";

    @Builder.Default
    private String inquiryCommentContent = "";
    @Builder.Default
    private Timestamp inquiryCommentDate = null;
    @Builder.Default
    private int fkInquiryNo = 0;

    ///////////////////작성자 두번 들어감 ㅜㅜ////////////////////
    @Builder.Default
    private int fkMemberNo = 0;


    public InquiryComment fromResultSet(ResultSet rs) throws SQLException {
        return InquiryComment
                .builder()
                .inquiryCommentNo(rs.getInt("INQUIRY_COMMENT_NO"))
                .inquiryCommentWriter(rs.getString("INQUIRY_COMMENT_WRITER"))
                .inquiryCommentContent(rs.getString("INQUIRY_COMMENT_CONTENT"))
                .inquiryCommentDate(rs.getTimestamp("INQUIRY_COMMENT_DATE"))
                .fkInquiryNo(rs.getInt("INQUIRY_NO"))
                .fkMemberNo(rs.getInt("MEMBER_NO"))
                .build();

    }
}
