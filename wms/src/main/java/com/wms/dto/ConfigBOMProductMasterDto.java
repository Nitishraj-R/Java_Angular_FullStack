package com.wms.dto;

import com.wms.model.ProductMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigBOMProductMasterDto {

	private Long id;
	
	private Integer qty;
	
	private ProductMaster productMaster;
	
	private ConfigBOMProductMasterDto configMaster;
}
