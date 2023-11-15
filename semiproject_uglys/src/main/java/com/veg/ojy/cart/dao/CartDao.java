package com.veg.ojy.cart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.veg.ojy.cart.dto.Cart;

public class CartDao {
//	public void insertCart(Cart cart) {
//		//장바구니에 db 정보 추가
//		try (Connection conn = ((Statement) conn).getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(
//	                  "INSERT INTO cart (cartNo, memberNo, productNo, count)"
//	                        + "VALUES (?, ?, ?, ?)")) {
//
//	         preparedStatement.setInt(1, cart.getCartNo());
//	         preparedStatement.setInt(2, cart.getMemberNo());
//	         preparedStatement.setInt(3, cart.getProductNo());
//	         preparedStatement.setInt(4, cart.getCount());
//	         preparedStatement.executeUpdate();
//
//	      } catch (SQLException e) {
//	         e.printStackTrace(); 
//	      }
	   }

