package com.veg.pdw.production.dao;

import static com.veg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.veg.pdw.production.model.dto.Production;
import com.veg.pdw.production.model.dto.ProductionContent;

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
	public int insertProductionContent(Connection conn,ProductionContent pc) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(sql.getProperty("insertProductionContent"));
			pstmt.setString(1, pc.getProductionContent());
			pstmt.setString(2, pc.getProductionImg());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public List<Production> selectProductions(Connection conn, int cPage,int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		List<Production> result = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductions"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(getProduction(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	public int selectProductionsCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProductionsCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}return result;
		
	}
	private Production getProduction(ResultSet rs)throws SQLException{
		return Production.builder()
						.production_no(rs.getInt("PRODUCT_NO"))
						.production_name(rs.getString("PRODUCTION_NAME"))
						.discount(rs.getInt("DISCOUNT"))
						.price(rs.getInt("PRICE"))
						.tag(rs.getString("PRODUCT_TAG"))
						.environment(rs.getString("ENVIRONMENT"))
						.place(rs.getString("PLACE"))
						.production_date(rs.getDate("PRODUCTION_DATE"))
						.stock(rs.getInt("STOCK"))
						.build();
	}
}
