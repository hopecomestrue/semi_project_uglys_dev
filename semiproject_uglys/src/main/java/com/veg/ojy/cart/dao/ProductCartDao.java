package com.veg.ojy.cart.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.veg.ojy.mypage.dao.MypageDao;
import com.veg.pdw.production.model.dto.Production;
import static com.veg.common.JDBCTemplate.close;

public class ProductCartDao {
	
	private Properties sql=new Properties();
	private Connection conn;
	{
		String path = ProductCartDao.class.getResource("/sql/cart/cart.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
    
	public List<Production> selectProduction(int production_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Production> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectProduction"));
			pstmt.setInt(1, production_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getProduction(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int insertProduction(Connection conn, Production p) {
		PreparedStatement pstmt = null;
		int result =0;
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
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Production getProduction(ResultSet rs)throws SQLException{
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

