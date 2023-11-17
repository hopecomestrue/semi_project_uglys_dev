package com.veg.pdw.prodution.service;

import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.veg.pdw.production.dao.ProductionDao;
import com.veg.pdw.production.model.dto.Production;

public class ProductionService {
	public int insertProduction(Production p) {
		Connection conn =getConnection();
		int result=new ProductionDao().insertProduction(conn,p);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
