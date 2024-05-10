package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.CustomerMaster;


public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {
	
//	CustomerMaster getCode(String code);

}
