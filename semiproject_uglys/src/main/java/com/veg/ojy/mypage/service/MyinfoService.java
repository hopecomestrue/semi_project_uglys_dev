package com.veg.ojy.mypage.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.mypage.dao.MypageDao;
import com.veg.ojy.mypage.dto.Address;
import com.veg.common.*;

public class MyinfoService {
	
	private MypageDao dao=new MypageDao();
	
	public Member selectMemberByIdAndPw(String memberId, String memberPw) {
	    Connection conn = getConnection();
	    Member m = dao.selectMemberByIdAndPw(conn, memberId, memberPw);
	    close(conn);
	    return m;
	}
	
//	public int insertMember(Member m) {
//		Connection conn = getConnection();
//		int result=dao.insertMember(conn,m);
//		if(result>0) commit(conn);
//		else rollback(conn);
//		close(conn);
//		return result;
//	}
//
//	public Member selectMemberById(String memberId) {
//		Connection conn=getConnection();
//		Member m =dao.selectMemberById(conn, memberId);
//		close(conn);
//		return m;
//	}
//	
	public List<Address> selectAddress(int memberNo) {
		Connection conn=getConnection();
		List<Address> a =dao.selectAddress(conn, memberNo);
		close(conn);
		return a;
	}
	
	public int updatePassword(String memberId, String memberPw) {
		Connection conn = getConnection();
		int result=dao.updatePassword(conn,memberId,memberPw);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = dao.deleteMember(conn,memberId);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public String insertAddress(int memberNo, String address) {
	    Connection conn = getConnection();
	    int result = dao.insertAddress(conn, address);
	    if (result > 0) {
	        commit(conn);
	    } else {
	        rollback(conn);
	    }
	    close(conn);
	    return result > 0 ? "Success" : "Failure";
	}

	public int updateAddress(String memberId, String Address) {
		Connection conn = getConnection();
		int result=dao.updateAddress(conn,memberId,Address);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
