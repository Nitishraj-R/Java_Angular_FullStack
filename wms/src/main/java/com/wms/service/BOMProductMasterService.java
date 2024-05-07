package com.wms.service;

import java.util.List;

import com.wms.model.ConfigBOMProductMaster;

public interface BOMProductMasterService {

	void createBOMProduct(ConfigBOMProductMaster bomProduct);

	List<ConfigBOMProductMaster> getVendors();

	ConfigBOMProductMaster getConfigBonProductByCode(String code);

}
