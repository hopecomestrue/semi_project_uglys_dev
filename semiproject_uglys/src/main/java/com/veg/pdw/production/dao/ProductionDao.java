package com.veg.pdw.production.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


import com.veg.pdw.production.model.dto.Production;



import static com.veg.common.JDBCTemplate.*;

public class ProductionDao {
	private Properties sql = new Properties();
	
	{
		String path=ProductionDao.class.getResource("/production/register/production.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public int insertProduction(Connection conn,Production p) {
		
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(sql.getProperty("insertProduction"));
			pstmt.setString(1, p.getProduction_name());
			pstmt.setInt(2,p.getDiscount());
			pstmt.setInt(3,p.getPrice());
			pstmt.setString(4, p.getTag());
			pstmt.setString(5, p.getEnvironment());
			pstmt.setString(6, p.getPlace());
			pstmt.setInt(7, p.getStock());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
