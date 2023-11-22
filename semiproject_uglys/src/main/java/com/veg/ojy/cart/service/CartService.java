package com.veg.ojy.cart.service;

import java.sql.Connection;
import java.util.List;

import com.veg.ojy.cart.dao.CartDao;
import com.veg.ojy.cart.dao.ProductCartDao;
import com.veg.ojy.cart.dto.Cart;
import com.veg.pdw.production.model.dto.Production;
import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;

public class CartService {
	
	private CartDao dao=new CartDao();
	
	
	public List<Cart> selectAllCart(int memberNo){
		Connection conn=getConnection();
		List<Cart> carts=dao.selectAllCart(conn,memberNo);
		close(conn);
		return carts;
	}
	
	

}
