package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wms.model.ProductMaster;


public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {
	
//	ProductMaster getCode(String vendorCode);

}
