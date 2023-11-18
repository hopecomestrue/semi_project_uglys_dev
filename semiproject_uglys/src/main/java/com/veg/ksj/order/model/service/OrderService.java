package com.veg.ksj.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dao.OrderDao;
import com.veg.ksj.order.model.dto.Order;
import static com.veg.common.JDBCTemplate.*;

public class OrderService {

	private OrderDao dao=new OrderDao();
	
	public Order selectOrderDetails(int orderNo) {
		Connection conn=getConnection();
		Order o=dao.selectOrderDetails(conn,orderNo);
		close(conn);
		return o;
	}
	
	public int insertOrderDetails(Order order,Member m) {
		Connection conn=getConnection();
		int result=dao.insertOrderDetails(conn,order,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<Order> selectAllOrderDetails(){
		Connection conn=getConnection();
		List<Order> orders=dao.selectAllOrderDetails(conn);
		close(conn);
		return orders;
	}
	
	public int updateOrderDetails(int orderNo,String status) {
		Connection conn=getConnection();
		int result=dao.updateOrderDetails(conn,orderNo,status);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
