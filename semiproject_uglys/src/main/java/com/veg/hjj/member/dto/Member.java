package com.veg.hjj.member.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAge;
	private String memberEmail;
	private String memberPhone;
	private String acceptAgree;
	private String adminCheck;
	private String serviceAgree;
	private String marketingAgree;
	private Date enrollDate;
	private String photoRegist;
	private String memberQuit;
}
