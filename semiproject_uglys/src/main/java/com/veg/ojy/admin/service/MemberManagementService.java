package com.veg.ojy.admin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.admin.dao.MemberManagementDao;


import static com.veg.common.JDBCTemplate.*;



public class MemberManagementService {
	private MemberManagementDao dao = new MemberManagementDao();
	
	public List<Member> searchMemberList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<Member> result= dao.searchMemberList(conn, cPage, numPerpage);
		close(conn);
		return result;
		
	}
	public List<Member> selectMemberAll() {
		Connection conn=getConnection();
		List<Member> result= dao.selectMemberAll(conn);
		close(conn);
		return result;
		
	}
	public int selectMemberCount() {
	     Connection conn=getConnection();
	     int count=dao.selectMemberCount(conn);
	     close(conn);
	     return count;
	   }
	
	public List<Member> searchMemberByKeyword(String type, String keyword, int cPage, int numPerpage){
		Connection conn = getConnection();
		List<Member> result= dao.searchMemberByKeyword(conn, type, keyword, cPage, numPerpage);
		close(conn);
		return result;
	}
	public int selectMemberByKeywordCount(String type,String keyword) {
		Connection conn=getConnection();
		int result=dao.selectMemberByKeywordCount(conn, type, keyword);
		close(conn);
	    return result;
	}
	
	public List<Member> searchMember(int cPage, int numPerpage, String key, String keyword){
	      Connection conn = getConnection();
	      List<Member> resultList = null;
	      if(key.equals("memberName")) {
	         resultList = dao.memberSearchByName(conn, cPage, numPerpage, keyword);
	      }else {
	         resultList = dao.memberSearchById(conn, cPage, numPerpage, keyword);
	      }
	      close(conn);
	      return resultList;
	   }
	

}
