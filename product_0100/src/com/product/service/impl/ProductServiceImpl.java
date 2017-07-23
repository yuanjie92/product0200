package com.product.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.product.connection.ConnectionDB;
import com.product.model.ProductModel;
import com.product.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ConnectionDB connect = new ConnectionDB();
	Connection conn = connect.getConnection();

	@Override
	public Boolean add(ProductModel pro) {
		String sql = "insert into tb_product(code,name,price,count,id)values(?,?,?,?,?)";
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getCode());
			ps.setString(2, pro.getName());
			ps.setDouble(3, pro.getPrice());
			ps.setInt(4, pro.getCount());
			ps.setInt(5, pro.getId());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean delete() {

		return null;
	}

	@Override
	public Boolean update(ProductModel pro) {
		String sql = "update tb_product set code=?,name=?,price=?,count=?";
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getCode());
			ps.setString(2, pro.getName());
			ps.setDouble(3, pro.getPrice());
			ps.setInt(4, pro.getCount());
			

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ProductModel> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
