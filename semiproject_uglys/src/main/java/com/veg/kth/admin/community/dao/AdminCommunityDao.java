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
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectRecipeByNo"));
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
}
