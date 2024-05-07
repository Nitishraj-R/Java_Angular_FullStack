package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.VendorMaster;
import com.wms.repository.VendorMasterRepository;
import com.wms.service.VendorMasterService;

@Service
public class VendorMasterServiceImpl implements VendorMasterService{
	
	@Autowired
	private VendorMasterRepository vendorMasterRepository;

	@Override
	public void createVendor(VendorMaster vendorMaster) {
		vendorMasterRepository.save(vendorMaster);
		
	}

	@Override
	public List<VendorMaster> getVendors() {
		return (List<VendorMaster>)vendorMasterRepository.findAll();
	}

	
	@Override
	public VendorMaster getVendorbyCode(String code) {
		return vendorMasterRepository.getVendorCode(code);
	}

}
