package com.veg.ksj.refund.service;

import java.sql.Connection;
import java.util.List;
import static com.veg.common.JDBCTemplate.*;

import com.veg.ksj.refund.model.dao.RefundDao;
import com.veg.ksj.refund.model.dto.Refund;

public class RefundService {

	RefundDao dao=new RefundDao();
	
	
	public Refund selectRefundByOrderNo(int orderNo) {
		Connection conn=getConnection();
		Refund refund=dao.selectRefundByOrderNo(conn,orderNo);
		close(conn);
		return refund;
	}
	
	public List<Refund> selectAllRefundList(){
		Connection conn=getConnection();
		List<Refund> refunds=dao.selectAllRefundList(conn);
		close(conn);
		return refunds;
	}
}
