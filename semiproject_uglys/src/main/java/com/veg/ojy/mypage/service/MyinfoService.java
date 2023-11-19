package com.veg.ojy.mypage.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ojy.mypage.dao.MypageDao;
import com.veg.ojy.mypage.dto.Address;
import com.veg.common.*;

public class MyinfoService {
	
	private MypageDao dao=new MypageDao();
	
	public Member selectMemberByIdAndPw(String memberId,String memberPw) {
		Connection conn=getConnection();
		Member m=dao.selectMemberByIdAndPw(conn,memberId,memberPw);
		close(conn);
		return m;
	}
	
//	public int insertMember(Member m) {
//		Connection conn = getConnection();
//		int result=dao.insertMember(conn,m);
//		if(result>0) {
//			if(m.getAddress().size()>0) {
//				m.getAddress().forEach(e->{
//					e.setMemberNo(m.getMemberNo());
//					int aResult=dao.insertAddress(conn,e);
//					if(aResult==0) {
//						throw new RuntimeException("입력실패");
//					}
//				});
//				commit(conn);
//			}
//		} else {
//			rollback(conn);
//			throw new RuntimeException("입력실패");
//		}
//		close(conn);
//		return result;
//	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public Member selectMemberById(String memberId) {
		Connection conn=getConnection();
		Member m =dao.selectMemberById(conn, memberId);
		close(conn);
		return m;
	}
	
//	public List<Address> selectAddress(String address) {
//		Connection conn=getConnection();
//		List<Address> a =dao.selectAddress(conn, address);
//		close(conn);
//		return a;
//	}
	
	public int updatePassword(String memberId, String memberPw) {
		Connection conn = getConnection();
		int result=dao.updatePassword(conn,memberId,memberPw);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	

}
