package com.product.service;

import java.util.List;

import com.product.model.ProductModel;

public interface ProductService {
	// 增
	Boolean add(ProductModel pro);

	// 删
	Boolean delete();

	// 改
	Boolean update(ProductModel pro);

	// 查
	List<ProductModel> query();

	//增
	Boolean add();
	//删
	Boolean delete(int id);
	//通过id修改count
	Boolean update(int count,int id);
	//查
	List<ProductModel> queryAll();
	//根据name查询
	List<ProductModel> queryByName(String name);
	//根据code查询
	ProductModel queryByCode(String code);
	
}
