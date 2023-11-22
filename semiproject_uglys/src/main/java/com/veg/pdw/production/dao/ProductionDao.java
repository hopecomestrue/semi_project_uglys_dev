package com.veg.pdw.production.dao;

import static com.veg.common.JDBCTemplate.close;

import java.sql.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;
import com.veg.pdw.production.model.dto.ProductionReview;

public class ProductionDao {
	private Properties sql = new Properties();
	
	{
		String path=ProductionDao.class.getResource("/production/register/production.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public int insertProduction(Connection conn,Production p) {
		
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(sql.getProperty("insertProduction"));
			pstmt.setString(1, p.getProduction_name());
			pstmt.setInt(2,p.getDiscount());
			pstmt.setInt(3,p.getPrice());
			pstmt.setString(4, p.getTag());
			pstmt.setString(5, p.getEnvironment());
			pstmt.setString(6, p.getPlace());
			pstmt.setInt(7, p.getStock());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertProductionContent(Connection conn,ProductionContent pc) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(sql.getProperty("insertProductionContent"));
			pstmt.setString(1, pc.getProductionContent());
			pstmt.setString(2, pc.getProductionImg());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public List<Production> selectProductions(Connection conn, int cPage,int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		List<Production> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductions"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getProduction(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public int selectProductionsCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionsCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}return result;
		
	}
	private Production getProduction(ResultSet rs)throws SQLException{
		return Production.builder()
						.production_no(rs.getInt("PRODUCT_NO"))
						.production_name(rs.getString("PRODUCTION_NAME"))
						.discount(rs.getInt("DISCOUNT"))
						.price(rs.getInt("PRICE"))
						.tag(rs.getString("PRODUCT_TAG"))
						.environment(rs.getString("ENVIRONMENT"))
						.place(rs.getString("PLACE"))
						.production_date(rs.getDate("PRODUCTION_DATE"))
						.stock(rs.getInt("STOCK"))
						.build();
	}
	private ProductionContent getProductionContent(ResultSet rs)throws SQLException{
		return ProductionContent.builder()
								.fileNo(rs.getInt("FILE_NO"))
								.productionNo(rs.getInt("PRODUCT_NO"))
								.productionContent(rs.getString("PRODUCT_CONTENT"))
								.productionImg(rs.getString("PRODUCT_IMG"))
								.build();
	}
	public List<Production>selectProductionList(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Production> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionList"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getProduction(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public List<ProductionContent>selectProductionContentList(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductionContent> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionContentList"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getProductionContent(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public Production selectProductionByNo(Connection conn,int productionNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Production result=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionByNo"));
			pstmt.setInt(1, productionNo);
			rs=pstmt.executeQuery();
			
			if(rs.next())result=getProduction(rs);
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public ProductionContent selectProductionContentByNo(Connection conn,int productionNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductionContent result=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionContentByNo"));
			pstmt.setInt(1, productionNo);
			rs=pstmt.executeQuery();
			
			if(rs.next())result=getProductionContent(rs);
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public Map<Integer,Integer> selectProductionReview(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Map<Integer,Integer> ReviewCount= new HashMap<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionReviewCount"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int proNo=rs.getInt("PRODUCT_NO");
				int count=rs.getInt(2);
				ReviewCount.put(proNo, count);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return ReviewCount;
	}
	
	public List<ProductionReview> selectProductionReviewByNo(Connection conn, int productionNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductionReview> result= new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionReviewByNo"));
			pstmt.setInt(1, productionNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(getProductionReview(rs));
			}
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	private ProductionReview getProductionReview(ResultSet rs)throws SQLException{
		return ProductionReview.builder()
							   .reviewNo(rs.getInt("REVIEW_NO"))
							   .reviewContent(rs.getString("REVIEW_CONTENT"))
							   .rating(rs.getInt("RATING"))
							   .productionNo(rs.getInt("PRODUCT_NO"))
							   .memberNo(rs.getInt("MEMBER_NO"))
							   .reviewDate(rs.getDate("REVIEW_DATE"))
				               .build();
	}
	
	public Map<Integer,Double> selectreviewRating(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Map<Integer,Double> reviewrating= new HashMap<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectReviewRating"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int proNo=rs.getInt("PRODUCT_NO");
				double count=rs.getInt(2);
				reviewrating.put(proNo, count);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return reviewrating;
	}
	public int insertProductionReview(Connection conn ,ProductionReview pr) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(sql.getProperty("insertProductionReview"));
			pstmt.setString(1, pr.getReviewContent());
			pstmt.setInt(2, pr.getRating());
			pstmt.setInt(3, pr.getProductionNo());
			pstmt.setInt(4, pr.getMemberNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public List<Production>selectSearchbyKey(Connection conn,
								Map<String,String>sql,Map<String,String>sql1){
		Statement stmt =null;
		ResultSet rs= null;
		List<Production>result= new ArrayList<>();
		String btsql=sql.entrySet().stream()
			    .map(s -> s.getKey() +  s.getValue())
			    .collect(Collectors.joining(" AND "));
		
		String nsql=sql1.entrySet().stream()
			    .map(s -> s.getKey()+" = '"+s.getValue()+"'")
			    .collect(Collectors.joining(" AND "));
		String resql="SELECT * FROM PRODUCTION WHERE "+btsql+"  AND  "+nsql;
		
		System.out.println(resql);
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(resql);
			
			while(rs.next()) {
				result.add(getProduction(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
			
		return result;
		
	}
	
}
