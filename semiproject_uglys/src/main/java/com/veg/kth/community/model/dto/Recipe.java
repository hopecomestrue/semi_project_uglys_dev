package com.veg.kth.community.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recipe {

	private int recipeNo;
	private String recipeOriginalFileName;
	private String recipeRenamedFileName;
	private String recipeTitle;
	private String recipeComment;
	private String recipeLeadTime;
	private List<Category> category;
	private List<RecipeHashtag> recipeHashtag;
	private int recipeCapa;
	private List<Material> material;
	private List<Procedure> procedure;
	private Date recipeDate;
}
