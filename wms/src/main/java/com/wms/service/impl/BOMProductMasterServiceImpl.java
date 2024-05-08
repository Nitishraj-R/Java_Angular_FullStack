package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.ConfigBOMProductMaster;
import com.wms.repository.BOMProductMasterRepository;
import com.wms.service.BOMProductMasterService;

@Service
public class BOMProductMasterServiceImpl implements BOMProductMasterService{

	@Autowired
	private BOMProductMasterRepository bomProductMasterRepository;
	@Override
	public ConfigBOMProductMaster createBOMProduct(ConfigBOMProductMaster bomProduct) {
		return bomProductMasterRepository.save(bomProduct);
		
	}

	@Override
	public List<ConfigBOMProductMaster> getVendors() {
		return (List<ConfigBOMProductMaster>) bomProductMasterRepository.findAll();
	}

	@Override
	public ConfigBOMProductMaster getConfigBonProductByCode(String code) {
//		return bomProductMasterRepository.getCode(code);
		return null;
	}

	

}
