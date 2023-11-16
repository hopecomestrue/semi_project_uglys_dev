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
import java.util.Objects;
import java.util.Properties;

import com.veg.kth.community.model.dto.Category;
import com.veg.kth.community.model.dto.Hashtag;
import com.veg.kth.community.model.dto.Material;
import com.veg.kth.community.model.dto.Procedure;
import com.veg.kth.community.model.dto.Recipe;

public class CommunityDao {
	
	private Properties sql = new Properties();
	
	{
		String path = CommunityDao.class.getResource("/sql/community/community_sql.properties").getPath();
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
	
	public void addRecipeAll(List<Recipe> recipe, ResultSet rs) throws SQLException {
		int pk = rs.getInt("recipe_no");
		if(recipe.stream().anyMatch(e->pk==(e.getRecipeNo()))) {
			recipe.stream().filter(e->Objects.equals(e.getRecipeNo(),pk))
			.forEach(e->{
				try {
					if(rs.getString("procedure_no")!=null && !e.getProcedure().contains(getProcedure(rs))) { 
						e.getProcedure().add(getProcedure(rs));
					}
					
					if(rs.getString("material_no")!=null && !e.getMaterial().contains(getMaterial(rs))) {
						e.getMaterial().add(getMaterial(rs));
					}
					
					if(rs.getString("hashtag_no")!=null && !e.getHashtag().contains(getHashtag(rs))) { 
						e.getHashtag().add(getHashtag(rs));
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
		
	}
	
	
	public Recipe getRecipe(ResultSet rs) throws SQLException {
		return Recipe.builder()
				.recipeNo(rs.getInt("recipe_no"))
				.recipeOriginalFileName(rs.getString("recipe_original_file_name"))
				.recipeRenamedFileName(rs.getString("recipe_renamed_file_name"))
				.recipeTitle(rs.getString("recipe_title"))
				.recipeComment(rs.getString("recipe_comment"))
				.recipeLeadTime(rs.getString("recipe_leadtime"))
				.category(getCategory(rs))
				.Hashtag(new ArrayList<>())
				.material(new ArrayList<>())
				.procedure(new ArrayList<>())
				.recipeCapa(rs.getInt("recipe_capa"))
				.recipeDate(rs.getDate("recipe_date"))
				.build();
	}

	
	public Category getCategory(ResultSet rs) throws SQLException{
		return Category.builder()
				.categoryNo(rs.getInt("category_no"))
				.categoryDept1(rs.getString("category_dept1"))
				.categoryDept2(rs.getString("category_dept2"))
				.recipeNo(rs.getInt("recipe_no"))
				.build();
	}
	
	public Hashtag getHashtag(ResultSet rs) throws SQLException{
		return Hashtag.builder()
				.hashtagNo(rs.getInt("hashtag_no"))
				.hashtagValue(rs.getString("hashtag_value"))
				.build();
	}
	
	public Procedure getProcedure(ResultSet rs) throws SQLException{
		return Procedure.builder()
				.procedureNo(rs.getInt("procedure_no"))
				.procedureOrder(rs.getLong("procedure_order"))
				.procedureComment(rs.getString("procedure_comment"))
				.procedureOriginalFileName(rs.getString("procedure_original_file_name"))
				.procedureRenamedFileName(rs.getString("procedure_renamed_file_name"))
				.recipeNo(rs.getInt("recipe_no"))
				.build();
	}
	
	public Material getMaterial(ResultSet rs)throws SQLException{
		return Material.builder()
				.materialNo(rs.getInt("material_no"))
				.materialType(rs.getString("material_type"))
				.materialName(rs.getString("material_name"))
				.materialCapa(rs.getString("material_capa"))
				.recipeNo(rs.getInt("recipe_no"))
				.build();
	}
	
	
	
}
