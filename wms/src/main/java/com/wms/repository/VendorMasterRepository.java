package com.wms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wms.model.VendorMaster;

@Repository
public interface VendorMasterRepository extends CrudRepository<VendorMaster, Long> {
	
	VendorMaster getVendorCode(String vendorCode);

}
