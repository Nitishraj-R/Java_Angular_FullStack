package com.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.ProductMaster;


public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {
	
	ProductMaster findByProductId(String productCode);
	 
	List<ProductMaster> findByStatusTrue();

}
