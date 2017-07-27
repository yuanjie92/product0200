package product_0100;

import com.product.model.ProductModel;
import com.product.service.impl.ProductServiceImpl;

public class ProductServicelmplTest {

	public static void main(String[] args) {
		ProductModel p = new ProductModel();
		p.setCode("orange");
		p.setName("fruit");
		p.setPrice(10);
		p.setCount(20);
		p.setId(10);
		ProductServiceImpl pro = new ProductServiceImpl();

		boolean flag = pro.add(p);
		System.out.println(flag);
	}
}
