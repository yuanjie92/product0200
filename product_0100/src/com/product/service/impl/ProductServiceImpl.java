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
	ConnectionDB connect = new ConnectionDB();
	Connection conn = connect.getConnection();
	PreparedStatement ps;
	ResultSet result;
	int ret;

	public ProductServiceImpl() {
		ConnectionDB conndb = new ConnectionDB();
		conn = conndb.getConnection();
	}


	@Override
	public Boolean add(ProductModel product) {
		String sql = "insert into tb_product (id,code,name,count,price) values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,product.getId());
			ps.setString(2,product.getCode());
			ps.setString(3,product.getName());
			ps.setInt(4,product.getCount());
			ps.setDouble(5,product.getPrice());
			ret = ps.executeUpdate();
			if(ret > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	//通过id删除数据
	public Boolean delete(int id) {
		String sql = "delete from tb_product where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ret = ps.executeUpdate();
			if(ret>0){
				return true; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

//通过id修改count(产品数量)
	public Boolean update(int count,int id) {
		String sql = "update tb_product set count=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,count);
			ps.setInt(2,id);
			ret = ps.executeUpdate();
			if(ret > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	//查询所有产品信息
	public List<ProductModel> queryAll() {
		String sql = "select * from tb_product";
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
		try {
			result.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	//通过name(产品名)查询产品信息
	public List<ProductModel> queryByName(String name) {
		String sql = "select * from tb_product where name=?";
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
		try {
			result.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	//通过code(产品编号)查询产品信息
	public ProductModel queryByCode(String code) {
		String sql = "select * from tb_product where code=?";
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
		try {
			result.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;

	}
	
	

}
