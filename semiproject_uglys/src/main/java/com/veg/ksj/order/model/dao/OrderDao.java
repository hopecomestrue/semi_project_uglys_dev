package com.veg.ksj.order.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class OrderDao {

	private Properties sql=new Properties();
	
	{
		String path=OrderDao.class
				.getResource("/sql/order/order_sql.properties").getPath();
		try(FileReader fr=new FileReader(path)){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
