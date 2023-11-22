package com.veg.kth.admin.community.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.veg.kth.admin.community.dao.AdminCommunityDao;
import com.veg.kth.community.model.dto.Recipe;

public class AdminCommunityService {

	private AdminCommunityDao dao = new AdminCommunityDao(); 
	
	public List<Recipe> selectRecipeAllByPage(){
		Connection conn = getConnection();
		List<Recipe> result = dao.selectRecipeAllByPage(conn);
		close(conn);
		return result;
	}
	
	public List<Recipe> searchRecipeByAnything(String searchType, String searchContent){
		Connection conn = getConnection();
		List<Recipe> result = dao.searchRecipeByAnything(conn, searchType, searchContent);
		close(conn);
		return result;
	}
	

	
	public List<Recipe> searchRecipeByAnythingAndDate(String searchType, String searchContent, String dateStart, String dateEnd){
		Connection conn = getConnection();
		List<Recipe> result = dao.searchRecipeByAnythingAndDate(conn, searchType, searchContent, dateStart, dateEnd);
		close(conn);
		return result;
	
	}
	
	public Recipe selectRecipeByNo(int r) {
		Connection conn = getConnection();
		Recipe result = dao.selectRecipeByNo(conn,r);
		close(conn);
		return result;
	}
	
	
	public int updateRecipe(Recipe r) {
		Connection conn = getConnection();
		int result = dao.updateRecipe(conn,r);
		
//		int resultM = dao.updateMaterial(conn, r);
//		int resultP = dao.updateProcedure(conn, r);
//		int resultC = dao.updateCategory(conn, r);
		
		
		close(conn);
		return result;
	}
	
}
