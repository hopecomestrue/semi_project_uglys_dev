package com.veg.kth.community.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hashtag {

	private int hashtagNo;
	private String hashtagValue;
}
