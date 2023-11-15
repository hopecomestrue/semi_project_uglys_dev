package com.veg.kth.community.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RecipeHashtag {

	private List<Hashtag> hashtag;
	private int recipeNo;
}
