package com.veg.ojy.mypage.dao;

import static com.veg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.veg.hjj.member.dao.MemberDao;
import com.veg.hjj.member.dto.Member;
import com.veg.ojy.mypage.dto.Address;


public class MypageDao {
	
	private Properties sql=new Properties();
	{
		String path = MypageDao.class.getResource("/sql/mypage/mypage_member.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public Member selectMemberByIdAndPw(Connection conn,String memberid, String memberpw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberByIdAndPw"));
			pstmt.setString(1, memberid);
			pstmt.setString(2, memberpw);
			rs=pstmt.executeQuery();
			if(rs.next()) m=getMember(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertMember"));
			pstmt.setInt(1, m.getMemberNo());
			pstmt.setString(2, m.getMemberId());
			pstmt.setString(3, m.getMemberPw());
			pstmt.setString(4, m.getMemberName());
			pstmt.setString(5, m.getMemberAge());
			pstmt.setString(6, m.getMemberEmail());
			pstmt.setString(7, m.getMemberPhone());
			pstmt.setString(8, m.getAcceptAgree());
			pstmt.setString(9, m.getAdminCheck());
			pstmt.setString(10, m.getServiceAgree());
			pstmt.setString(11, m.getMarketingAgree());
			pstmt.setDate(12, m.getEnrollDate());
			pstmt.setString(13, m.getPhotoRegist());
			pstmt.setString(14, m.getMemberQuit());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	public Member selectMemberById(Connection conn, String memberId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberById"));
			pstmt.setString(1,memberId);
			rs=pstmt.executeQuery();
			if(rs.next()) m=getMember(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}
	
	public Member selectMemberById(String memberId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt.setString(1,memberId);
			rs=pstmt.executeQuery();
			if(rs.next()) m=getMember(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}
	
	public int updatePassword(Connection conn, String memberId, String memberpw) {
		PreparedStatement pstmt =null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updatePassword"));
			pstmt.setString(1, memberpw);
			pstmt.setString(2, memberId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	public int deleteMember(Connection conn, String memberId) throws Exception {
		PreparedStatement pstmt=null;
		int row =0;
		Member m=null;
		pstmt=conn.prepareStatement(sql.getProperty("delecteMember"));
		pstmt.setString(1,memberId);
		row=pstmt.executeUpdate();
		return row;
	}
	
	public Member getMember(ResultSet rs) throws SQLException{
		        return Member.builder()
		        		.memberNo(rs.getInt("member_no"))
		                .memberId(rs.getString("member_id"))
		                .memberPw(rs.getString("member_pw"))
		                .memberName(rs.getString("member_name"))
		                .memberAge(rs.getString("member_age"))
		                .memberEmail(rs.getString("member_email"))
		                .memberPhone(rs.getString("member_phone"))
		                .acceptAgree(rs.getString("accpet_agree"))
		                .adminCheck(rs.getString("admin_check"))
		                .serviceAgree(rs.getString("service_agree"))
		                .marketingAgree(rs.getString("marketingAgree"))
		                .enrollDate(rs.getDate("enrollDate"))
		                .photoRegist(rs.getString("photoRegist"))
		                .memberQuit(rs.getString("member_quit"))
		                .build();
		    }
	
//	public List<Address> selectAddress(Connection conn, String address){
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Address> result = new ArrayList<>();
//		try {
//			pstmt=conn.prepareStatement(sql.getProperty("selectAddress"));
//			pstmt.setString(1, address);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				result.add(getAddress(rs));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return result;
//	}
//	
//	public int insertAddress(Connection conn, Address a) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		try {
//			pstmt = conn.prepareStatement(sql.getProperty("insertAddress"));
//			pstmt.setInt(1, a.getAddressNo());
//			pstmt.setInt(2, a.getMemberNo());
//			pstmt.setString(3, a.getAddress());
//			pstmt.setString(4, a.getDefaultAddress());
//			result = pstmt.executeUpdate();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(pstmt);
//			}
//		return result;
//		}
//	
//	public Address getAddress(ResultSet rs) throws SQLException{
//		return Address.builder()
//				.addressNo(rs.getInt("address_no"))
//				.memberNo(rs.getInt("member_no"))
//				.address(rs.getString("address"))
//				.defaultAddress(rs.getString("default_address"))
//				.build();
//	}
//	
//	private void addMemberAndAddress(List<Member> members, ResultSet rs) throws SQLException {
//		String pk = rs.getString("member_no");
//		if (members.stream().anyMatch(e -> pk.equals(e.getMemberNo()))) {
//			members.stream().filter(e -> Objects.equals(e.getMemberNo(), pk)).forEach(e -> {
//				try {
//					if (rs.getString("address_no") != null) {
//						e.getAddress().add(getAddress(rs));
//					}
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			});
//		} else {
//			Member m = getMember(rs);
//			if (rs.getString("address_no") != null)
//				m.getAddress().add(getAddress(rs));
//			members.add(m);
//		}
//	}
		    
	}
