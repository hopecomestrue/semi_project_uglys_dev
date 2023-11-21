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
	
	
}
