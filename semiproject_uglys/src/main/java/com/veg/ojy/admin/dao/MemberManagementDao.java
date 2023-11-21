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
	   //sql 가져오기 
	   
	   { // 초기화블록->생성될 때마다 실행됨.
	      String path=MemberManagementDao.class
	            .getResource("/sql/admin/admin_sql.properties").getPath();
	      //파일불러와서 넣어주기!!  절대경로 써주기.
	      try(FileReader fr=new FileReader(path)){
	         sql.load(fr);
	         //load로 불러올 수 있음.
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public List<Member> searchMemberList(Connection conn, int cPage, int numPerpage){
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      //데이터 받아오기 때문에 resultset 필요함.
	      List<Member> result=new ArrayList<>();
	      try {
	         pstmt=conn.prepareStatement(sql.getProperty("selectMemberAll"));
	         //파일로 저장된 sql문을 가져올 수 있음.
	         pstmt.setInt(1,(cPage-1)*numPerpage+1);
	         // 가져오기. 
	         pstmt.setInt(2, cPage*numPerpage);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            result.add(MemberDao.getMember(rs));
	            // 조회되었을 때 1개 이상이 나오기 때문!
	            // 각 테이블에 있는 정보를 한 곳에 만들어서 불러올 수 있도록! 
	         }
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rs);
	         close(pstmt);
	         // static 메소드이므로 임포트 해주기!! 
	      }return result;
	   }
	   // 조회구문 만들 때는 이 트리임...!! 
	   
	   public int selectMemberCount (Connection conn) {
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   //select문 실행 -> 전체 순회 해야하기 때문!!! 
		   int result=0;
		   try {
			   pstmt=conn.prepareStatement(sql.getProperty("selectMemberCount"));
			   rs=pstmt.executeQuery();
			   //where절에 뭐가 읎따..
			   if(rs.next()) result=rs.getInt(1); 
			   // 인덱스번호. 조회한 결과에 첫번째 컬럼 가지고 오겠다!! 컬럼명 안쓰고 인덱스 번호도 가
			   // 가상컬럼, 함수호출하는 경우 인덱스번호가 더 편함.
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
			   pstmt.setString(1, type.equals("gender")?keyword:"%"+keyword+"%");
			   pstmt.setInt(2, (cPage-1)*numPerpage+1);
			   pstmt.setInt(3, cPage*numPerpage);
			   rs=pstmt.executeQuery();
			   
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

}
