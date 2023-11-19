package com.veg.ojy.cart.service;

import java.sql.Connection;

import com.veg.ojy.cart.dao.ProductCartDao;
import com.veg.pdw.production.model.dto.Production;
import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;

public class CartService {
	public Production getProudctCart(String productName) {

		/* DB 처리
		 * 1. 커넥션 객체 생성
		 * 2. 글 번호에 해당하는 글의 정보를 리턴하는 메서드 호출
		 * */
		Connection conn = getConnection();
		ProductCartDao productcartDao = ProductCartDao.getInstance();
		productcartDao.setConnection(conn);
		
		Production production =productcartDao.selectProduction(productName);
		
		close(conn);
		return production;
	}


}
