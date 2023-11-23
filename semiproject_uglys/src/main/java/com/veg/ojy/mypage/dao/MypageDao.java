package com.veg.ojy.mypage.dao;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;

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
		
	public Member selectMemberByIdAndPw(Connection conn, String memberId, String memberPw) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Member m = null;

	    try {
	        pstmt = conn.prepareStatement(sql.getProperty("selectMemberByIdAndPw"));
	        pstmt.setString(1, memberId);
	        pstmt.setString(2, memberPw);

	        rs = pstmt.executeQuery();
	        if (rs.next()) m = getMember(rs);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    return m;
	}
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertMember"));
			 pstmt.setString(1, m.getMemberId());
	         pstmt.setString(2, m.getMemberPw());
	         pstmt.setString(3, m.getMemberName());
	         pstmt.setString(4, m.getMemberAge());
	         pstmt.setString(5, m.getMemberEmail());
	         pstmt.setInt(6, m.getMemberPhone());
	         pstmt.setString(7, m.getAcceptAgree());
	         pstmt.setString(8, m.getAdminCheck());
	         pstmt.setString(9, m.getServiceAgree());
	         pstmt.setString(10, m.getMarketingAgree());
	         pstmt.setDate(11, m.getEnrollDate());
	         pstmt.setString(12, m.getPhotoRegist());
	         pstmt.setString(13, m.getMemberQuit());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	public Member selectMemberById(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberById"));
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

	
	public Member selectMemberById(Connection conn,String memberId) {
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
	
	
	public int updatePassword(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updatePassword"));
			pstmt.setString(1, memberPw);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt= null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteMember"));
			pstmt.setString(1, memberId);
			result=pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	}

	
	public Member getMember(ResultSet rs) throws SQLException{
		        return Member.builder()
		        		.memberNo(rs.getInt("member_no"))
		                .memberId(rs.getString("member_id"))
		                .memberPw(rs.getString("member_pw"))
		                .memberName(rs.getString("member_name"))
		                .memberAge(rs.getString("member_age"))
		                .memberEmail(rs.getString("member_email"))
		                .memberPhone(rs.getInt("member_phone"))
		                .acceptAgree(rs.getString("accept_agree"))
		                .acceptAgree(rs.getString("accept_agree"))
		                .adminCheck(rs.getString("admin_check"))
		                .serviceAgree(rs.getString("service_agree"))
		                .marketingAgree(rs.getString("marketing_Agree"))
		                .enrollDate(rs.getDate("enroll_Date"))
		                .photoRegist(rs.getString("photo_Regist"))
		                .memberQuit(rs.getString("member_quit"))
		                .build();
		    }
	
	public List<Address> selectAddress(Connection conn, int memberNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Address> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAddress"));
			pstmt.setInt(1, memberNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getAddress(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int insertAddress(Connection conn, Address a) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertAddress"));
			pstmt.setInt(1, a.getAddressNo());
			pstmt.setInt(2, a.getMemberNo());
			pstmt.setString(3, a.getAddress());
			pstmt.setString(4, a.getDefaultAddress());
			result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		return result > 0 ? result : -1; 
		}
	
	public Address getAddress(ResultSet rs) throws SQLException{
		return Address.builder()
				.addressNo(rs.getInt("address_no"))
				.memberNo(rs.getInt("member_no"))
				.address(rs.getString("address"))
				.defaultAddress(rs.getString("default_address"))
				.build();
	}
	
	
	public int updateAddress(Connection conn, String memberId, String Address) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateAddress"));
			pstmt.setString(1, memberId);
			pstmt.setString(2, Address);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
//	   public int updateAddress(Connection conn, int memberNo, String newAddress) {
//	        PreparedStatement pstmt = null;
//	        int result = 0;
//	        try {
//	            // "updateAddress"에 해당하는 SQL 쿼리를 가져옴
//	            pstmt = conn.prepareStatement(sql.getProperty("updateAddress"));
//
//	            // SQL 쿼리에 파라미터 값 설정
//	            pstmt.setString(1, newAddress);
//	            pstmt.setInt(2, memberNo);
//
//	            // 쿼리 실행
//	            result = pstmt.executeUpdate();
//
//	        } catch (SQLException e) {
//	            e.printStackTrace(); // 실제 프로덕션 코드에서는 로깅 또는 예외 처리가 필요
//	        } finally {
//	            close(pstmt);
//	        }
//
//	        // 업데이트 결과를 반환
//	        return result;
//	    }
	
//	public int insertAddress(Connection conn, int memberNo, String newAddress) {
//	PreparedStatement pstmt = null;
//    int result = 0;
//	try {
//        pstmt = conn.prepareStatement(sql.getProperty("selectAddress"));
//        pstmt.setInt(1, memberNo);
//        ResultSet rs = pstmt.executeQuery();
//        if (rs.next()) {
//            // 이미 주소가 존재하는 경우, 에러 처리 또는 이미 등록되어 있다는 메시지를 반환할 수 있음
//            result = -1; // 예시로 -1을 사용하며, 상황에 맞게 수정 가능
//        } else {
//            // 주소가 존재하지 않는 경우, 새 주소 등록
//            pstmt = conn.prepareStatement(sql.getProperty("insertAddress"));
//            pstmt.setInt(1, memberNo);
//            pstmt.setString(2, newAddress);
//            result = pstmt.executeUpdate();
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        close(pstmt);
//    }
//    
//    return result;
//}
	
		    
}
