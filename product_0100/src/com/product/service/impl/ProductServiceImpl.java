package com.product.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.connection.ConnectionDB;
import com.product.model.ProductModel;
import com.product.service.ProductService;

public class ProductServiceImpl implements ProductService {

	PreparedStatement ps;
	Connection conn;
	ResultSet result;

	@Override
	public Boolean add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> queryAll() {
		ConnectionDB conndb = new ConnectionDB();
		String sql = "select * from tb_product";
		conn = conndb.getConnection();
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while(result.next()){
				ProductModel model = new ProductModel();
				model.setId(result.getInt("ID"));
				model.setCode(result.getString("CODE"));
				model.setCount(result.getInt("COUNT"));
				model.setPrice(result.getDouble("PRICE"));
				model.setName(result.getString("NAME"));
				list.add(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductModel> queryByName(String name) {
		ConnectionDB conndb = new ConnectionDB();
		String sql = "select * from tb_product where name=?";
		conn = conndb.getConnection();
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			result = ps.executeQuery();
			while(result.next()){
				ProductModel model = new ProductModel();
				model.setId(result.getInt("ID"));
				model.setCode(result.getString("CODE"));
				model.setCount(result.getInt("COUNT"));
				model.setPrice(result.getDouble("PRICE"));
				model.setName(result.getString("NAME"));
				list.add(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductModel queryByCode(String code) {
		ConnectionDB conndb = new ConnectionDB();
		String sql = "select * from tb_product where code=?";
		conn = conndb.getConnection();
		ProductModel model = new ProductModel();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,code);
			result = ps.executeQuery();
			while(result.next()){
				model.setId(result.getInt("ID"));
				model.setCode(result.getString("CODE"));
				model.setCount(result.getInt("COUNT"));
				model.setPrice(result.getDouble("PRICE"));
				model.setName(result.getString("NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	

}
