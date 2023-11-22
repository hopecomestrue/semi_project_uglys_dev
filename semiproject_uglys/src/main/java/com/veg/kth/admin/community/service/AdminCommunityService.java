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
}
