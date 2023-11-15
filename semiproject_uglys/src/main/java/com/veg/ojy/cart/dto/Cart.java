package com.veg.ojy.cart.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cart {
	
	private int cartNo;
	private int memberNo;
	private int productNo;
	private int count;
	
	// 상품개수 불러오기 때문에 적어봄..........
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	} 
	

}
