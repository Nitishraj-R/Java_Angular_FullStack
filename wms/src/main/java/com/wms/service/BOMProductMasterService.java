package com.wms.service;
 
import java.util.List;
 
import com.wms.dto.ConfigBOMProductMasterDto;
import com.wms.model.ConfigBOMProductMaster;
 
public interface BOMProductMasterService {
 
	ConfigBOMProductMasterDto createBOMProduct(ConfigBOMProductMasterDto bomProductDto);
 
	List<ConfigBOMProductMaster> getVendors();
 
	ConfigBOMProductMaster getConfigBonProductByCode(String code);
 
}