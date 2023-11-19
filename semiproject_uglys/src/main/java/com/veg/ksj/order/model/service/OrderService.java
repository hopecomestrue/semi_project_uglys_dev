package com.veg.ksj.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dao.OrderDao;
import com.veg.ksj.order.model.dto.Order;
import static com.veg.common.JDBCTemplate.*;

public class OrderService {

	private OrderDao dao=new OrderDao();
	
	//주문 고유번호로 해당 주문row 가져오기
	public Order selectOrderDetailsByOrderNo(long orderNo) {
		Connection conn=getConnection();
		Order o=dao.selectOrderDetailsByOrderNo(conn,orderNo);
		close(conn);
		return o;
	}
	//주문 테이블에 등록(주문/결제 등록)
	public int insertOrderDetails(Order order,Member m) {
		Connection conn=getConnection();
		int result=dao.insertOrderDetails(conn,order,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//주문현황 모든 row 가져오기
	public List<Order> selectAllOrderDetails(){
		Connection conn=getConnection();
		List<Order> orders=dao.selectAllOrderDetails(conn);
		close(conn);
		return orders;
	}
	//송장번호 입력+주문상태 변경(결제완료->배송준비중,배송중,배송완료) -관리자
	public int updateOrderDetails(int trackingNo,int orderNo,String status) {
		Connection conn=getConnection();
		int result=dao.updateOrderDetails(conn,trackingNo,orderNo,status);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	public Member selectMemberByNo(int memNo) {
		Connection conn=getConnection();
		Member m=dao.selectMemberByNo(conn, memNo);
		close(conn);
		return m;
	}
	
	
	
	
}
