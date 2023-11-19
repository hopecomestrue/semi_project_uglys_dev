package com.veg.hjj.member.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.veg.hjj.member.dto.Member;
import static com.veg.common.JDBCTemplate.*;

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
	
	public static Member getMember(ResultSet rs) throws SQLException{
		return Member.builder()
				.memberNo(rs.getInt("member_No"))
				.memberId(rs.getString("member_id"))
				.memberPw(rs.getString("member_pw"))
				.memberName(rs.getString("member_name"))
				.memberAge(rs.getString("member_age"))
				.memberEmail(rs.getString("member_email"))
				.memberPhone(rs.getString("member_phone"))
				.acceptAgree(rs.getString("accept_agree"))
				.adminCheck(rs.getString("admin_check"))
				.serviceAgree(rs.getString("service_agree"))
				.marketingAgree(rs.getString("marketing_agree"))
				.enrollDate(rs.getDate("enroll_date"))
				.photoRegist(rs.getString("photo_Regist"))
				.build();
	}
	
}
