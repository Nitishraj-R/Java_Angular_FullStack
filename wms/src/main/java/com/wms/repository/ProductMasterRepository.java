package com.wms.repository;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.ProductMaster;


public interface ProductMasterRepository extends CrudRepository<ProductMaster, Long> {
	
//	ProductMaster getCode(String vendorCode);

}
