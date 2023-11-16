package com.veg.seoj.notice.model.dao;

import static com.veg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.veg.seoj.notice.model.dto.Notice;
public class NoticeDao {
	private Properties sql=new Properties();
	{
		String path=NoticeDao.class
				.getResource("/sql/notice/notice_sql.properties").getPath();
		try(FileReader fr=new FileReader(path)) {
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Notice> selectNotice(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Notice> result=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectNotice"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getNotice(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertNotice"));
			pstmt.setString(1,n.getNoticeTitle());
/*			pstmt.setString(2,n.getNoticeWriter());
			pstmt.setString(3,n.getNoticeContent());
			pstmt.setString(4,n.getFilePath());*/
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	public Notice selectNoticeByNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Notice n=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectNoticeByNo"));
			pstmt.setInt(1, noticeNo);
			rs=pstmt.executeQuery();
			if(rs.next())n=getNotice(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return n;
	}

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectNoticeCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

/*	#private int noticeNo;
	#private String noticeType;
	#private String noticeTitle;
	#private Date noticeDate;
	#private String noticeState;
	#private String noticeSMSContent;
	#private String noticeSMSResult;
	#private int noticePriority;
	#private String noticeView;
	#private String noticeRenameFilename;
	#private String noticeOriginalFilename;*/


	private Notice getNotice(ResultSet rs) throws SQLException{
		return Notice.builder()
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
