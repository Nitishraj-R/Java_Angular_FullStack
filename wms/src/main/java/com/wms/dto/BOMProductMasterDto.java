package com.wms.dto;

import com.wms.model.ConfigBOMProductMaster;
import com.wms.model.ProductMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BOMProductMasterDto {

private Long id;
	
	private Integer qty;
	
	private ProductMaster productMaster;
	
	private ConfigBOMProductMaster configMaster;
}
