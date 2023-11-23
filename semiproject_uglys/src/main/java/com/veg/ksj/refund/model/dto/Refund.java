package com.veg.ksj.refund.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Refund {
	private int refundNo;
	private int orderNo;
	private String refundReason;
	private String refundResult;
	private Date refundDate;
}
