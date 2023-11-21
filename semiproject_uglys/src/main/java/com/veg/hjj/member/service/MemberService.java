package com.veg.hjj.member.service;

import static com.veg.common.JDBCTemplate.*;


import java.sql.Connection;

import com.veg.common.JDBCTemplate;
import com.veg.hjj.member.dao.MemberDao;
import com.veg.hjj.member.dto.Member;
public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	public Member selectMemberByIdAndPw(String memberId,String memberPw) {
		Connection conn=getConnection();
		Member m=dao.selectMemberByIdAndPw(conn,memberId,memberPw);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//아이디 찾기
		public Member searchId(String memberName, String memberEmail) {
			
			Connection conn =getConnection();
			Member m = dao.searchId(conn, memberName, memberEmail);
			close(conn);
			
			System.out.println("member : " + m);
			return m;
		}
		public Member searchPw(String memberName, String memverId, String memberEmail) {
			
			Connection conn =getConnection();
			Member m = dao.searchPw(conn, memberName, memverId, memberEmail);
			close(conn);
			
			System.out.println("member : " + m);
			return m;
		}
	//아이디 중복확인
	public Member selectMemberById(String memberId) {
		Connection conn =getConnection();
		Member m = dao.selectMemberById(conn, memberId);
		close(conn);
		return m;
	}
	
}	
