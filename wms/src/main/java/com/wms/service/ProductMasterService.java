package com.wms.service;

import java.util.List;

import com.wms.model.ProductMaster;

public interface ProductMasterService {

	void createProduct(ProductMaster productMaster);

	List<ProductMaster> getProducts();

	ProductMaster getProductByCode(String code);

}
