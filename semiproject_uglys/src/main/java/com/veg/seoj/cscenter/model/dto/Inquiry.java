package com.veg.seoj.cscenter.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inquiry implements ResultSetMapper<Inquiry> {
	
	@Builder.Default
	private int inquiryNo = 0;
	@Builder.Default
	private String inquiryType = "";
	@Builder.Default
	private String inquiryTitle = "";
	@Builder.Default
	private String inquiryContent = "";
	@Builder.Default
	private String answerStatus = "";
	@Builder.Default
	private Timestamp inquiryDate = null;
	@Builder.Default
	private int fkMemberNo = 0;
	@Builder.Default
	private int fkOrderNo = 0;
	@Builder.Default
	private String inquiryRenameFilename = "";
	@Builder.Default
	private String inquiryOriginalFilename = "";
	@Builder.Default
	private int fkProductNo = 0;
	@Builder.Default
	private List<InquiryComment> inquiryComments = null;
	
	@Override
	public Inquiry fromResultSet(ResultSet rs) throws SQLException {
		return Inquiry.builder().inquiryNo(rs.getInt("inquiry_no"))
		   .inquiryType(rs.getString("inquiry_type"))
		   .inquiryTitle(rs.getString("inquiry_title"))
		   .inquiryContent(rs.getString("inquiry_content"))
		   .answerStatus(rs.getString("answer_status"))
		   .inquiryDate(rs.getTimestamp("inquiry_date"))
		   .fkMemberNo(rs.getInt("member_no")).fkOrderNo(rs.getInt("order_no"))
		   .inquiryRenameFilename(rs.getString("inquiry_renamed_filename"))
		   .inquiryOriginalFilename(rs.getString("inquiry_original_filename"))
		   .fkProductNo(rs.getInt("product_no")).build();
		
	}
	
	/*   public void addInquiryAll(List<Inquiry> inquiry, ResultSet rs) throws SQLException {
	     int pk = rs.getInt("inquiry_no");
	     if(inquiry.stream().anyMatch(e->pk==(e.getInquiryNo()))) {
	         inquiry.stream().filter(e-> Objects.equals(e.getInquiryNo(), pk))
	               .forEach(e->{
	                   try {
	                       if(rs.getString("procedure_no")!=null && !e.getProcedure().contains(getProcedure(rs))) {
	                           e.getProcedure().add(getProcedure(rs));
	                       }
	
	
	                   }catch(SQLException e1) {
	                       e1.printStackTrace();
	                   }
	
	               });
	
	     }else {
	         Recipe r = getRecipe(rs);
	         if(rs.getString("procedure_no")!=null) r.getProcedure().add(getProcedure(rs));
	         if(rs.getString("material_no")!=null) r.getMaterial().add(getMaterial(rs));
	         if(rs.getString("hashtag_no")!=null) r.getHashtag().add(getHashtag(rs));
	
	         recipe.add(r);
	     }
	
	 }*/
	
}
