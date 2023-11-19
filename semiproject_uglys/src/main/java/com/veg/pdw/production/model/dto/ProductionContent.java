package com.veg.pdw.production.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductionContent {
	private int fileNo;
	private int productionNo;
	private String productionContent;
	private String productionImg;
}
