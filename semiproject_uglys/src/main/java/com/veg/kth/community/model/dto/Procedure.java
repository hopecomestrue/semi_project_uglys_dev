package com.veg.kth.community.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Procedure {

	private int procedureNo;
	private Long procedureOrder;
	private String procedureComment;
	private String procedureOriginalFileName;
	private String procedureRenamedFileName;
	private int recipeNo;
}
