package com.veg.ksj.orderdetail.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetail {
	private int orderDetailNo;
	private int productNo;
	private long orderNo;
	private int productCount;
	private int productPrice;
}
