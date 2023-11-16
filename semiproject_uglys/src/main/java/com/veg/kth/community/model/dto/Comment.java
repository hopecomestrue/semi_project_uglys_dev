package com.veg.kth.community.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {

	private int commentNo;
	private String commentWriter;
	private String commentOriginalName;
	private String commentRenamedName;
	private Date commentDate;
	private int recipeNo;
	private int memberNo;
	
}
