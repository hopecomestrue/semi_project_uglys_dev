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
	
	
	public List<Hashtag> selectHashtagAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Hashtag> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectHashtagAll"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getHashtag(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	
	public List<Category> selectCategoryAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Category> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectCategoryAll"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getCategory(rs));
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
	
	
	public int insertRecipe(Connection conn, Recipe r) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertRecipe"));
			pstmt.setString(1, r.getRecipeOriginalFileName());
			pstmt.setString(2, r.getRecipeRenamedFileName());
			pstmt.setString(3, r.getRecipeTitle());
			pstmt.setString(4, r.getRecipeComment());
			pstmt.setString(5, r.getRecipeLeadTime());
			pstmt.setInt(6, r.getRecipeCapa());
			pstmt.setInt(7, r.getMember_no());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	
	public int checkRecipeNo(Connection conn, Recipe r) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			
			pstmt = conn.prepareStatement(sql.getProperty("checkRecipeNo"));
			pstmt.setInt(1, r.getMember_no());
			pstmt.setInt(2, r.getRecipeCapa());
			pstmt.setString(3, r.getRecipeTitle());
			rs = pstmt.executeQuery();
			while(rs.next()) result=rs.getInt("recipe_no");
		}catch(SQLException e) {
			
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	
	
	public int insertMaterial(Connection conn, Recipe r, int recipeNo) {
		int result = 0;
		List<Material> m = r.getMaterial();
		
		System.out.println("확인1"+m);
		System.out.println(recipeNo);
		for(int i=0;i<m.size();i++) {
		PreparedStatement pstmt = null;
		try {
			
			
			pstmt = conn.prepareStatement(sql.getProperty("insertMaterial"));
			pstmt.setString(1, m.get(i).getMaterialType());
			pstmt.setString(2, m.get(i).getMaterialName());
			pstmt.setString(3, m.get(i).getMaterialCapa());
			pstmt.setInt(4, recipeNo);
			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		}
		return result;
		
	}
	
	public int insertProcedure(Connection conn, Recipe r, int recipeNo) {
		int result = 0;
		List<Procedure> m = r.getProcedure();
		
		for(int i=0;i<m.size();i++) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertProcedure"));
			pstmt.setLong(1, m.get(i).getProcedureOrder());
			pstmt.setString(2, m.get(i).getProcedureComment());
			pstmt.setString(3, m.get(i).getProcedureOriginalFileName());
			pstmt.setString(4, m.get(i).getProcedureRenamedFileName());
			pstmt.setInt(5, recipeNo);
			result+=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		}
		return result;
		
	}
	
	public int insertHashtag(Connection conn, Recipe r) {
		int result = 0;
		System.out.println("재료수량"+r.getMaterial().size());
		List<Hashtag> m = r.getHashtag();
		if(!m.isEmpty()&&m!=null) {
			for(int i=0;i<m.size();i++) {
				PreparedStatement pstmt = null;
				try {
					pstmt = conn.prepareStatement(sql.getProperty("insertHashtag"));
					pstmt.setString(1, m.get(i).getHashtagValue());
					result=pstmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
			}
			
		}
		return result;
		
	}
	
	public int insertRecipeHashtag(Connection conn, Recipe r, int recipeNo, List<Hashtag> h) {
		int result = 0;
		List<Hashtag> recipe_hash = r.getHashtag();
		PreparedStatement pstmt = null;
		List<Integer> hashtagNo = new ArrayList<>();
		for(int i=0;i<recipe_hash.size();i++) {
			for(int j=0;j<h.size();j++) {
				if(h.get(j).getHashtagValue().equals(recipe_hash.get(i).getHashtagValue())) {
					hashtagNo.add(h.get(j).getHashtagNo());
				}	
			}
		}
		
		for(int i=0;i<hashtagNo.size();i++) {
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertRecipeHashtag"));
			pstmt.setInt(1, hashtagNo.get(i));
			pstmt.setInt(2, recipeNo);
			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		}
		return result;
		
	}
	
	
	public int insertCategory(Connection conn, Recipe r, int recipeNo) {
		int result = 0;
		Category m = r.getCategory();
		System.out.println("카테고리1"+m.getCategoryDept1());
		System.out.println("카테고리2"+m.getCategoryDept2());
		System.out.println("레시피번호"+recipeNo);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertCategory"));
			pstmt.setString(1, m.getCategoryDept1());
			pstmt.setString(2, m.getCategoryDept2());
			pstmt.setInt(3, recipeNo);
			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
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
		return (Recipe)result;
		
		
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
				.hashtag(new ArrayList<>())
				.material(new ArrayList<>())
				.procedure(new ArrayList<>())
				.recipeCapa(rs.getInt("recipe_capa"))
				.recipeDate(rs.getDate("recipe_date"))
				.member_no(rs.getInt("member_no"))
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
