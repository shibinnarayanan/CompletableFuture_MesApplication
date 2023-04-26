package com.svv.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Sevice {

	public Order fetchOrderFromDB(String variant) {
		Connection dbCOnnection = DBConnection.getConnection();

		try {
			PreparedStatement preparedStatement = dbCOnnection
					.prepareStatement("select top 1 OrderNo,type from OrderDetails where (variant) values (?)");
			
			preparedStatement.setString(1, variant);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Optional<ResultSet> rsOptional = Optional.ofNullable(resultSet);
			
			if(rsOptional.isPresent())
			{
			    Order order = new Order();
			    order.setOrderNo(rsOptional.get().getString(1));
			    order.setVariant(rsOptional.get().getString(2));
			    return order;
			}
			else 
				return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
