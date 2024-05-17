package com.wms.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.ProductMaster;


@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {

	ProductMaster findByProductId(String productCode);

	Optional<ProductMaster>  findBySkuNumber(String skuNumber);

	List<ProductMaster> findByStatusTrue();	
	
	List<ProductMaster> findByProductIdOrProductNameOrSkuNumberOrManufacturerOrCategoryOrProductidType(
			String productId,
			String productName,
			String skuNumber,
			String manufacturer,
			String category,
			String productidType);
	



}
