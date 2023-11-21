package com.veg.ksj.order.model.dao;

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
import com.veg.ksj.order.model.dto.Order;
import static com.veg.common.JDBCTemplate.*;

public class OrderDao {

	private Properties sql=new Properties();
	
	{
		String path=OrderDao.class.getResource("/sql/order/order_sql.properties").getPath();
		try(FileReader fr=new FileReader(path)){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//주문 고유번호로 해당 주문row 가져오기
	public Order selectOrderDetailsByOrderNo(Connection conn,long orderNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order o=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectOrderDetailsByOrderNo"));
			pstmt.setLong(1, orderNo);
			rs=pstmt.executeQuery();
			if(rs.next()) o=getOrder(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return o;
	}
	//주문 테이블에 등록(주문/결제 등록)
	public int insertOrderDetails(Connection conn,Order o,Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertOrderDetails"));
			pstmt.setLong(1, o.getOrderNo());
			pstmt.setInt(2, m.getMemberNo());
			pstmt.setString(3, o.getOrderName());
			pstmt.setString(4, o.getOrderPhone());
			pstmt.setString(5, o.getOrderAddress());
			pstmt.setString(6, o.getOrderComment());
			pstmt.setInt(7, o.getOrderCount());
			pstmt.setInt(8, o.getTotalPrice());
			pstmt.setInt(9, o.getDeliveryPay());
			pstmt.setString(10, o.getPayment());
			pstmt.setString(11, o.getOrderStatus());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	//주문현황 모든 row 가져오기
	public List<Order> selectAllOrderDetails(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Order> orders=new ArrayList<Order>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllOrderDetails"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				orders.add(getOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orders;
	}
	//송장번호 입력+주문상태 변경(결제완료->배송준비중,배송중,배송완료) -관리자
	public int updateOrderDetails(Connection conn,String status,long trackingNo,long orderNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateOrderDetails"));
			pstmt.setString(1, status);
			pstmt.setLong(2, trackingNo);
			pstmt.setLong(3, orderNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	//주문현황 페이지 페이징처리
	//1.주문 리스트 전부 가져오기
	public List<Order> searchDelList(Connection conn,int cPage,int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Order> result=new ArrayList<Order>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchDelList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//주문리스트에서 키워드로 찾기
	public List<Order> searchDelByKeyword(Connection conn,String type,String keyword,int cPage,int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Order> result=new ArrayList<Order>();
		String query=sql.getProperty("searchDelByKeyword");
		query=query.replace("#COL", type);
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) result.add(getOrder(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//주문 키워드 수
	public int selectDelByKeywordCount(Connection conn,String type,String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String query=sql.getProperty("selectDelByKeywordCount").replace("#COL", type);
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
				
	}
	//모든 주문 리스트 총량 가져오기
	public int selectDelCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectDelCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	public static Order getOrder(ResultSet rs) throws SQLException{
		return Order.builder()
					.orderNo(rs.getLong("ORDER_NO"))
					.memberNo(rs.getInt("MEMBER_NO"))
					.orderName(rs.getString("ORDER_NAME"))
					.orderPhone(rs.getString("ORDER_PHONE"))
					.orderAddress(rs.getString("ORDER_ADDRESS"))
					.orderComment(rs.getString("ORDER_COMMENT"))
					.orderCount(rs.getInt("ORDER_COUNT"))
					.totalPrice(rs.getInt("TOTAL_PRICE"))
					.deliveryPay(rs.getInt("DELIVERY_PAY"))
					.payment(rs.getString("PAYMENT"))
					.orderStatus(rs.getString("ORDER_STATUS"))
					.trackingNumber(rs.getLong("TRAKING_NUMBER"))
					.orderDate(rs.getDate("ORDER_DATE"))
					.build();
	}
	
	
	
	
	
	
	
	private Properties sql2=new Properties();
	{
		String path=MemberDao.class.getResource("/sql/order/order_sql.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql2.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Member selectMemberByNo(Connection conn, int memberNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql2.getProperty("selectMemberByNo"));
			pstmt.setInt(1,memberNo);
			rs=pstmt.executeQuery();
			if(rs.next()) m=getMember(rs);
		
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
				close(rs);
				close(pstmt);
		}return m;
	}
	
	private static Member getMember(ResultSet rs) throws SQLException{
		return Member.builder()
				.memberNo(rs.getInt("member_No"))
				.memberId(rs.getString("member_id"))
				.memberPw(rs.getString("member_pw"))
				.memberName(rs.getString("member_name"))
				.memberAge(rs.getString("member_age"))
				.memberEmail(rs.getString("member_email"))
				.memberPhone(rs.getString("member_phone"))
				.acceptAgree(rs.getString("accept_agree"))
				.adminCheck(rs.getString("admin_check"))
				.serviceAgree(rs.getString("service_agree"))
				.marketingAgree(rs.getString("marketing_agree"))
				.enrollDate(rs.getDate("enroll_date"))
				.photoRegist(rs.getString("photo_Regist"))
				.build();
	}
	
	
	
	
	
	
	
	
	
}
