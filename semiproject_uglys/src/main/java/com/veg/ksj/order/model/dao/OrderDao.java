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
	
	public Order selectOrderDetailsByOrderNo(Connection conn,int orderNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order o=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectOrderDetailsByOrderNo"));
			pstmt.setInt(1, orderNo);
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
	
	public int updateOrderDetails(Connection conn,int orderNo,String status) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateOrderDetails"));
			pstmt.setString(1, status);
			pstmt.setInt(2, orderNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
					.trakingNumber(rs.getInt("TRAKING_NUMBER"))
					.orderDate(rs.getDate("ORDER_DATE"))
					.build();
	}
	
	
}
