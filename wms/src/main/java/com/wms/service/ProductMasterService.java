package com.wms.service;

import java.util.List;

import com.wms.model.ProductMaster;

public interface ProductMasterService {

	ProductMaster createProduct(ProductMaster productMaster);


	List<ProductMaster> getProducts();



	ProductMaster getProductByProductId(String productId);
	
	ProductMaster updateProduct(ProductMaster product);
	
	ProductMaster deleteProduct(String id);

}
