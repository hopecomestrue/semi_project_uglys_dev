package com.veg.kth.community.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeComment {

	private int commentNo;
	private String commentWriter;
	private String commentContent;
	private String commentOriginalFileName;
	private String commentRenamedFileName;
	private Date commentDate;
	private int recipeNo;
	private int memberNo;
}
