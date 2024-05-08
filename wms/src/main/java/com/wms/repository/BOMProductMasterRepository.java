package com.wms.repository;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.ConfigBOMProductMaster;


public interface BOMProductMasterRepository extends CrudRepository<ConfigBOMProductMaster, Long> {
	
//	ConfigBOMProductMaster getCode(String code);

}
