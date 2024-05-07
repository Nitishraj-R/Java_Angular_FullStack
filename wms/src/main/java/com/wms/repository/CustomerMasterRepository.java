package com.wms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.CustomerMaster;

@Repository
public interface CustomerMasterRepository extends CrudRepository<CustomerMaster, Long> {
	
	CustomerMaster getCode(String code);

}
