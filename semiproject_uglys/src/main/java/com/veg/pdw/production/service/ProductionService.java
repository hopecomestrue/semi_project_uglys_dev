package com.veg.pdw.production.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.veg.pdw.production.dao.ProductionDao;
import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;

public class ProductionService {
	public int insertProduction(Production p,ProductionContent pc) {
		Connection conn =getConnection();
		int result=new ProductionDao().insertProduction(conn,p)+
						new ProductionDao().insertProductionContent(conn,pc);
		if(result==2){
			rollback(conn);
			//테스트중입니
			/* commit(conn); */
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
}
