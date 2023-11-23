package com.veg.ksj.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dao.OrderDao;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ojy.cart.dto.Cart;
import com.veg.pdw.production.model.dto.Production;

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
	//멤버 고유번호로 해당 주문row 가져오기
	public List<Order> selectAllOrderDetailsByMemNo(int memberNo){
		Connection conn=getConnection();
		List<Order>orders=dao.selectAllOrderDetailsByMemNo(conn, memberNo);
		close(conn);
		return orders;
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
	
	//주문_상세 테이블에 등록(주문/결제 등록)
		public int inserOrderDetailEnd(Order order,Production pro,Cart c) {
			Connection conn=getConnection();
			int result=dao.inserOrderDetailEnd(conn,order,pro,c);
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
	//환불현황 변경(환불승인완료) -관리자
	public int updateRefundDetails(String refundCheck,long refundNo) {
		Connection conn=getConnection();
		int result=dao.updateRefundDetails(conn,refundCheck,refundNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//송장번호 입력+주문상태 변경(결제완료->배송준비중,배송중,배송완료) -관리자
	public int updateOrderDetails(String status,long trackingNo,long orderNo) {
		Connection conn=getConnection();
		int result=dao.updateOrderDetails(conn,status,trackingNo,orderNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//주문 환불 요청 -유저
	public int OrderRefundRequest(long refundNo) {
		Connection conn=getConnection();
		int result=dao.OrderRefundRequest(conn,refundNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//주문현황 리스트 페이징처리
	public List<Order> searchDelList(int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Order> result=dao.searchDelList(conn,cPage,numPerpage);
		close(conn);
		return result;
	}
	
	public List<Order> searchDelByKeyword(String type,String keyword,int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Order> result=dao.searchDelByKeyword(conn,type,keyword,cPage,numPerpage);
		close(conn);
		return result;
	}
	
	public int selectDelByKeywordCount(String type,String keyword) {
		Connection conn=getConnection();
		int result=dao.selectDelByKeywordCount(conn,type,keyword);
		close(conn);
		return result;
	}
	
	public int selectDelCount() {
		Connection conn=getConnection();
		int count=dao.selectDelCount(conn);
		close(conn);
		return count;
	}
	
	
	//환불현황 리스트 페이징처리
	public List<Order> searchRefundList(int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Order> result=dao.searchRefundList(conn,cPage,numPerpage);
		close(conn);
		return result;
	}
	
	public List<Order> searchRefundByKeyword(String type,String keyword,int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Order> result=dao.searchRefundByKeyword(conn,type,keyword,cPage,numPerpage);
		close(conn);
		return result;
	}
	
	public int selectRefundByKeywordCount(String type,String keyword) {
		Connection conn=getConnection();
		int result=dao.selectRefundByKeywordCount(conn,type,keyword);
		close(conn);
		return result;
	}
	
	public int selectRefundCount() {
		Connection conn=getConnection();
		int count=dao.selectRefundCount(conn);
		close(conn);
		return count;
	}
		
		
		
		
	
	
	
	/* 멤버 임시 메소드 */
	
	public Member selectMemberByIdAndPw(String memberId,String memberPw) {
		Connection conn=getConnection();
		Member m=dao.selectMemberByIdAndPw(conn,memberId,memberPw);
		close(conn);
		return m;
	}
	
	public Member selectMemberByNo(int memNo) {
		Connection conn=getConnection();
		Member m=dao.selectMemberByNo(conn, memNo);
		close(conn);
		return m;
	}
	
	
	
	
}
