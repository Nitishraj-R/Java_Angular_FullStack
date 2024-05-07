package com.wms.service;

import java.util.List;

import com.wms.model.VendorMaster;

public interface VendorMasterService {

	void createVendor(VendorMaster vendorMaster);

	List<VendorMaster> getVendors();

	VendorMaster getVendorbyCode(String code);

}
