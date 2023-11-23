package com.veg.ojy.cart.dto;

import java.util.ArrayList;
import java.util.List;

import com.veg.pdw.production.model.dto.Production;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cart {
	
	private int cartNo;
	private int memberNo;
	private int productNo;
	private int count;
	
	
}
