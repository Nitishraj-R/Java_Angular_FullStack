package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.ProductMaster;
import com.wms.repository.ProductMasterRepository;
import com.wms.service.ProductMasterService;

@Service
public class ProductMasterServiceImpl implements ProductMasterService{
	
	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Override
	public ProductMaster createProduct(ProductMaster productMaster) {
	   return productMasterRepository.save(productMaster);
		
	}

	@Override
	public List<ProductMaster> getProducts() {
		return (List<ProductMaster>)productMasterRepository.findAll();
	}

	@Override
	public ProductMaster getProductByCode(String code) {
		return null;
//		return productMasterRepository.getCode(code);
	}

	

}
