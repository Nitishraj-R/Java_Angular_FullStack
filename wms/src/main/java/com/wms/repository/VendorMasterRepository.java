package com.wms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.VendorMaster;


public interface VendorMasterRepository extends CrudRepository<VendorMaster, Integer> {
	
	Optional<VendorMaster> findByVendorCode(String vendorCode);

	Optional<List<VendorMaster>> findByStatus(Boolean status);

}
