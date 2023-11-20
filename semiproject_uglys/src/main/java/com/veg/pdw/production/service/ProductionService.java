package com.veg.pdw.production.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.veg.pdw.production.dao.ProductionDao;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;
import com.veg.pdw.production.model.dto.ProductionReview;

public class ProductionService {
	public int insertProduction(Production p,ProductionContent pc) {
		Connection conn =getConnection();
		int result=new ProductionDao().insertProduction(conn,p)+
						new ProductionDao().insertProductionContent(conn,pc);
		if(result==2){
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public List<Production>selectProductions(int cPage,int numPerpage){
		Connection conn =getConnection();
		List<Production> result = new ProductionDao().selectProductions(conn,cPage,numPerpage);
		close(conn);
		return result;
		
	}
	public int selectProductionsCount() {
		Connection conn =getConnection();
		int result = new ProductionDao().selectProductionsCount(conn);
		close(conn);
		return result;
	}
	public List<Production>selectProductionList(){
		Connection conn =getConnection();
		List<Production> result = new ProductionDao().selectProductionList(conn);
		close(conn);
		return result;
	}
	public List<ProductionContent>selectProductionContentList(){
		Connection conn =getConnection();
		List<ProductionContent> result = new ProductionDao().selectProductionContentList(conn);
		close(conn);
		return result;
		
	}	
	
	public Production selectProductionByNo(int productionNo) {
		Connection conn =getConnection();
		Production result = new ProductionDao().selectProductionByNo(conn,productionNo);
		close(conn);
		return result;
	}
	public ProductionContent selectProductionContentByNo(int productionNo) {
		Connection conn =getConnection();
		ProductionContent result = new ProductionDao().selectProductionContentByNo(conn,productionNo);
		close(conn);
		return result;
	}
	public Map<Integer,Integer> selectProductionReviewList() {
		Connection conn =getConnection();
		Map<Integer,Integer> result = new ProductionDao().selectProductionReview(conn);
		close(conn);
		return result;
	}
	public List<ProductionReview> selectProductionReviewByNo(int productionNo) {
		Connection conn =getConnection();
		List<ProductionReview> result = new ProductionDao().selectProductionReviewByNo(conn,productionNo);
		close(conn);
		return result;
	}
	public Map<Integer,Double> selectreviewRating(){
		Connection conn =getConnection();
		Map<Integer,Double> result = new ProductionDao().selectreviewRating(conn);
		close(conn);
		return result;
	}
	public int insertProductionReview(ProductionReview pr) {
		Connection conn =getConnection();
		int result=new ProductionDao().insertProductionReview(conn,pr);
						
		if(result==1){
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
