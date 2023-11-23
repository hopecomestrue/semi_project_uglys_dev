package com.veg.ojy.admin.dao;

import static com.veg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.veg.hjj.member.dao.MemberDao;
import com.veg.hjj.member.dto.Member;

public class MemberManagementDao {
	 private Properties sql=new Properties();
	   
	   { 
	      String path=MemberManagementDao.class
	            .getResource("/sql/admin/admin_sql.properties").getPath();
	      try(FileReader fr=new FileReader(path)){
	         sql.load(fr);

	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	   }
	   
		public List<Member> selectMemberAll(Connection conn) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Member> result = new ArrayList<>();
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectMemberAll"));
				rs = pstmt.executeQuery();
				while (rs.next()) {
					result.add(getMember(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}
		
	   
	   public List<Member> searchMemberList(Connection conn, int cPage, int numPerpage){
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      List<Member> result=new ArrayList<>();
	      try {
	         pstmt=conn.prepareStatement(sql.getProperty("selectMemberAll"));
	         pstmt.setInt(1,(cPage-1)*numPerpage+1);
	         pstmt.setInt(2, cPage*numPerpage);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            result.add(MemberDao.getMember(rs));
	         }
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rs);
	         close(pstmt); 
	      }return result;
	   }

	   public int selectMemberCount (Connection conn) {
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   int result=0;
		   try {
			   pstmt=conn.prepareStatement(sql.getProperty("selectMemberCount"));
			   rs=pstmt.executeQuery();
			   if(rs.next()) result=rs.getInt(1); 
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }finally {
		         close(rs);
		         close(pstmt);
		      }return result;
		   }
	   
	   public List<Member> searchMemberByKeyword(Connection conn, String type, String keyword, int cPage, int numPerpage){
		   PreparedStatement pstmt=null;
		   ResultSet rs= null;
		   List<Member> result = new ArrayList<>();
		   String query= sql.getProperty("searchMemberByKeyword");
		   query=query.replace("#COL",type);
		   try {
			   pstmt=conn.prepareStatement(query);
			   pstmt.setString(1, "%"+keyword+"%");
			   pstmt.setInt(2, (cPage-1)*numPerpage+1);
			   pstmt.setInt(3, cPage*numPerpage);
			   rs=pstmt.executeQuery();
			   while(rs.next())result.add(MemberDao.getMember(rs));
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }finally {
			   close(rs);
			   close(pstmt);
		   }return result;
	   }
	   public int selectMemberByKeywordCount(Connection conn, String type, String keyword) {
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   int result =0;
		   String query=sql.getProperty("selectMemberByKeywordCount").replace("#COL", type);
		   try {
			   pstmt=conn.prepareStatement(query);
			   pstmt.setString(1, "%"+keyword+"%");
			   rs=pstmt.executeQuery();
			   if(rs.next()) result = rs.getInt("count");
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }finally {
			   close(rs);
			   close(pstmt);
		   }return result;
	   }
	   
	   
	   public List<Member> memberSearchByName(Connection conn, int cPage, int numPerpage, String keyword){
	          PreparedStatement pstmt = null;
	           ResultSet rs = null;
	           List<Member> result = new ArrayList<>();
	           try {
	               pstmt = conn.prepareCall(sql.getProperty("memberSearchByName"));
	               pstmt.setString(1, keyword);
	               pstmt.setInt(2, (cPage - 1) * numPerpage + 1);
	               pstmt.setInt(3, cPage * numPerpage);
	               rs = pstmt.executeQuery();
	               while (rs.next()) {
	                   result.add(getMember(rs));
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           } finally {
	               close(rs);
	               close(pstmt);
	           }
	           return result;
	       }
	       
	       public List<Member> memberSearchById(Connection conn, int cPage, int numPerpage, String keyword){
	          PreparedStatement pstmt = null;
	           ResultSet rs = null;
	           List<Member> result = new ArrayList<>();

	           try {
	               pstmt = conn.prepareCall(sql.getProperty("memberSearchById"));
	               pstmt.setString(1, keyword);
	               pstmt.setInt(2, (cPage - 1) * numPerpage + 1);
	               pstmt.setInt(3, cPage * numPerpage);
	               rs = pstmt.executeQuery();
	               while (rs.next()) {
	                   result.add(getMember(rs));
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           } finally {
	               close(rs);
	               close(pstmt);
	           }
	           return result;
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
