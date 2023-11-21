package com.veg.ojy.admin.service;



import java.sql.Connection;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.admin.dao.MemberManagementDao;
import static com.veg.common.JDBCTemplate.*;

public class MemberManagementService {
	private MemberManagementDao dao = new MemberManagementDao();
	
	public List<Member> searchMemberList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		// Connection 생성해서 dao에게 보내는 역할
		List<Member> result= dao.searchMemberList(conn, cPage, numPerpage);
		close(conn);
		//Connection객체 쓰려면!! 닫아야함.
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
	

}
