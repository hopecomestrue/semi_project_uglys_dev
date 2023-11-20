package com.veg.pdw.production.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ProductionReview {
	private int reviewNo;
	private String reviewContent;
	private int rating;
	private int productionNo;
	private int memberNo;
	private Date reviewDate;
	
	
}
