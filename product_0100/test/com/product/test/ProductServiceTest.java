package com.product.test;

import java.util.List;

import com.product.model.ProductModel;
import com.product.service.ProductService;
import com.product.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	public static void main(String[] args) {
		ProductService psi = new ProductServiceImpl();
		//查询全部
		List<ProductModel> list = psi.queryAll();
		for(ProductModel ret : list){
			System.out.println(ret);
		}
		//通过name查询
//		List<ProductModel> list = psi.queryByName("apple");
//		for(ProductModel ret : list){
//			System.out.println(ret+"\n");
//		}
		//通过code查询
//		ProductModel product = psi.queryByCode("abcd");
//		System.out.println(product);
//		通过id删除
//		boolean flag = psi.delete(12000);
//		System.out.println(flag);
		//通过id修改count
//		boolean flag = psi.update(59,10000);
//		System.out.println(flag);
		
		//插入数据
//		ProductModel product = new ProductModel();
//		product.setId(1234);
//		product.setCode("wer132");
//		product.setName("coffee");
//		product.setCount(50);
//		product.setPrice(3.0);
//		boolean flag = psi.add(product);
//		System.out.println(flag);
		System.out.println("finish");
	}
}
