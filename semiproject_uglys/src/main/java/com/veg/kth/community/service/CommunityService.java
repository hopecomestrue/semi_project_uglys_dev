package com.veg.kth.community.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.veg.hjj.member.dto.Member;
import com.veg.ksj.order.model.dao.OrderDao;
import com.veg.kth.community.model.dao.CommunityDao;
import com.veg.kth.community.model.dto.Category;
import com.veg.kth.community.model.dto.Hashtag;
import com.veg.kth.community.model.dto.Recipe;
import com.veg.kth.community.model.dto.RecipeComment;

public class CommunityService {

	private CommunityDao dao = new CommunityDao();
	private OrderDao orderDao = new OrderDao();
	
	public List<Recipe> selectRecipeAll(){
		Connection conn = getConnection();
		List<Recipe> result = dao.selectRecipeAll(conn);
		close(conn);
		return result;
	}
	
	
	public List<Hashtag> selectHashtagAll(){
		Connection conn = getConnection();
		List<Hashtag> result = dao.selectHashtagAll(conn);
		close(conn);
		return result;
	}
	
	public List<Category> selectCategoryAll(){
		Connection conn = getConnection();
		List<Category> result = dao.selectCategoryAll(conn);
		close(conn);
		return result;
	}
	
	
	public int insertRecipe(Recipe r) {
		Connection conn = getConnection();
		int result = dao.insertRecipe(conn, r);
		int recipeNo = 0;
		if(result>0) {
			recipeNo =dao.checkRecipeNo(conn, r);
			System.out.println("입력 완료");
			System.out.println(recipeNo);
			commit(conn); 
		}
		else { rollback(conn);
		System.out.println("입력 불가");}
		
		if(result>0 && recipeNo!=0) {
		System.out.println("들어왔다");
			int resultM = dao.insertMaterial(conn, r, recipeNo);
	
			int resultP = dao.insertProcedure(conn, r, recipeNo);
			int resultC = dao.insertCategory(conn, r, recipeNo);
			
			//int resultH = dao.insertHashtag(conn,r);
			
			List<Hashtag> hashtag = dao.selectHashtagAll(conn);
			
			//int resultRh = dao.insertRecipeHashtag(conn, r, recipeNo, hashtag);
			
			if(resultM!=0 && resultP!=0 && resultC!=0 ) { //&& resultH!=0 && resultRh!=0
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		close(conn);
		if(recipeNo==0) rollback(conn);
		return result;
		
	}
	
	public Recipe selectRecipeByNo(int r) {
		Connection conn = getConnection();
		Recipe result = dao.selectRecipeByNo(conn,r);
		close(conn);
		return result;
	}
	
	public List<RecipeComment> selectRecipeComment(int recipeNo){
		Connection conn = getConnection();
		List<RecipeComment> result = dao.selectRecipeComment(conn, recipeNo);
		close(conn);
		return result;
	}
	
	public List<Member> selectMemberByNo(List<Recipe> recipes) {
		Connection conn=getConnection();
			List<Member> members = new ArrayList<>();
			for(Recipe r : recipes) {
				Member m=orderDao.selectMemberByNo(conn, r.getMember_no());				
				members.add(m);
			}
		
		close(conn);
		return members;
	}
	
	
	
}
