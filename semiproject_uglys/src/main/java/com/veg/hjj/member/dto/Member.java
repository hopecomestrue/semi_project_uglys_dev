package com.veg.hjj.member.dto;

import java.sql.Date;


import java.util.ArrayList;
import java.util.List;

import com.veg.ksj.order.model.dto.Order;
import com.veg.ojy.cart.dto.Cart;
import com.veg.ojy.mypage.dto.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAge;
	private String memberEmail;
	private int memberPhone;
	private String acceptAgree;
	private String adminCheck;
	private String serviceAgree;
	private String marketingAgree;
	private Date enrollDate;
	private String photoRegist;
	private String memberQuit;
	
	private List<String> address;
	private List<Cart> cart;
	private List<Order> order;
}
