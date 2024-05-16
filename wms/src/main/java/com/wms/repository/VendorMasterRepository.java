package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.VendorMaster;


public interface VendorMasterRepository extends JpaRepository<VendorMaster, Long> {
	
//	VendorMaster getVendorCode(String vendorCode);

}
