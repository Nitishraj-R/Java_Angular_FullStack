package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.ConfigBOMProductMaster;


public interface BOMProductMasterRepository extends JpaRepository<ConfigBOMProductMaster, Long> {
	
//	ConfigBOMProductMaster getCode(String code);

}
