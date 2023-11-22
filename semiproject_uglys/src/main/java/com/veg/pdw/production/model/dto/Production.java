package com.veg.pdw.production.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Production {
	private int production_no;
	private String production_name;
	private int discount;
	private int price;
	private String tag;
	private String environment;
	private String place;
	private int stock;
	private Date production_date;
	
}
