package com.veg.ksj.order.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
	private int orderNo;
	private String orderName;
	private String orderPhone;
	private String orderAddress;
	private String orderAddressDetail;
	private String order_comment;
	private int order_count;
	private int totalPrice;
	private int deliveryPay;
	private String payment;
	private String orderStatus;
	private int trakingNumber;
	private Date orderDate;
}