package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wms.model.ConfigBOMProductMaster;


public interface ConfigBOMProductMasterRepository extends JpaRepository<ConfigBOMProductMaster, Long> {
	
//	ConfigBOMProductMaster getCode(String code);

}
