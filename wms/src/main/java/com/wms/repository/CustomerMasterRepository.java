package com.wms.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.CustomerMaster;


public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {
	
	Optional<List<CustomerMaster>> findByStatus(boolean status);

	Optional<CustomerMaster> findByCustomerCode(String customerCode);

}
