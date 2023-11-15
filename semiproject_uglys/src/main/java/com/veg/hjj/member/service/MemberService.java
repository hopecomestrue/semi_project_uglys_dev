package com.veg.hjj.member.service;

import static com.veg.common.JDBCTemplate.*;


import java.sql.Connection;

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
}	
