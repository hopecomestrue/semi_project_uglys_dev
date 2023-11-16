package com.veg.kth.community.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Material {
	private int materialNo;
	private String materialType;
	private String materialName;
	private String materialCapa;
	private int recipeNo;
}
