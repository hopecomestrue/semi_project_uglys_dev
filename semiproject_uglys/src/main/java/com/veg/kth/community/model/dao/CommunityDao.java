package com.veg.kth.community.model.dao;

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

import com.veg.kth.community.model.dto.Category;
import com.veg.kth.community.model.dto.Material;
import com.veg.kth.community.model.dto.Procedure;
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.model.dto.RecipeHashtag;

public class CommunityDao {
	
	private Properties sql = new Properties();
	
	{
		String path = CommunityDao.class.getResource("/sql.community/community.properties").getPath();
		try(FileReader fr = new FileReader(path)) {
			sql.load(fr);
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	
	public List<Recipe> selectRecipeAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Recipe> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectRecipeAll"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getRecipe(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return result;
	}
	
	
	public Recipe getRecipe(ResultSet rs) throws SQLException {
		return Recipe.builder()
				.recipeNo(rs.getInt("recipe_no"))
				.recipeOriginalFileName(rs.getString("recipe_original_file_name"))
				.recipeRenamedFileName(rs.getString("recipe_renamed_file_name"))
				.recipeTitle(rs.getString("recipe_title"))
				.recipeComment(rs.getString("recipe_comment"))
				.recipeLeadTime(rs.getString("recipe_leadtime"))
				.category((List<Category>)rs.getObject("Community_recipe_category"))
				.recipeHashtag((List<RecipeHashtag>) rs.getObject("Community_recipe_hashtag"))
				.material((List<Material>)rs.getObject("Community_recipe_material"))
				.procedure((List<Procedure>)rs.getObject("Community_recipe_procedure"))
				.recipeCapa(rs.getInt("recipe_capa"))
				.recipeDate(rs.getDate("recipe_date"))
				.build();
	}

}
