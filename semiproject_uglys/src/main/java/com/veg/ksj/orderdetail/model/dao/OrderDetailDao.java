package com.veg.ksj.orderdetail.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.veg.ksj.orderdetail.model.dto.OrderDetail;

public class OrderDetailDao {

	//주문_상세DTO 빌더패턴
		public static OrderDetail getOrderDetail(ResultSet rs) throws SQLException{
			return OrderDetail.builder()
						.orderDetailNo(rs.getInt("ORDER_DETAIL_NO"))
						.productNo(rs.getInt("PRODUCT_NO"))
						.orderNo(rs.getLong("ORDER_NO"))
						.productCount(rs.getInt("PRODUCT_COUNT"))
						.productPrice(rs.getInt("PRODUCT_PRICE"))
						.build();
		}
}
