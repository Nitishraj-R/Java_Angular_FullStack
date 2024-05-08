package com.wms.repository;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.VendorMaster;


public interface VendorMasterRepository extends CrudRepository<VendorMaster, Long> {
	
//	VendorMaster getVendorCode(String vendorCode);

}
