package com.product.model;

/*商品编号
商品类型
商品价格
商品数量
商品id*/
public class ProductModel {
	private String code;// 商品编号
	private String name;// 商品种类
	private double price;// 商品价格
	private int count;// 商品数量
	private int id;// id

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductModel() {
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductModel() {
	}
	
	@Override
	public String toString() {
		return "ProductModel [code=" + code + ", name=" + name + ", price=" + price + ", count=" + count + ", id=" + id
				+ "]";
	}
}
