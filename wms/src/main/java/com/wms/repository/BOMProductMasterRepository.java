package com.wms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.ConfigBOMProductMaster;

@Repository
public interface BOMProductMasterRepository extends CrudRepository<ConfigBOMProductMaster, Long> {
	
	ConfigBOMProductMaster getCode(String code);

}
