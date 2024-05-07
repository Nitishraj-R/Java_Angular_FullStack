package com.wms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.ProductMaster;

@Repository
public interface ProductMasterRepository extends CrudRepository<ProductMaster, Long> {
	
	ProductMaster getCode(String vendorCode);

}
