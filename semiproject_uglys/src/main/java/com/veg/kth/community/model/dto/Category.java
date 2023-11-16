package com.veg.kth.community.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

	private int categoryNo;
	private String categoryDept1;
	private String categoryDept2;
	private int recipeNo;
}
