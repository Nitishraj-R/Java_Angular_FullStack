package com.wms.service;

import java.util.List;

import com.wms.dto.VendorMasterDto;
import com.wms.model.VendorMaster;

public interface VendorMasterService {

	VendorMasterDto createVendor(VendorMasterDto vendorMasterDto);
	
	VendorMasterDto updateVendor(VendorMasterDto vendorMasterDto);

	List<VendorMasterDto> getVendors();

	VendorMasterDto getVendorbyCode(String code);

	String deleteVendor(String vendorCode);

}
