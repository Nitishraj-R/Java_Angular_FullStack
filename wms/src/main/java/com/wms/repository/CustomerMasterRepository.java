package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.CustomerMaster;


public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {
	
//	CustomerMaster getCode(String code);

}
