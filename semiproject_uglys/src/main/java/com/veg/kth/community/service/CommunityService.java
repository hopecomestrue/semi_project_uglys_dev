package com.veg.kth.community.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.veg.kth.community.model.dao.CommunityDao;
import com.veg.kth.community.model.dto.Recipe;

public class CommunityService {

	private CommunityDao dao = new CommunityDao(); 
	
	public List<Recipe> selectRecipeAll(){
		Connection conn = getConnection();
		List<Recipe> result = dao.selectRecipeAll(conn);
		close(conn);
		return result;
	}
}
