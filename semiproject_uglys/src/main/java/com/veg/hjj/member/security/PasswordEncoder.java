package com.veg.hjj.member.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncoder extends HttpServletRequestWrapper{
	public PasswordEncoder (HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String memberName) {
		if(memberName.contains("memberPw")) {
			String ori=super.getParameter(memberName);
			//System.out.println("memberPw 원본 :" +ori);
			String change=getSHA512(ori);
			//System.out.println("memberPw 변경 :" +change);
			return change;
		}
		return super.getParameter(memberName);
	}
	
	
	
	
	public  String getSHA512(String oriVal) {
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] oridatabyte=oriVal.getBytes();
		md.update(oridatabyte);
		byte[] encryptData=md.digest();
		String encryptStr=Base64.getEncoder().encodeToString(encryptData);
		return encryptStr;
		
	}
}
