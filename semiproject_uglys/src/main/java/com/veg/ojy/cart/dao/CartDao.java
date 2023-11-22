package com.veg.ojy.cart.dao;

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

import com.veg.hjj.member.dao.MemberDao;
import com.veg.hjj.member.dto.Member;
import com.veg.ojy.cart.dto.Cart;

public class CartDao {

	private Properties sql=new Properties();
	{
		String path=CartDao.class.getResource("/sql/cart/cart.properties").getPath();
		
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cart> selectAllCart(Connection conn,int memberNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Cart> carts=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllCart"));
			pstmt.setInt(1,memberNo);
			rs=pstmt.executeQuery();
			while(rs.next()) carts.add(getCart(rs));
		
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
				close(rs);
				close(pstmt);
		}return carts;
	}
	
	
	
	
	
	public static Cart getCart(ResultSet rs) throws SQLException{
		return Cart.builder()
				.cartNo(rs.getInt("CART_NO"))
				.memberNo(rs.getInt("MEMBER_NO"))
				.productNo(rs.getInt("PRODUCT_NO"))
				.count(rs.getInt("COUNT"))
				.build();
		
	}
	
}
