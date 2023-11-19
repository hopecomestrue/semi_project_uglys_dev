package com.veg.ojy.mypage.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
	
	private int addressNo;
	private int memberNo;
	private String address;
	private String defaultAddress;

}
