package com.veg.ojy.cart.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/** DAO에 Connection 객체를 넣기 */
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
    
    	/** 책 한권의 상세정보를 구하는 메서드 */
	public Production selectProduction(String production_name) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Production production = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectProduction"));
			pstmt.setString(1, production_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				production = new Production(
//						rs.getString("production_name"),
//						rs.getInt("discount"),
//						rs.getInt("price"),
//						rs.getString("tag"),
//						rs.getString("environment"),
//						rs.getString("place"),
//						rs.getInt("stock"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return production;
	}

		public static ProductCartDao getInstance() {
			// TODO Auto-generated method stub
			return null;
		}
 }

