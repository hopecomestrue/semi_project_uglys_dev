package com.veg.ksj.refund.model.dao;

import static com.veg.common.JDBCTemplate.close;

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
import com.veg.ksj.order.model.dao.OrderDao;
import com.veg.ksj.order.model.dto.Order;
import com.veg.ksj.refund.model.dto.Refund;

public class RefundDao {

	
private Properties sql=new Properties();
	
	{
		String path=RefundDao.class.getResource("/sql/order/order_sql.properties").getPath();
		try(FileReader fr=new FileReader(path)){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Refund selectRefundByOrderNo(Connection conn,long orderNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Refund r=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectRefundByOrderNo"));
			pstmt.setLong(1, orderNo);
			rs=pstmt.executeQuery();
			if(rs.next()) r=getRefund(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return r;
	}
	
	//환불 테이블에 등록
		public int insertRefund(Connection conn,Order o,Member m) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("insertRefund"));
				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
			
		}
		
		//환불현황 모든 row 가져오기
		public List<Refund> selectAllRefundList(Connection conn){
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Refund> refunds=new ArrayList<Refund>();
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectAllRefundList"));
				rs=pstmt.executeQuery();
				while(rs.next()) {
					refunds.add(getRefund(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return refunds;
		}
		
		
		public static Refund getRefund(ResultSet rs) throws SQLException{
			return Refund.builder()
						.refundNo(rs.getInt("REFUND_NO"))
						.orderNo(rs.getInt("ORDER_NO"))
						.refundReason(rs.getString("REFUND_REASON"))
						.refundResult(rs.getString("REFUND_RESULT"))
						.refundDate(rs.getDate("REFUND_DATE"))
						.build();
		}
}
