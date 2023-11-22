package com.veg.ksj.order.model.dto;

import java.sql.Date;
import java.util.List;

import com.veg.ojy.cart.dto.Cart;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
	private long orderNo;
	private int memberNo;
	private String orderName;
	private String orderPhone;
	private String orderAddress;
	private String orderComment;
	private int orderCount;
	private int totalPrice;
	private int deliveryPay;
	private String payment;
	private String orderStatus;
	private long trackingNumber;
	private Date orderDate;
}
