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
	
	public Order selectOrderDetails(Connection conn,int orderNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order o=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectOrderDetails"));
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
	
	public int insertOrderDetails(Connection conn,Order order) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertOrderDetails"));
			pstmt.setInt(1, order.getOrderNo());
			
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
			pstmt.setInt(1, orderNo);
			pstmt.setString(2, status);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	private Order getOrder(ResultSet rs) throws SQLException{
		return Order.builder()
					.orderNo(rs.getInt("orderNo"))
					.orderName(rs.getString("orderName"))
					.orderPhone(rs.getString("orderPhone"))
					.orderAddress(rs.getString("orderAddress"))
					.orderComment(rs.getString("orderComment"))
					.orderCount(rs.getInt("orderCount"))
					.totalPrice(rs.getInt("totalPrice"))
					.deliveryPay(rs.getInt("deliveryPay"))
					.payment(rs.getString("payment"))
					.orderStatus(rs.getString("orderStatus"))
					.trakingNumber(rs.getInt("trakingNumber"))
					.orderDate(rs.getDate("orderDate"))
					.build();
	}
	
	
}
