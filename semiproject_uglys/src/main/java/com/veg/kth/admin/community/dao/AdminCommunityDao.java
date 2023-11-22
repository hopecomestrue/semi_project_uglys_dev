package com.veg.kth.admin.community.dao;

import static com.veg.common.JDBCTemplate.close;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.veg.kth.community.model.dao.CommunityDao;
import com.veg.kth.community.model.dto.Recipe;
import static com.veg.kth.community.model.dao.CommunityDao.*;

public class AdminCommunityDao {

private Properties sql = new Properties();
	
	{
		String path = CommunityDao.class.getResource("/sql/community/community_sql.properties").getPath();
		try(FileReader fr = new FileReader(path)) {
			sql.load(fr);
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	public List<Recipe> selectRecipeAllByPage(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Recipe> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectRecipeAllByPage"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				addRecipeAll(result,rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	
	
	public List<Recipe> searchRecipeByAnything(Connection conn, String searchType, String searchContent){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = sql.getProperty("searchRecipeByAnything");
		System.out.println(searchType);
		System.out.println(searchContent);
		query = query.replace("#COL", searchType);
		List<Recipe> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchContent+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				addRecipeAll(result,rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	
	
	public List<Recipe> searchRecipeByAnythingAndDate(Connection conn, String searchType, String searchContent, String dateStart, String dateEnd){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = sql.getProperty("searchRecipeByAnythingAndDate");
		query = query.replace("#COL", searchType);
		if(dateStart!=null) {
			query+=" AND RECIPE_DATE > ?";
		}
		if(dateEnd!=null) {
			query+=" AND RECIPE_DATE < ?";
		}
		
		System.out.println(query);
		List<Recipe> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchContent+"%");
			pstmt.setString(2, dateStart);
			pstmt.setString(3, dateEnd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				addRecipeAll(result,rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(result);
		return result;
	}
	
	public Recipe selectRecipeByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Recipe> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectRecipeByNo"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				addRecipeAll(result,rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result.get(0);
		
		
	}
	
	
	
	public int updateRecipe(Connection conn, Recipe r) {
		PreparedStatement pstmt = null;
		int result = 0;
//		String query="UPDATE community_recipe SET ";
//		if(r.getRecipeOriginalFileName()!=null) {
//			query +=  "RECIPE_ORIGINAL_FILE_NAME = '" + r.getRecipeOriginalFileName()+"',"; 
//		}
//		if(r.getRecipeRenamedFileName()!=null) {
//			query +=  "RECIPE_RENAMED_FILE_NAME = '" + r.getRecipeRenamedFileName()+"',";
//		}
//		if(r.getRecipeTitle()!=null) {
//			query +=  "RECIPE_TITLE = '" + r.getRecipeTitle()+"',";
//		}
//		if(r.getRecipeComment()!=null) {
//			query +=  "RECIPE_COMMENT = '" + r.getRecipeComment()+"',"; 
//		}
//		if(r.getRecipeLeadTime()!=null || !r.getRecipeLeadTime().equals("0")) {
//			query +=  "RECIPE_LEADTIME = '" + r.getRecipeLeadTime()+"',"; 
//		}
//		if(r.getRecipeCapa()!=0) {
//			query +=  "RECIPE_CAPA = " + r.getRecipeCapa(); 
//		}
//		query += " WHERE RECIPE_NO = ?";
		System.out.println(r.getRecipeNo());
//		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateRecipe"));
			pstmt.setInt(1, r.getRecipeNo());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;

	}
	
}
