package com.veg.hjj.member.dao;

import static com.veg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.veg.common.JDBCTemplate;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dto.Order;

public class MemberDao {
	
	private Properties sql=new Properties();
	{
		String path=MemberDao.class.getResource("/member/login/login.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public Member selectMemberByIdAndPw(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberByIdAndPw"));
			pstmt.setString(1,memberId);
			pstmt.setString(2, memberPw);
			rs=pstmt.executeQuery();
			if(rs.next()) m=getMember(rs);
		
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
				close(rs);
				close(pstmt);
		}return m;
	}
	

	public int insertMember(Connection conn,Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertMember"));
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAge());
			pstmt.setString(5, m.getMemberEmail());
			pstmt.setInt(6, m.getMemberPhone());
			pstmt.setString(7, m.getAcceptAgree());
			pstmt.setString(8, m.getServiceAgree());
			pstmt.setString(9, m.getMarketingAgree());
			pstmt.setString(10, m.getPhotoRegist());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public Member searchId(Connection conn, String memberName, String memberEmail) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Member m = null; 
	    try {
	        pstmt = conn.prepareStatement(sql.getProperty("searchId"));
	        pstmt.setString(1, memberName); 
	        pstmt.setString(2, memberEmail); 
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) m=getMember(rs);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCTemplate.close(pstmt);
	        JDBCTemplate.close(rs);
	    }
	    return m;
	}
	public Member searchPw(Connection conn, String memberName, String memberId, String memberEmail) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Member m = null; 
	    try {
	        pstmt = conn.prepareStatement(sql.getProperty("searchPw"));
	        pstmt.setString(1, memberName); 
	        pstmt.setString(2, memberId); 
	        pstmt.setString(3, memberEmail); 
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) m=getMember(rs);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCTemplate.close(pstmt);
	        JDBCTemplate.close(rs);
	    }
	    return m;
	}
	public Member selectMemberById(Connection conn, String memberId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberById"));
			pstmt.setString(1,memberId);
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				m=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}

	
	public static Member getMember(ResultSet rs) throws SQLException{
		return Member.builder()
				.memberNo(rs.getInt("MEMBER_NO"))
				.memberId(rs.getString("MEMBER_ID"))
				.memberPw(rs.getString("MEMBER_PW"))
				.memberName(rs.getString("MEMBER_NAME"))
				.memberAge(rs.getString("MEMBER_AGE"))
				.memberEmail(rs.getString("MEMBER_EMAIL"))
				.memberPhone(rs.getInt("MEMBER_PHONE"))
				.acceptAgree(rs.getString("ACCEPT_AGREE"))
				.adminCheck(rs.getString("ADMIN_CHECK"))
				.serviceAgree(rs.getString("SERVICE_AGREE"))
				.marketingAgree(rs.getString("MARKETING_AGREE"))
				.enrollDate(rs.getDate("ENROLL_DATE"))
				.photoRegist(rs.getString("PHOTO_REGIST"))
				.address(new ArrayList<>())
				.memberQuit(rs.getString("MEMBER_QUIT"))
				.build();
		
	}
}
