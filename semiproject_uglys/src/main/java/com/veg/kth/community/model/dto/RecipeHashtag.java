package com.veg.kth.community.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RecipeHashtag {

	private List<Hashtag> hashtag = new ArrayList<>();
	private int recipeNo;
}
