package com.veg.seoj.cscenter.model.dto;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notice implements ResultSetMapper<Notice> {
    @Builder.Default
    private int noticeNo = 0;
    @Builder.Default
    private String noticeType = "";
    @Builder.Default
    private String noticeTitle = "";
    @Builder.Default
    private Timestamp noticeDate = null;
    @Builder.Default
    private String noticeState = "";
    @Builder.Default
    private String noticeSMSContent = "";
    @Builder.Default
    private String noticeSMSResult = "";
    @Builder.Default
    private int noticePriority = 0;
    @Builder.Default
    private String noticeView = "";
    @Builder.Default
    private String noticeRenameFilename = "";
    @Builder.Default
    private String noticeOriginalFilename = "";


    public Notice fromResultSet(ResultSet rs) throws SQLException {
        return Notice
                .builder()
                .noticeNo(rs.getInt("notice_no"))
                .noticeType(rs.getString("notice_type"))
                .noticeTitle(rs.getString("notice_title"))
                .noticeDate(rs.getTimestamp("notice_date"))
                .noticeState(rs.getString("notice_state"))
                .noticeSMSContent(rs.getString("notice_sms_content"))
                .noticeSMSResult(rs.getString("notice_sms_result"))
                .noticePriority(rs.getInt("notice_priority"))
                .noticeView(rs.getString("notice_view"))
                .noticeRenameFilename(rs.getString("notice_rename_filename"))
                .noticeOriginalFilename(rs.getString("notice_original_filename"))
                .build();
    }
}
